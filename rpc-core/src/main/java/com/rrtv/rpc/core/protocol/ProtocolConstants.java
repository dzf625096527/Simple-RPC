package com.rrtv.rpc.core.protocol;

/**
 * 协议常量定义
 * @author dengzhifu
 */
public class ProtocolConstants {
    /**
     * 消息头大小
     */
    public static final int HEADER_TOTAL_LEN = 42;
    /**
     * 魔数
     */
    public static final short MAGIC = 0x00;
    /**
     * 版本号
     */
    public static final byte VERSION = 0x1;

    /**
     * 请求长度
     */
    public static final int REQ_LEN = 32;

}
