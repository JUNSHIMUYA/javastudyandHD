package com.zhang.weblog.domain;

import java.io.Serializable;

/**
 * 日平均pv量模型
 */
public class AvgPvNum implements Serializable {
    private Long id;
    private String dateStr;
    private Float avgPvNum;

    public AvgPvNum() {

    }

    public AvgPvNum(Long id, String dateStr, Float avgPvNum) {
        this.id = id;
        this.dateStr = dateStr;
        this.avgPvNum = avgPvNum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }

    public Float getAvgPvNum() {
        return avgPvNum;
    }

    public void setAvgPvNum(Float avgPvNum) {
        this.avgPvNum = avgPvNum;
    }

    @Override
    public String toString() {
        return "AvgPvNum{" +
                "id=" + id +
                ", dateStr='" + dateStr + '\'' +
                ", avgPvNum=" + avgPvNum +
                '}';
    }
}