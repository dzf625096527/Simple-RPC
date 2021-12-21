package com.rrtv.rpc.core.protocol;

import lombok.Getter;

/**
 * @author dengzhifu
 */

public enum MsgType {
    /**
     * 请求
     */
    REQUEST((byte) 1),
    /**
     * 响应
     */
    RESPONSE((byte) 2);

    @Getter
    private final byte type;

    MsgType(byte type) {
        this.type = type;
    }

    public static MsgType findByType(byte type) {
        for (MsgType msgType : MsgType.values()) {
            if (msgType.getType() == type) {
                return msgType;
            }
        }
        return null;
    }
}
