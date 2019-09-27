package com.sziov.gacnev.qbalarm.entity.dto;

import com.sziov.gacnev.qbalarm.entity.po.GbSignPo;

import java.io.Serializable;
import java.util.List;

/**
 * 信号DTO，输入规则引擎的信号列表
 */
public class GbSignDto implements Serializable {
    private List<GbSignPo> signList;
    private static final long serialVersionUID = 1L;

    public void setSignList(List<GbSignPo> signList) {
        this.signList = signList;
    }

    public List<GbSignPo> getSignList() {
        return this.signList;
    }

}
