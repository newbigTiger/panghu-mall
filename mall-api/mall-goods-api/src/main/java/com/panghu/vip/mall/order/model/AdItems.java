package com.panghu.vip.mall.order.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

/**
 * <p>
 * 
 * </p>
 *
 * @author 胖虎
 * @since 2022-05-10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class AdItems implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Integer id;

    private String name;

    /**
     * 分类，1首页推广,2列表页推广
     */
    private Integer type;

    /**
     * 展示的产品
     */
    @Column(name = "sku_id")
    private String skuId;

    /**
     * 排序
     */
    private Integer sort;


}
