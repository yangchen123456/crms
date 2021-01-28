package com.bh.crms.service;

import com.bh.crms.dao.CrmsDao;
import com.bh.crms.pojo.Crms;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueryService {
    public List query(Crms crms){
        return CrmsDao.query(crms);
    }
}
