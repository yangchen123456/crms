package com.bh.crms.service;

import com.bh.crms.dao.CrmsDao;
import com.bh.crms.pojo.Crms;
import org.springframework.stereotype.Service;

@Service
/**
 * 根据id删除
 */
public class DeleteService {
    public int deleteById(String id){
       return CrmsDao.deleteById(id);
    }
}
