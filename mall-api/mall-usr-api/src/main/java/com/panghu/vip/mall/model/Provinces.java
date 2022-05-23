package com.panghu.vip.mall.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 省份信息表
 * </p>
 *
 * @author 胖虎
 * @since 2022-05-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Provinces implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 省份ID
     */
    @TableId(value = "provinceid", type = IdType.NONE)
    private String provinceid;

    /**
     * 省份名称
     */
    private String province;


}
