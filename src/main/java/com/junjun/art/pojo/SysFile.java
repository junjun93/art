package com.junjun.art.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 文件表
 * </p>
 *
 * @author junjun
 * @since 2019-05-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysFile implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 文件编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 文件名
     */
    private String fileName;

    /**
     * 文件大小
     */
    private String fileSize;

    /**
     * 文件地址
     */
    private String url;

    /**
     * 操作员
     */
    private String operator;

    /**
     * 操作时间
     */
    private String operateTime;

    /**
     * 最后一次更新者的ip地址
     */
    private String operateIp;

    // 构造器为什么会影响查询 TODO
    /*public SysFile(String fileName, String fileSize) {
    }*/
}
