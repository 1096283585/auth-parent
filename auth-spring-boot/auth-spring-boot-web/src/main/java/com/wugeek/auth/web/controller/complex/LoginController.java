package com.wugeek.auth.web.controller.complex;

import com.wugeek.auth.api.model.po.TokenPo;
import com.wugeek.auth.api.model.po.UserPo;
import com.wugeek.auth.api.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.web.service.controller.AbsController;
import pers.web.service.model.vo.MessageVo;
import pers.web.service.model.vo.ServiceVo;

/**
 * Created by guoshixiong on 2017/7/4.
 * <p>
 * version: 1.0
 */
@RestController
@RequestMapping("/api/v1.0")
public class LoginController extends AbsController {

    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    public Object login(@RequestBody UserPo userPo) {
        ServiceVo serviceVo = loginService.login(userPo);

        return buildMessage(serviceVo);
    }

    @PostMapping("/logout")
    public Object logout(@RequestBody TokenPo tokenPo) {
        ServiceVo serviceVo = loginService.logout(tokenPo);

        return buildMessage(serviceVo);
    }

    @PostMapping("/landState")
    public Object isLogin(@RequestBody TokenPo tokenPo) {
        ServiceVo serviceVo = loginService.isLogin(tokenPo);

        return buildMessage(serviceVo);
    }
}
