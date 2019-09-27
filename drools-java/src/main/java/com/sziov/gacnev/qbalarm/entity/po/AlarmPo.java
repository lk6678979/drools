package com.sziov.gacnev.qbalarm.entity.po;

import java.io.Serializable;

/**
 * 报警对象(要补充阈值设置只的字段)
 */
public class AlarmPo implements Serializable {

    private String alarmCode;

    private static final long serialVersionUID = 1L;

    public void setAlarmCode(String alarmCode) {
        this.alarmCode = alarmCode;
    }

    public String getAlarmCode() {
        return this.alarmCode;
    }
    public AlarmPo(){

    }

    public AlarmPo(String alarmCode){
        this.alarmCode = alarmCode;
    }
}
