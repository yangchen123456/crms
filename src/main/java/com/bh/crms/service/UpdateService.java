package com.bh.crms.service;

import com.bh.crms.dao.CrmsDao;
import com.bh.crms.pojo.Crms;
import org.springframework.stereotype.Service;

@Service
public class UpdateService {
    /**
     * 根据id修改
     * @param crms
     * @return
     */
    public Integer updateById(Crms crms){
        return CrmsDao.updateById(crms);
    }
}
