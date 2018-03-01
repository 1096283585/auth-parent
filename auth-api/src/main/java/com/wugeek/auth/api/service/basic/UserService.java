package com.wugeek.auth.api.service.basic;

import com.wugeek.auth.api.model.po.UserPo;
import com.wugeek.auth.api.model.vo.ModifyPassword;
import pers.web.service.model.vo.ServiceVo;
import pers.web.service.service.BasicCURDService;

/**
 * Created by guoshixiong on 2017/6/20.
 * <p>
 * version: 1.0
 */
public interface UserService extends BasicCURDService<UserPo, Integer> {

    ServiceVo retrieve(String token);

    ServiceVo retrieveRole(Integer id);

    ServiceVo retrievePermission(String token);

    ServiceVo retrieveByLoginName(String token);

    public ServiceVo modifyPassword(ModifyPassword modifyPassword);
}
