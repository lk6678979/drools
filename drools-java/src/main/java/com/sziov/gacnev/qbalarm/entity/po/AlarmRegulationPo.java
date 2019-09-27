package com.sziov.gacnev.qbalarm.entity.po;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @描述: 报警规则表实体类
 * @公司: 
 * @作者: jiangmb
 * @版本: 1.0.0
 * @日期: 2019-09-20 17:32:22
 */
@Data
public class AlarmRegulationPo implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 车型CODE
     */
    private String vehicleTypeCode;

    /**
     * 车型
     */
    private String vehicleType;

    /**
     * 数据类型 0:国标  1:企标
     */
    private String dataType;

    /**
     * 电池类型CODE
     */
    private String batteryType;

    /**
     * 电池类型
     */
    private String batteryRemark;

    /**
     * 报警等级值列表CODE
     */
    private String alarmLevelCode;

    /**
     * 报警等级
     */
    private String alarmLevel;

    /**
     * 报警项CODE
     */
    private String alarmCode;

    /**
     * 报警项
     */
    private String alarmName;

    /**
     * 连续帧数
     */
    private Integer consecutiveFrames;

    /**
     * 异常帧数
     */
    private Integer errorFrames;

    /**
     * 是否自动生成工单 0 否  1 是
     */
    private String autoGenOrder;

    /**
     * 是否生成报警 0 否  1 是
     */
    private String autoGenAlarm;

    /**
     * 报警合并时长
     */
    private Integer mergeTime;

    /**
     * 处置建议
     */
    private String disposalAdvice;

    /**
     * 故障描述
     */
    private String faultDescription;

    /**
     * 处置等级
     */
    private String disposalLevel;

    /**
     * 处置等级CODE
     */
    private String disposalLevelCode;

    /**
     * 是否生效 0:否 1:是
     */
    private Byte isEffect;

    /**
     * 报警规制类型 0:基础报警 1:阈值报警
     */
    private String regulationType;

    /**
     * 覆盖基础规则ID
     */
    private Integer baseId;

    /**
     * 处理人部门ID
     */
    private Integer deptId;

    /**
     * 处理人
     */
    private Long dealingBy;

    /**
     * 创建人
     */
    private Long createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最后更新人
     */
    private Long updateBy;

    /**
     * 最后更新时间
     */
    private Date updateTime;

    /**
     * 是否删除 0 否  1 是
     */
    private Byte disable;

    /**
     * 判断条件
     */
    private String rule;

    private static final long serialVersionUID = 1L;

}