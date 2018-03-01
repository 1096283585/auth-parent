package com.wugeek.auth.service.service.impl.basic;

import com.wugeek.auth.api.model.po.PermissionCategoryPo;
import com.wugeek.auth.api.service.basic.PermissionCategoryService;
import com.wugeek.auth.service.dao.sub.SimplePermissionCategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.web.service.service.BasicCURDServiceImpl;

/**
 * Created by guoshixiong on 2017/6/27.
 * <p>
 * version: 1.0
 */
@Service
public class PermissionCategoryServiceImpl extends BasicCURDServiceImpl<PermissionCategoryPo, Integer> implements PermissionCategoryService {

    @Autowired
    SimplePermissionCategoryDao simplePermissionCategoryDao;

    public PermissionCategoryServiceImpl(@Autowired SimplePermissionCategoryDao simplePermissionCategoryDao) {
        setBasicCRUDDao(simplePermissionCategoryDao);
    }
}
