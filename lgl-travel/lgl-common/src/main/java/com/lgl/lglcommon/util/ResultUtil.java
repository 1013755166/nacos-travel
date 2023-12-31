package com.lgl.lglcommon.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultUtil<T> {
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 提示信息，如果有错误时，前端可以获取该字段进行提示
     */
    private String msg;
    /**
     * 查询到的结果数据，
     */
    private T data;

    public ResultUtil(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultUtil(Integer code, T data) {
        this.code = code;
        this.data = data;
    }
    public static <T> ResultUtil<T> unauthz(T data) {
        return new ResultUtil<>(401, "错啦", data);
    }
//    public Integer getCode() {
//        return code;
//    }
//
//    public void setCode(Integer code) {
//        this.code = code;
//    }
//
//    public String getMsg() {
//        return msg;
//    }
//
//    public void setMsg(String msg) {
//        this.msg = msg;
//    }
//
//    public T getData() {
//        return data;
//    }
//
//    public void setData(T data) {
//        this.data = data;
//    }
//
//    public ResponseResult(Integer code, String msg, T data) {
//        this.code = code;
//        this.msg = msg;
//        this.data = data;
//    }
}
