package pers.web.service.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import pers.web.service.model.vo.MessageVo;
import pers.web.service.model.vo.ServiceVo;

/**
 * Created by guoshixiong on 2017/6/24.
 * <p>
 * version: 1.0
 */
@CrossOrigin
public abstract class AbsController {

    public MessageVo buildMessage(ServiceVo serviceVo) {
        MessageVo messageVo = new MessageVo();

        messageVo.setStatus(serviceVo.getCode());
        messageVo.setMsg(serviceVo.getMessaga());
        messageVo.setResult(serviceVo.getResults());

        return messageVo;
    }
}
