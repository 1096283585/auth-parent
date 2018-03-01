package pers.web.service.model.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by guoshixiong on 2017/6/20.
 * <p>
 * version: 1.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageVo<T> {

    private int status = 0;
    private String msg = "success";
    private T result;

    public MessageVo() {
    }

    public MessageVo(T result) {
        this.result = result;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
