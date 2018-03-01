package com.wugeek.auth.service.service.impl;

import com.wugeek.auth.api.model.po.ApiPo;
import com.wugeek.auth.api.model.po.TokenPo;
import com.wugeek.auth.api.service.AuthService;
import com.wugeek.auth.service.dao.sub.SimpleTokenDao;
import com.wugeek.auth.service.dao.unit.UserApiUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by guoshixiong on 2017/6/29.
 * <p>
 * version: 1.0
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    SimpleTokenDao simpleTokenDao;
    @Autowired
    UserApiUnit userApiUnit;

    @Override
    public boolean auth(String token, String uri, String method) {
        if (token == null) {
            return false;
        }

        TokenPo tokenPo = simpleTokenDao.selectByToken(token);
        if (tokenPo == null) {
            return false;
        }
        int userId = tokenPo.getUserId();

        List<ApiPo> apis = userApiUnit.selectByUserId(userId);

        uri = uri.replace("/", "");
        for (ApiPo apiPo : apis) {
            String inherentUri = apiPo.getApiUrl().replace("*", ".+").replace("/", "");
            String inherentMethod = apiPo.getApiHttpMethod().toUpperCase().replace("*", ".+");

            boolean uriIsMatch = Pattern.matches(inherentUri, uri);
            if (uriIsMatch) {
                boolean methodIsMatch = Pattern.matches(inherentMethod, method);
                if (methodIsMatch) {
                    return true;
                }
            }
        }

        return false;
    }
}
