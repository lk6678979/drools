package com.sziov.gacnev.qbalarm.entity.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 规则DTO，包含规则头和rule清单
 */
@Data
public class AlarmRuleDrlDto implements Serializable {
    private String head;
    List<String> rules = new ArrayList<String>();

    public void addRule(String rule) {
        rules.add(rule);
    }

    /**
     * 获取Drl文件字符串
     */
    public String getDrl() {
        StringBuilder stringBuilder = new StringBuilder(5000);
        stringBuilder.append(head);
        for (String rule : rules) {
            stringBuilder.append(rule);
        }
        return stringBuilder.toString();
    }
}
