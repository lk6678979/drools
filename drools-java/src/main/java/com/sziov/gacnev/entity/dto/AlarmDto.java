package com.sziov.gacnev.entity.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 报警对象(要补充阈值设置只的字段)
 */
public class AlarmDto implements Serializable {

    /**
     * 报警类型 0：国标，1：企标
     */
    private String dataType;

    /**
     * 故障报警编号（系统生产的唯一编号），例如：LNAA2AA18K5003978_82_1571273578000，
     * 格式：vin_规则ID_时间戳
     */
    private String alarmCode;

    /**
     * VIN码
     */
    private String vin;

    /**
     * 车型名称,例如：A26
     */
    private String vehicleTypeName;

    /**
     * 故障报警时间（报文时间）
     */
    private Date alarmTime;

    /**
     * 故障报警时间戳（报文时间）
     */
    private Date alarmTimestamp;

    /**
     * 报警等级,对应阈值设置中的报警等级,在值列表维护
     * 规则引擎写入
     */
    private String alarmLevel;

    /**
     * 报警名称编号,对应报文中的【具体信号】，在阈值设置中设置，枚举值在值列表维护
     * 规则引擎写入
     */
    private String alarmFlag;

    /**
     * 报警名称,alarm_flag对应的值列表名称
     * 规则引擎写入
     */
    private String alarmName;

    /**
     * 故障地图位置经度
     */
    private String longitude;

    /**
     * 故障地图位置纬度
     */
    private String latitude;

    /**
     * 故障地址
     */
    private String alarmAddress;

    /**
     * 故障描述
     * 规则引擎写入
     */
    private String faultDescription;

    /**
     * 处置等级
     * 规则引擎写入
     */
    private String dealLevel;

    /**
     * 处置建议
     * 规则引擎写入
     */
    private String dealAdvise;

    /**
     * 电池配置编号
     */
    private String batteryType;

    /**
     * 电池配置名称
     */
    private String batteryRemark;

    /**
     * 报警规则ID
     * 规则引擎写入
     */
    private String ruleId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 报警周期(单位秒)，国标默认10S，企标按照报警信号的最大频率算
     */
    private String signalCycle;

    /**
     * 是否自动生成工单 0:否  1:是，在阈值设置中配置
     * 规则引擎写入
     */
    private String autoGenOrder;

    /**
     * 合并报警时长 (单位分钟)，，在阈值设置中配置
     * 规则引擎写入
     */
    private Integer alarmJoinTime;

    /**
     * 生成报警标识，0：正常。1“已关闭，在阈值设置中配置，只是一个属性标识
     * 规则引擎写入
     */
    private String isNeedAlram;

    private static final long serialVersionUID = 1L;

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getAlarmCode() {

        return getVin() + "_" + getRuleId() + "_" + alarmTimestamp;
    }

    public void setAlarmCode(String alarmCode) {
        this.alarmCode = alarmCode;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getVehicleTypeName() {
        return vehicleTypeName;
    }

    public void setVehicleTypeName(String vehicleTypeName) {
        this.vehicleTypeName = vehicleTypeName;
    }

    public Date getAlarmTime() {
        return alarmTime;
    }

    public void setAlarmTime(Date alarmTime) {
        this.alarmTime = alarmTime;
    }

    public String getAlarmLevel() {
        return alarmLevel;
    }

    public void setAlarmLevel(String alarmLevel) {
        this.alarmLevel = alarmLevel;
    }

    public String getAlarmFlag() {
        return alarmFlag;
    }

    public void setAlarmFlag(String alarmFlag) {
        this.alarmFlag = alarmFlag;
    }

    public String getAlarmName() {
        return alarmName;
    }

    public void setAlarmName(String alarmName) {
        this.alarmName = alarmName;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getAlarmAddress() {
        return alarmAddress;
    }

    public void setAlarmAddress(String alarmAddress) {
        this.alarmAddress = alarmAddress;
    }

    public String getFaultDescription() {
        return faultDescription;
    }

    public void setFaultDescription(String faultDescription) {
        this.faultDescription = faultDescription;
    }

    public String getDealLevel() {
        return dealLevel;
    }

    public void setDealLevel(String dealLevel) {
        this.dealLevel = dealLevel;
    }

    public String getDealAdvise() {
        return dealAdvise;
    }

    public void setDealAdvise(String dealAdvise) {
        this.dealAdvise = dealAdvise;
    }

    public String getBatteryType() {
        return batteryType;
    }

    public void setBatteryType(String batteryType) {
        this.batteryType = batteryType;
    }

    public String getBatteryRemark() {
        return batteryRemark;
    }

    public void setBatteryRemark(String batteryRemark) {
        this.batteryRemark = batteryRemark;
    }

    public String getRuleId() {
        return ruleId;
    }

    public void setRuleId(String ruleId) {
        this.ruleId = ruleId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getSignalCycle() {
        return signalCycle;
    }

    public void setSignalCycle(String signalCycle) {
        this.signalCycle = signalCycle;
    }

    public String getAutoGenOrder() {
        return autoGenOrder;
    }

    public void setAutoGenOrder(String autoGenOrder) {
        this.autoGenOrder = autoGenOrder;
    }

    public Integer getAlarmJoinTime() {
        return alarmJoinTime;
    }

    public void setAlarmJoinTime(Integer alarmJoinTime) {
        this.alarmJoinTime = alarmJoinTime;
    }

    public String getIsNeedAlram() {
        return isNeedAlram;
    }

    public void setIsNeedAlram(String isNeedAlram) {
        this.isNeedAlram = isNeedAlram;
    }

    public Date getAlarmTimestamp() {
        return alarmTimestamp;
    }

    public void setAlarmTimestamp(Date alarmTimestamp) {
        this.alarmTimestamp = alarmTimestamp;
    }

    public AlarmDto(){

    }

    public AlarmDto(String alarmFlag, String ruleId) {
        this.alarmFlag = alarmFlag;
        this.ruleId = ruleId;
    }
}
