package com.peng.www.weblogview.model;

import java.io.Serializable;

public class FlowNum implements Serializable {
    private Long id;
    private String data;
//    private int pVNum;
//    private int uVNum;
//    private int iPNum;
    private Long newUvNum;
    private Long visitNum;

    public FlowNum(Long id, String data, Long newUvNum, Long visitNum) {
        this.id = id;
        this.data = data;
        this.newUvNum = newUvNum;
        this.visitNum = visitNum;
    }
    public FlowNum() {

    }

    @Override
    public String toString() {
        return "FlowNum{" +
                "id=" + id +
                ", data='" + data + '\'' +
                ", newUvNum=" + newUvNum +
                ", visitNum=" + visitNum +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setNewUvNum(Long newUvNum) {
        this.newUvNum = newUvNum;
    }

    public void setVisitNum(Long visitNum) {
        this.visitNum = visitNum;
    }

    public Long getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public Long getNewUvNum() {
        return newUvNum;
    }

    public Long getVisitNum() {
        return visitNum;
    }
}
