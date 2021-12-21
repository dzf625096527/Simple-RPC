package com.rrtv.rpc.server.annotation;

import org.springframework.stereotype.Service;

import java.lang.annotation.*;

/**
 * @author dengzhifu
 * @Classname RpcService
 * @Description 暴露服务注解
 * @Date 2021/7/5 14:29
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Service
public @interface RpcService {

    /**
     *  暴露服务接口类型
     */
    Class<?> interfaceType() default Object.class;

    /**
     *  服务版本
     */
    String version() default "1.0";
}
