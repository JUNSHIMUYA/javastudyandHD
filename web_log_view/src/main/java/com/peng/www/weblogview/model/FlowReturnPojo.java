package com.peng.www.weblogview.model;

import java.util.List;

public class FlowReturnPojo {
    private List<String> dates;
    private List<Long> newNum;
    private List<Long> vNum;

    public List<String> getDates() {
        return dates;
    }

    public List<Long> getNewNum() {
        return newNum;
    }

    public List<Long> getvNum() {
        return vNum;
    }

    public void setDates(List<String> dates) {
        this.dates = dates;
    }

    public void setNewNum(List<Long> newNum) {
        this.newNum = newNum;
    }

    public void setvNum(List<Long> vNum) {
        this.vNum = vNum;
    }
}
