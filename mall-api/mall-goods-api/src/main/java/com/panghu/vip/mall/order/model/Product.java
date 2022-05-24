package com.panghu.vip.mall.order.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 胖虎
 * @date 2022/5/11 下午 3:03
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    //通用属性
    private Spu spu;
    //个性化属性
    private List<Sku> skus;
}
