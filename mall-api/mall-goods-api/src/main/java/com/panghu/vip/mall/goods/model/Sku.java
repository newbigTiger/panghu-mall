package com.panghu.vip.mall.goods.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 商品表
 * </p>
 *
 * @author 胖虎
 * @since 2022-05-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sku")
@Table
public class Sku implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品id
     */
    @TableId(value = "id", type = IdType.NONE)
    private String id;

    /**
     * SKU名称
     */
    private String name;

    /**
     * 价格（分）
     */
    private Integer price;

    /**
     * 库存数量
     */
    private Integer num;

    /**
     * 商品图片
     */
    private String image;

    /**
     * 商品图片列表
     */
    private String images;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * SPUID
     */
    @Column(name = "spu_id")
    private String spuId;

    /**
     * 类目ID
     */
    @Column(name = "category_id")
    private Integer categoryId;

    /**
     * 类目名称
     */
    @Column(name = "category_name")
    private String categoryName;

    /**
     * 品牌id
     */
    @Column(name = "brand_id")
    private Integer brandId;

    /**
     * 品牌名称
     */
    @Column(name = "brand_name")
    private String brandName;

    /**
     * 规格
     */
    @Column(name = "sku_attribute")
    private String skuAttribute;

    /**
     * 商品状态 1-正常，2-下架，3-删除
     */
    private Integer status;


}
