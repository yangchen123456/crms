package com.bh.crms.service;

import com.bh.crms.dao.CrmsDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllService {
    /**
     * 查询所有客户信息
     * @return
     */
    public List findAll(){
        return  CrmsDao.findAll();
    }
}
