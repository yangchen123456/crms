package com.bh.crms.service;

import com.bh.crms.dao.AddDao;
import com.bh.crms.pojo.Crms;
import org.springframework.stereotype.Service;

@Service
public class AddServiceImpl {

    /**
     * 添加客户
     * @return
     */
    public int add(Crms crms) {
        return AddDao.add(crms);
    }
}
