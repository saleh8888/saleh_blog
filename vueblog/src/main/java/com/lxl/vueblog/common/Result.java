package com.lxl.vueblog.common;

import lombok.Data;

import java.io.Serializable;
@Data
public class Result implements Serializable {
    private int code;
    private String msg;
    private Object data;
    /**
     * 统一封装结果
     *
     * **/
    public static Result success(Object data){return success(200,"操作成功",data);}
    public static  Result success(int code,String msg,Object data) {
        Result reuslt = new Result();
        reuslt.setCode(200);
        reuslt.setData(data);
        reuslt.setMsg("操作成功！");
        return reuslt;
    }
    public static Result fail(String msg) { return fail(500,msg,null); }
    public static Result fail(String msg,Object data){ return fail(400,msg,data); }

    public static Result fail(int code, String msg, Object data){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }
}

