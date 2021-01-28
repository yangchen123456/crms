package com.bh.crms.service;

import com.bh.crms.dao.CrmsDao;
import com.bh.crms.pojo.Crms;
import org.springframework.stereotype.Service;

@Service
public class AddService {

    /**
     * 添加客户
     * @return
     */
    public int add(Crms crms) {
        return CrmsDao.add(crms);
    }

}
