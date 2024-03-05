package com.zhang.weblog.dao.impl;

import com.zhang.weblog.dao.AvgPvNumDao;
import com.zhang.weblog.domain.AvgPvNum;
import com.zhang.weblog.utils.DbUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AvgPvNumDaoImpl implements AvgPvNumDao {

    @Override
    public List<AvgPvNum> queryAvgPvNumList() {

        List<AvgPvNum> avgPvNumList = new ArrayList<>();

        Connection connection = DbUtils.openConn();

        try {
            Statement pstmt = connection.createStatement();
            String querySql = "select * from t_avgpv_num";
            ResultSet rs = pstmt.executeQuery(querySql);

            while (rs.next()) {
                Long id = rs.getLong(1);
                String dateStr = rs.getString(2);
                Float avgPvNum = rs.getFloat(3);

                AvgPvNum outAvgPvNum = new AvgPvNum();
                outAvgPvNum.setId(id);
                outAvgPvNum.setDateStr(dateStr);
                outAvgPvNum.setAvgPvNum(avgPvNum);

                avgPvNumList.add(outAvgPvNum);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return avgPvNumList;
    }
}