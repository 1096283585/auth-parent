package com.wugeek.auth.web.aop;

import com.wugeek.auth.api.service.AuthService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
public class Interceptor {

    @Value("${auth}")
    public String auth;

    @Autowired
    AuthService authService;

    @Pointcut(
            "execution(* pers.web.service.controller.*.*(..)) ||" +
            "execution(* com.wugeek.auth.web.controller..*.*(..)) &&" +
            "!execution(* com.wugeek.auth.web.controller.basic.UserController.create(..)) &&" +
            "!execution(* com.wugeek.auth.web.controller.complex.LoginController.*(..))"
    )
    public void pointCut() {
    }

    @Around("pointCut()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //获取请求体
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        //获取token
        String token = request.getHeader("token");
        //获取uti
        String uri = request.getRequestURI();
        //获取method(大写)
        String method = request.getMethod();

        boolean flag;
        switch (auth) {
            case "true":
                //验证token
                flag = authService.auth(token, uri, method);
                break;
            case "false":
                flag = true;
                break;
            default:
                flag = false;
                break;
        }
        System.out.println("[ interceptor ]");

        if (flag) {
            return proceedingJoinPoint.proceed();
        }
        return "{\n" +
               "    \"status\": 1,\n" +
               "    \"msg\": \"false\"\n" +
               "}";
    }
}
