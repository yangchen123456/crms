package com.bh.crms.service;

import com.bh.crms.dao.CrmsDao;
import com.bh.crms.pojo.Crms;
import org.springframework.stereotype.Service;

@Service

public class DeleteService {
    /**
     * 根据id删除
     * @param id
     * @return
     */
    public int deleteById(String id){
       return CrmsDao.deleteById(id);
    }
}
