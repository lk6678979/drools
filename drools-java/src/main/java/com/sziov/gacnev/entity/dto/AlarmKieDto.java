package com.sziov.gacnev.entity.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 信号DTO，输入规则引擎的信号列表
 */
public class AlarmKieDto implements Serializable {

    /**
     * 连续最大帧数的车辆信号
     */
    private List<Map<String, Object>> signList;

    /**
     * 车辆最后的报警信息，key：报警id，value：是否是连续报警
     */
    private Map<String, Integer> lastAlarmInfos;

    /**
     * 当前国标数据
     */
    private Map<String, Object> currGbInfo;

    /**
     * 报警校验结果
     */
    private List<AlarmDto> resultAlarm;

    private static final long serialVersionUID = 1L;

    public void setSignList(List<Map<String, Object>> signList) {
        this.signList = signList;
    }

    public List<Map<String, Object>> getSignList() {
        return this.signList;
    }

    public List<AlarmDto> getResultAlarm() {
        return resultAlarm;
    }

    public void setResultAlarm(List<AlarmDto> resultAlarm) {
        this.resultAlarm = resultAlarm;
    }

    public Map<String, Integer> getLastAlarmInfos() {
        return lastAlarmInfos;
    }

    public void setLastAlarmInfos(Map<String, Integer> lastAlarmInfos) {
        this.lastAlarmInfos = lastAlarmInfos;
    }

    public Map<String, Object> getCurrGbInfo() {
        return currGbInfo;
    }

    public void setCurrGbInfo(Map<String, Object> currGbInfo) {
        this.currGbInfo = currGbInfo;
    }
}
