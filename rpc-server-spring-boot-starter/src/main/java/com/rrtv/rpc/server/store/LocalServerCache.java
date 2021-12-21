package com.rrtv.rpc.server.store;


import java.util.HashMap;
import java.util.Map;

/**
 * @Classname LocalServerCache
 * @Description 将暴露的服务缓存到本地
 * 在处理 RPC 请求时可以直接通过 cache 拿到对应的服务进行调用。避免反射实例化服务开销
 * @Date 2021/7/5 11:44
 */
public final class LocalServerCache {

    private static final Map<String, Object> SERVER_CACHE_MAP = new HashMap<>();

    public static void store(String serverName, Object server) {
        SERVER_CACHE_MAP.merge(serverName, server, (Object oldObj, Object newObj) -> newObj);
    }

    public static Object get(String serverName) {
        return SERVER_CACHE_MAP.get(serverName);
    }
}
