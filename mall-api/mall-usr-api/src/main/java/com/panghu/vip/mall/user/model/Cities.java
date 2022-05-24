package com.panghu.vip.mall.user.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 行政区域地州市信息表
 * </p>
 *
 * @author 胖虎
 * @since 2022-05-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Cities implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 城市ID
     */
    @TableId(value = "cityid", type = IdType.NONE)
    private String cityid;

    /**
     * 城市名称
     */
    private String city;

    /**
     * 省份ID
     */
    private String provinceid;


}
