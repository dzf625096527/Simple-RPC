package com.rrtv.rpc.client.proxy;

import com.rrtv.rpc.client.config.RpcClientProperties;
import com.rrtv.rpc.core.discovery.DiscoveryService;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * 客户端
 * @author dengzhifu
 */
public class ClientStubProxyFactory {

    /**
     * 本地缓存，只在第一次调用的时候创建动态代理对象，创建之后使用HashMap进行缓存，再次调用的时候直接从内存中获取
     * ConcurrentHashMap能保证computeIfAbsent的线程安全
     */
    private final Map<Class<?>, Object> objectCache = new ConcurrentHashMap<>();

    /**
     * 获取代理对象
     *
     * @param clazz   接口
     * @param version 服务版本
     * @param <T>
     * @return 代理对象
     */
    public <T> T getProxy(Class<T> clazz, String version, DiscoveryService discoveryService, RpcClientProperties properties) {
        return (T) objectCache.computeIfAbsent(clazz, clz ->
                Proxy.newProxyInstance(clz.getClassLoader(), new Class[]{clz}, new ClientStubInvocationHandler(discoveryService, properties, clz, version))
        );
    }
}
