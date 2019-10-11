package com.sziov.gacnev.qbalarm.entity.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 信号DTO，输入规则引擎的信号列表
 */
public class GbSignDto2 implements Serializable {
    private List<Map<String,Object>> signList;
    private static final long serialVersionUID = 1L;

    public void setSignList(List<Map<String,Object>> signList) {
        this.signList = signList;
    }

    public List<Map<String,Object>> getSignList() {
        return this.signList;
    }

}
