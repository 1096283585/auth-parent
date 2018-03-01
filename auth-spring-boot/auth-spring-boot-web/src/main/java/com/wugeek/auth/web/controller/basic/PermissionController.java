package com.wugeek.auth.web.controller.basic;

import com.wugeek.auth.api.model.po.PermissionPo;
import com.wugeek.auth.api.service.basic.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.web.service.controller.BasicCRUDController;
import pers.web.service.model.vo.MessageVo;
import pers.web.service.model.vo.ServiceVo;

/**
 * Created by guoshixiong on 2017/6/23.
 * <p>
 * version: 1.0
 */
@RestController
@RequestMapping("/api/v1.0/permission")
public class PermissionController extends BasicCRUDController<PermissionPo, Integer> {

    @Autowired
    PermissionService permissionService;

    public PermissionController(@Autowired PermissionService permissionService) {
        setBasicCURDService(permissionService);
    }

    @GetMapping("/apis/{id}")
    public Object retrieveApi(@PathVariable Integer id) {
        MessageVo messageVo = new MessageVo();

        ServiceVo serviceVo = permissionService.retrieveApiByPermissionId(id);

        messageVo.setResult(serviceVo.getResults());

        return messageVo;
    }
}
