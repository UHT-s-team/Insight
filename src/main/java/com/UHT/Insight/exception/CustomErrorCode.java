package com.UHT.Insight.exception;

public enum CustomErrorCode implements ICustomErrorCode{
    UNKNOWN_ERROR(2100,"未知异常"),
    GAME_NOT_FIND(2001,"没有找到这个游戏"),
    NOT_AUTHORITY(2002,"权限不足"),
    ;

    private Integer code;
    private String message;

    CustomErrorCode(Integer code, String message) {
        this.message=message;
        this.code=code;
    }
    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }
}
