package com.panghu.vip.mall.search.service;

import com.panghu.vip.mall.search.model.SkuEs;

import java.util.Map;

/**
 * @author 胖虎
 * @date 2022/5/16 下午 4:28
 */
public interface SkuSearchService {
    //搜索方法
    Map<String, Object> search(Map<String, Object> searchMap);

    //增加索引
    void add(SkuEs skuEs);

    //删除索引
    void delete(String id);

}
