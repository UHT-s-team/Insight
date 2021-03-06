package com.UHT.Insight.dto;


import com.UHT.Insight.exception.CustomErrorCode;
import com.UHT.Insight.exception.CustomException;

public class ResultDTO<T> {
    private Integer code;
    private String message;
    private T data;

    public static ResultDTO errorOf(Integer code,String message){
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(code);
        resultDTO.setMessage(message);
        return resultDTO;
    }

    public static ResultDTO errorOf(CustomErrorCode errorCode) {
        return errorOf(errorCode.getCode(),errorCode.getMessage());
    }

    public static ResultDTO okOf() {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(200);
        resultDTO.setMessage("请求成功");
        return resultDTO;
    }
//    public static ResultDTO login() {
//        ResultDTO resultDTO = new ResultDTO();
//        resultDTO.setCode(200);
//        resultDTO.setMessage("登录成功");
//        return resultDTO;
//    }
//    public static ResultDTO Registration() {
//        ResultDTO resultDTO = new ResultDTO();
//        resultDTO.setCode(200);
//        resultDTO.setMessage("注册成功");
//        return resultDTO;
//    }
    public static ResultDTO UpdateUserInfo() {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(200);
        resultDTO.setMessage("信息修改成功");
        return resultDTO;
    }
    public static ResultDTO UpdatePassword() {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(201);
        resultDTO.setMessage("密码修改成功");
        return resultDTO;
    }

    public static <T>ResultDTO okOf(T t) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(200);
        resultDTO.setMessage("请求成功");
        resultDTO.setData(t);
        return resultDTO;
    }
    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    public static Object errorOf(CustomException e) {
        return errorOf(e.getCode(),e.getMessage());
    }

}
