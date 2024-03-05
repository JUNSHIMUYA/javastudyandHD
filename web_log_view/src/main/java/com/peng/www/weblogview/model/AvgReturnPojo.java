package com.peng.www.weblogview.model;

import java.util.List;

/**
 * @author peng_it_2011
 * 数据传输pojo模型，用于封装服务端发送给客户端页面的数据
 */
public class AvgReturnPojo {
    private List<String> dates;
    private List<String> data;

    public List<String> getDates() {
        return dates;
    }

    public void setDates(List<String> dates) {
        this.dates = dates;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
