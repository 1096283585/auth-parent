package com.wugeek.auth.api.service;

import com.wugeek.auth.api.model.po.TokenPo;
import com.wugeek.auth.api.model.po.UserPo;
import pers.web.service.model.vo.ServiceVo;

/**
 * Created by guoshixiong on 2017/6/26.
 * <p>
 * version: 1.0
 */
public interface LoginService {

    ServiceVo login(UserPo userPo);

    ServiceVo logout(TokenPo token);

    ServiceVo isLogin(TokenPo tokenPo);
}
