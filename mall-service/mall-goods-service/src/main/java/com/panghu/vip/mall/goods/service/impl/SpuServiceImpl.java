package com.panghu.vip.mall.goods.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.panghu.vip.mall.goods.mapper.BrandMapper;
import com.panghu.vip.mall.goods.mapper.CategoryMapper;
import com.panghu.vip.mall.goods.mapper.SpuMapper;
import com.panghu.vip.mall.goods.model.*;
import com.panghu.vip.mall.goods.service.SkuService;
import com.panghu.vip.mall.goods.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 胖虎
 * @since 2022-05-10
 */
@Service
public class SpuServiceImpl extends ServiceImpl<SpuMapper, Spu> implements SpuService {

    @Autowired
    private SpuMapper spuMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private BrandMapper brandMapper;

    @Autowired
    private SkuService skuService;

    @Override
    public void save(Product product) {
        Spu spu = product.getSpu();
        spu.setIsMarketable(0);
        spu.setIsDelete(0);
        spu.setStatus(1);
        spuMapper.insert(spu);
        List<Sku> skus = product.getSkus();
        Date localDate = new Date();
        Category category = categoryMapper.selectById(spu.getCategoryThreeId());
        Brand brand = brandMapper.selectById(spu.getBrandId());
        skus.stream().forEach(item -> {
            String name = spu.getName();
            Map<String, String> map = JSON.parseObject(item.getSkuAttribute(), Map.class);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                name += " " + entry.getValue();
            }
            item.setName(name);
            //设置创建修改时间
            item.setCreateTime(localDate);
            item.setUpdateTime(localDate);
            //设置分类ID 分类名称，品牌ID 品牌名称 ，状态
            item.setCategoryId(spu.getCategoryThreeId());
            item.setCategoryName(category.getName());
            item.setBrandId(spu.getBrandId());
            item.setBrandName(brand.getName());
            item.setSpuId(spu.getId());
            item.setStatus(spu.getStatus());
        });
        skuService.saveBatch(skus);
    }

    /**
     * 根据spuId查询product
     *
     * @param id
     * @return
     */
    @Override
    public Product findBySpuId(String id) {
        //查询spu
        Spu spu = spuMapper.selectById(id);
        //查询spu对应的sku集合
        QueryWrapper<Sku> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("spu_id", spu.getId());
        List<Sku> skuList = skuService.list(queryWrapper);
        //创建一个product
        Product product = new Product();
        product.setSpu(spu);
        product.setSkus(skuList);

        return product;
    }
}
