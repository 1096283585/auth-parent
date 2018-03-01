package com.wugeek.auth.service.service.impl.basic;

import com.wugeek.auth.api.model.po.ApiPo;
import com.wugeek.auth.service.dao.sub.SimpleApiDao;
import com.wugeek.auth.api.service.basic.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.web.service.service.BasicCURDServiceImpl;

/**
 * Created by guoshixiong on 2017/6/10.
 * <p>
 * version: 1.0
 */
@Service
public class ApiServiceImpl extends BasicCURDServiceImpl<ApiPo, Integer> implements ApiService {

    @Autowired
    SimpleApiDao simpleApiDao;

    public ApiServiceImpl(@Autowired SimpleApiDao simpleApiDao) {
        super.setBasicCRUDDao(simpleApiDao);
    }
}
