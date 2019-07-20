package com.junjun.art.pojo;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 作品信息表
 * </p>
 *
 * @author junjun
 * @since 2019-07-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ArtInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 作品编号
     */
    private String id;

    /**
     * 用户编号
     */
    private String userId;

    /**
     * 图片地址
     */
    private String url;

    /**
     * 作品状态，0：售卖中，1：已售卖
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
