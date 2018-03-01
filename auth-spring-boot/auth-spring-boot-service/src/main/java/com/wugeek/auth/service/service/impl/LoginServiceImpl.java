package com.wugeek.auth.service.service.impl;

import com.wugeek.auth.api.model.po.TokenPo;
import com.wugeek.auth.api.model.po.UserPo;
import com.wugeek.auth.api.service.LoginService;
import com.wugeek.auth.service.dao.sub.SimpleTokenDao;
import com.wugeek.auth.service.dao.sub.SimpleUserDao;
import com.wugeek.auth.service.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.web.service.model.vo.ServiceVo;

import java.util.Date;

/**
 * Created by guoshixiong on 2017/6/27.
 * <p>
 * version: 1.0
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    SimpleUserDao simpleUserDao;
    @Autowired
    SimpleTokenDao simpleTokenDao;

    @Override
    public ServiceVo login(UserPo userPo) {
        String authLoginName = userPo.getLoginName();
        String authPassword = userPo.getPassword();

        UserPo realUserPo = simpleUserDao.selectUserByLoginName(authLoginName);

        ServiceVo serviceVo = new ServiceVo();
        if (realUserPo == null) {
            //用户不存在
            serviceVo.setCode(1);
            serviceVo.setMessaga("用户不存在");

            return serviceVo;
        }
        String realPassword = realUserPo.getPassword();
        if (authPassword.equals(realPassword)) {
            //登陆成功
            serviceVo.setCode(0);
            serviceVo.setMessaga("登陆成功");

            TokenPo tokenPo = getToken(authLoginName);
            serviceVo.setResults(tokenPo);
        } else {
            //密码错误
            serviceVo.setCode(1);
            serviceVo.setMessaga("密码错误");
        }
        return serviceVo;
    }

    private TokenPo getToken(int userId) {
        TokenPo persistentTokenPo = simpleTokenDao.selectByUserId(userId);
        if (persistentTokenPo != null) {
            return persistentTokenPo;
        }

        String md5Token = MD5Utils.string2MD5(userId + String.valueOf(new Date().getTime()));

        TokenPo newTokenPo = new TokenPo();
        newTokenPo.setUserId(userId);
        newTokenPo.setTokenName(md5Token);
        newTokenPo.setCreateTime(new Date());
        newTokenPo.setEffectiveMinutes(10);

        simpleTokenDao.insert(newTokenPo);

        return newTokenPo;
    }

    private TokenPo getToken(String loginName) {
        UserPo userPo = simpleUserDao.selectUserByLoginName(loginName);

        Integer userId = userPo.getUserId();

        return getToken(userId);
    }

    @Override
    public ServiceVo logout(TokenPo tokenPo) {
        String token = tokenPo.getTokenName();

        int code = simpleTokenDao.deleteByToken(token);

        ServiceVo serviceVo = new ServiceVo();
        if (code == 0) {
            serviceVo.setCode(1);
            serviceVo.setMessaga("账户已经注销");
        } else {
            serviceVo.setCode(0);
            serviceVo.setMessaga("注销成功");
        }

        return serviceVo;
    }

    @Override
    public ServiceVo isLogin(TokenPo tokenPo) {
        String token = tokenPo.getTokenName();

        TokenPo statusToken = simpleTokenDao.selectByToken(token);

        ServiceVo serviceVo = new ServiceVo();
        if (statusToken == null) {
            serviceVo.setCode(1);
            serviceVo.setMessaga("未登录");
        } else {
            serviceVo.setMessaga("已登录");
        }

        return serviceVo;
    }
}
