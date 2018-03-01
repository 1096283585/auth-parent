package com.wugeek.auth.web.controller.basic;

import com.wugeek.auth.api.model.po.PermissionCategoryPo;
import com.wugeek.auth.api.service.basic.PermissionCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.web.service.controller.BasicCRUDController;

/**
 * Created by guoshixiong on 2017/6/27.
 * <p>
 * version: 1.0
 */
@RestController
@RequestMapping("/api/v1.0/permission_category")
public class PermissionCategoryController extends BasicCRUDController<PermissionCategoryPo, Integer> {

    @Autowired
    PermissionCategoryService permissionCategoryService;

    public PermissionCategoryController(@Autowired PermissionCategoryService permissionCategoryService) {
        setBasicCURDService(permissionCategoryService);
    }
}
