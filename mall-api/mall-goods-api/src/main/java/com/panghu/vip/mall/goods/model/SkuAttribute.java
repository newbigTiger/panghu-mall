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
 * @since 2022-05-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SkuAttribute implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 属性名称
     */
    private String name;

    /**
     * 属性选项
     */
    private String options;

    /**
     * 排序
     */
    private Integer sort;


}
