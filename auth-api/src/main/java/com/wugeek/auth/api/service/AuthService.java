package com.wugeek.auth.api.service;

/**
 * Created by guoshixiong on 2017/6/29.
 * <p>
 * version: 1.0
 */
public interface AuthService {

    boolean auth(String token, String uri, String method);
}
