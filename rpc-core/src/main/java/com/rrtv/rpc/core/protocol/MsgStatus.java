package com.rrtv.rpc.core.protocol;

import lombok.Getter;

/**
 * 请求状态
 * @author dengzhifu
 */
public enum MsgStatus {
    /**
     * 成功
     */
    SUCCESS((byte)0),
    /**
     * 失败
     */
    FAIL((byte)1);

    @Getter
    private final byte code;

    MsgStatus(byte code) {
        this.code = code;
    }

    public static boolean isSuccess(byte code){
        return MsgStatus.SUCCESS.code == code;
    }

}
