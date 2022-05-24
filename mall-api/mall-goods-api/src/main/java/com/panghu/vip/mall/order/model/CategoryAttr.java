package com.panghu.vip.mall.order.model;

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
 * @since 2022-05-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CategoryAttr implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "category_id", type = IdType.NONE)
    private Integer categoryId;

    /**
     * 属性分类表
     */
    private Integer attrId;


}
