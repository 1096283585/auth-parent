package com.wugeek.auth.web.controller.basic;

import com.wugeek.auth.api.model.po.UserAssociateRolePo;
import com.wugeek.auth.api.model.po.UserPo;
import com.wugeek.auth.api.model.vo.ModifyPassword;
import com.wugeek.auth.api.service.basic.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.web.service.controller.BasicCRUDController;
import pers.web.service.model.vo.MessageVo;
import pers.web.service.model.vo.ServiceVo;

/**
 * Created by guoshixiong on 2017/6/20.
 * <p>
 * version: 1.0
 */
@RestController
@RequestMapping("/api/v1.0/user")
public class UserController extends BasicCRUDController<UserPo, Integer> {

    @Autowired
    UserService userService;

    public UserController(@Autowired UserService userService) {
        setBasicCURDService(userService);
    }

    @GetMapping("/by_token/{token}")
    public Object retrieve(@PathVariable String token) {
        MessageVo messageVo = new MessageVo();

        ServiceVo<UserPo> serviceVo = userService.retrieve(token);

        return buildMessage(serviceVo);
    }

    @GetMapping("/roles/{id}")
    public Object retrieveRole(@PathVariable Integer id) {
        MessageVo messageVo = new MessageVo();

        ServiceVo<UserAssociateRolePo> serviceVo = userService.retrieveRole(id);

        return buildMessage(serviceVo);
    }

    @GetMapping("/loginName/{loginName}")
    public Object retrieveByLoginName(@PathVariable String loginName) {
        ServiceVo serviceVo = userService.retrieveByLoginName(loginName);

        return buildMessage(serviceVo);
    }

    @PostMapping("/modify_password")
    public Object modifyPassword(@RequestBody ModifyPassword modifyPassword) {
        ServiceVo serviceVo = userService.modifyPassword(modifyPassword);

        return buildMessage(serviceVo);
    }

    @GetMapping("/permission/{token}")
    public Object retrievePermissions(@PathVariable String token) {
        ServiceVo serviceVo = userService.retrievePermission(token);

        return buildMessage(serviceVo);
    }
}
