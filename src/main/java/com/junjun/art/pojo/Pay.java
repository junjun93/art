package com.junjun.art.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 支付表
 * </p>
 *
 * @author junjun
 * @since 2019-07-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Pay implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 支付编号
     */
    private String id;

    /**
     * 用户编号
     */
    private String userId;

    /**
     * 支付金额
     */
    private BigDecimal payment;

    /**
     * 收费方式
     */
    private String type;

    /**
     * 收款人
     */
    private Integer payee;

    /**
     * 支付状态，0：无效(退款)，1：有效
     */
    private String status;

    /**
     * 备注
     */
    private String remark;

    /**
     * 操作者
     */
    private String operator;

    /**
     * 最后一次更新时间
     */
    private LocalDateTime operateTime;

    /**
     * 最后一次更新者的ip地址
     */
    private String operateIp;


}
