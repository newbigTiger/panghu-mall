package com.panghu.vip.mall.cart.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

/**
 * @author 胖虎
 * @date 2022/5/23 下午 4:12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    @Id
    private String _id; //主键
    private String userName; //用户名称
    private String name; //商品名称
    private Integer price; //商品单价
    private String image; //商品图片
    private String skuId; //商品的id
    private Integer num; // 购物车购买数量
}
