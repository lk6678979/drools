package com.lk.drools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class demo {

    public static void main(String[] args) {
        Map<String,String> po1 = new HashMap();
        po1.put("INFO_TYPE_1_SIGNAL_1","1");
        Map<String,String> po2 = new HashMap<String,String>();
        po2.put("INFO_TYPE_1_SIGNAL_1","2");
        Map<String,String> po3 = new HashMap<String,String>();
        po3.put("INFO_TYPE_1_SIGNAL_1","1");
        Map<String,String> po4 = new HashMap<String,String>();
        po4.put("INFO_TYPE_1_SIGNAL_1","2");
        Map<String,String> po5 = new HashMap<String,String>();
        po5.put("INFO_TYPE_1_SIGNAL_1","1");
        Map<String,String> po6 = new HashMap<String,String>();
        po6.put("INFO_TYPE_1_SIGNAL_1","2");
        Map<String,String> po7 = new HashMap<String,String>();
        po7.put("INFO_TYPE_1_SIGNAL_1","2");
        Map<String,String> po8 = new HashMap<String,String>();
        po8.put("INFO_TYPE_1_SIGNAL_1","1");
        Map<String,String> po9 = new HashMap<String,String>();
        po9.put("INFO_TYPE_1_SIGNAL_1","2");
        Map<String,String> po10 = new HashMap<String,String>();
        po10.put("INFO_TYPE_1_SIGNAL_1","2");
        List<Map<String,String>> list = new ArrayList();
        list.add(po1);
        list.add(po2);
        list.add(po3);
        list.add(po4);
        list.add(po5);
        list.add(po6);
        list.add(po7);
        list.add(po8);
        list.add(po9);
        list.add(po10);
        System.out.println(list.lastIndexOf(po2));
    }
}
