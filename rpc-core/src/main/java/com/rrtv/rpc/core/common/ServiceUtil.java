package com.rrtv.rpc.core.common;

/**
 * @author dengzhifu
 */
public class ServiceUtil {


    public static String serviceKey(String serviceName, String version) {
        return String.join("-", serviceName, version);
    }

}
