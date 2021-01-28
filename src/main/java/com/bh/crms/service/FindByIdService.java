package com.bh.crms.service;

import com.bh.crms.dao.CrmsDao;
import com.bh.crms.pojo.Crms;
import org.springframework.stereotype.Service;

@Service
public class FindByIdService {
    /**
     * 根据id 查询数据
     * @param id
     * @return
     */
    public Crms findById(String id){
        return CrmsDao.findById(id);
    }
}
