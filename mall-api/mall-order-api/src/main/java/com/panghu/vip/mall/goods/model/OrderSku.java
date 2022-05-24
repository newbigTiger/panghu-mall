package com.panghu.vip.mall.goods.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author 胖虎
 * @since 2022-05-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class OrderSku implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.NONE)
    private String id;

    /**
     * 1级分类
     */
    private Integer categoryOneId;

    /**
     * 2级分类
     */
    private Integer categoryTwoId;

    /**
     * 3级分类
     */
    private Integer categoryThreeId;

    /**
     * SPU_ID
     */
    private String spuId;

    /**
     * SKU_ID
     */
    private String skuId;

    /**
     * 订单ID
     */
    private String orderId;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 单价
     */
    private Integer price;

    /**
     * 数量
     */
    private Integer num;

    /**
     * 总金额
     */
    private Integer money;

    /**
     * 图片地址
     */
    private String image;


}
