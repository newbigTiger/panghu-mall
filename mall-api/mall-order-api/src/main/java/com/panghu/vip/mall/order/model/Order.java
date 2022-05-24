package com.panghu.vip.mall.order.model;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
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
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单id
     */
    @TableId(value = "id", type = IdType.NONE)
    private String id;

    /**
     * 数量合计
     */
    private Integer totalNum;

    /**
     * 金额合计
     */
    private Integer moneys;

    /**
     * 支付类型，1、在线支付、0 货到付款
     */
    private String payType;

    /**
     * 订单创建时间
     */
    private LocalDateTime createTime;

    /**
     * 订单更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 付款时间
     */
    private LocalDateTime payTime;

    /**
     * 发货时间
     */
    private LocalDateTime consignTime;

    /**
     * 交易完成时间
     */
    private LocalDateTime endTime;

    /**
     * 用户名称
     */
    private String username;

    /**
     * 收货人
     */
    private String recipients;

    /**
     * 收货人手机
     */
    private String recipientsMobile;

    /**
     * 收货人地址
     */
    private String recipientsAddress;

    /**
     * 交易流水号
     */
    private String weixinTransactionId;

    /**
     * 订单状态,0:未完成,1:已完成，2：已退货
     */
    private Integer orderStatus;

    /**
     * 支付状态,0:未支付，1：已支付，2：支付失败
     */
    private Integer payStatus;

    /**
     * 是否删除
     */
    private Integer isDelete;


}
