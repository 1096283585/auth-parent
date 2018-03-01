package com.wugeek.auth.web.controller.basic;

import com.wugeek.auth.api.model.po.ApiPo;
import com.wugeek.auth.api.service.basic.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.web.service.controller.BasicCRUDController;

/**
 * Created by guoshixiong on 2017/6/23.
 * <p>
 * version: 1.0
 */
@RestController
@RequestMapping("/api/v1.0/api")
public class ApiController extends BasicCRUDController<ApiPo, Integer> {

    public ApiController(@Autowired ApiService apiService) {
        setBasicCURDService(apiService);
    }
}
