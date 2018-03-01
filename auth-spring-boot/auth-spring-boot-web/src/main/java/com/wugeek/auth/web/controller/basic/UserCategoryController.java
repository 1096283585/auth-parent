package com.wugeek.auth.web.controller.basic;

import com.wugeek.auth.api.model.po.UserCategoryPo;
import com.wugeek.auth.api.service.basic.UserCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.web.service.controller.BasicCRUDController;

/**
 * Created by guoshixiong on 2017/6/22.
 * <p>
 * version: 1.0
 */
@RestController
@RequestMapping("/api/v1.0/user_category")
public class UserCategoryController extends BasicCRUDController<UserCategoryPo, Integer> {

    public UserCategoryController(@Autowired UserCategoryService userCategoryService) {
        setBasicCURDService(userCategoryService);
    }
}
