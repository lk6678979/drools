package com.sziov.gacnev.qbalarm.entity.po;

import java.io.Serializable;

/**
 * 报文解析后的国标信号对象（这只是个demo，需要自己从写字段）
 */
public class GbSignPo implements Serializable {

    private String INFO_TYPE_1_SIGNAL_1;

    private static final long serialVersionUID = 1L;

    public void setINFO_TYPE_1_SIGNAL_1(String INFO_TYPE_1_SIGNAL_1) {
        this.INFO_TYPE_1_SIGNAL_1 = INFO_TYPE_1_SIGNAL_1;
    }

    public String getINFO_TYPE_1_SIGNAL_1() {
        return INFO_TYPE_1_SIGNAL_1;
    }
}
