package com.bh.crms.service;

import com.bh.crms.dao.CrmsDao;
import com.bh.crms.pojo.Crms;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueryService {
    /**
     * 高级搜索
     * @param crms
     * @return
     */
    public List AdvancedQuery(Crms crms){
        return CrmsDao.AdvancedQuery(crms);
    }
}
