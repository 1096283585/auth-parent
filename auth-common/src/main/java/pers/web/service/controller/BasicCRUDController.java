package pers.web.service.controller;

import org.springframework.web.bind.annotation.*;
import pers.web.service.model.vo.MessageVo;
import pers.web.service.model.vo.ServiceVo;
import pers.web.service.service.BasicCURDService;

import java.util.List;

/**
 * Created by guoshixiong on 2017/6/20.
 * <p>
 * version: 1.0
 */
public class BasicCRUDController<R, T> extends AbsController {

    BasicCURDService<R, T> basicCURDService;

    public void setBasicCURDService(BasicCURDService<R, T> basicCURDService) {
        this.basicCURDService = basicCURDService;
    }

    @PostMapping
    public Object create(@RequestBody R record) {
        MessageVo messageVo = new MessageVo();

        basicCURDService.create(record);

        return messageVo;
    }

    @DeleteMapping("/{id}")
    public Object delete(@PathVariable T id) {
        MessageVo messageVo = new MessageVo();

        basicCURDService.delete(id);

        return messageVo;
    }

    @GetMapping("/{id}")
    public Object retrieve(@PathVariable T id) {
        MessageVo<R> messageVo = new MessageVo();

        ServiceVo<R> serviceVo = basicCURDService.retrieve(id);

        messageVo.setResult(serviceVo.getResults());

        return messageVo;
    }

    @GetMapping
    public Object retrieveAll() {
        MessageVo<List<R>> messageVo = new MessageVo<>();

        ServiceVo<List<R>> serviceVo = basicCURDService.retrieveAll();

        messageVo.setResult(serviceVo.getResults());

        return messageVo;
    }

    @GetMapping("/{page}/{count}")
    public Object retrieveByPage(@PathVariable Integer page, @PathVariable Integer count) {
        MessageVo<List<R>> messageVo = new MessageVo<>();

        ServiceVo<List<R>> serviceVo = basicCURDService.retrieveByPage(page, count);

        messageVo.setResult(serviceVo.getResults());

        return messageVo;
    }

    @PutMapping("/{id}")
    public Object update(@RequestBody R record, @PathVariable Integer id) {
        MessageVo messageVo = new MessageVo();

        basicCURDService.update(record);

        return messageVo;
    }
}
