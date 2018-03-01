package com.wugeek.auth.api.service.basic;

import com.wugeek.auth.api.model.po.PermissionPo;
import pers.web.service.model.vo.ServiceVo;
import pers.web.service.service.BasicCURDService;

/**
 * Created by guoshixiong on 2017/6/20.
 * <p>
 * version: 1.0
 */
public interface PermissionService extends BasicCURDService<PermissionPo, Integer> {

    ServiceVo retrieveApiByPermissionId(Integer id);
}
