package com.wugeek.auth.service.service.impl.basic;

import com.wugeek.auth.api.model.po.UserCategoryPo;
import com.wugeek.auth.service.dao.sub.SimpleUserCategoryDao;
import com.wugeek.auth.api.service.basic.UserCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.web.service.service.BasicCURDServiceImpl;

/**
 * Created by guoshixiong on 2017/6/19.
 * <p>
 * version: 1.0
 */
@Service
public class UserCategoryServiceImpl extends BasicCURDServiceImpl<UserCategoryPo, Integer> implements UserCategoryService {

    @Autowired
    SimpleUserCategoryDao simpleAuthTypeDao;

    public UserCategoryServiceImpl(@Autowired SimpleUserCategoryDao simpleAuthTypeDao) {
        setBasicCRUDDao(simpleAuthTypeDao);
    }
}
