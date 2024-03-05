package com.zhang.weblog.dao;

import com.zhang.weblog.dao.impl.AvgPvNumDaoImpl;

public class FactoryDao {
    public static AvgPvNumDao createAvgPvNumDao() {
        return new AvgPvNumDaoImpl();
    }
}
