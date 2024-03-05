package com.gec.weblog.service.impl;

import com.zhang.weblog.dao.AvgPvNumDao;
import com.zhang.weblog.dao.FactoryDao;
import com.zhang.weblog.domain.AvgPvNum;
import com.zhang.weblog.service.AvgPvNumService;

import java.util.List;

public class AvgPvNumServiceImpl implements AvgPvNumService {
    private AvgPvNumDao avgPvNumDao;

    public AvgPvNumServiceImpl() {

        avgPvNumDao = FactoryDao.createAvgPvNumDao();
    }

    @Override
    public List<AvgPvNum> queryAvgPvNumList() {
        return avgPvNumDao.queryAvgPvNumList();
    }
}