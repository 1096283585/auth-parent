package pers.web.service.model.vo;

import java.io.Serializable;

/**
 * Created by guoshixiong on 2017/6/10.
 * <p>
 * version: 1.0
 */
public class ServiceVo<T> implements Serializable {

    private int code = 0;
    private String messaga = "success";
    private T results;

    public ServiceVo() {
    }

    public ServiceVo(int code) {
        this.code = code;
    }

    public ServiceVo(T results) {
        this.results = results;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessaga() {
        return messaga;
    }

    public void setMessaga(String messaga) {
        this.messaga = messaga;
    }

    public T getResults() {
        return results;
    }

    public void setResults(T results) {
        this.results = results;
    }
}
