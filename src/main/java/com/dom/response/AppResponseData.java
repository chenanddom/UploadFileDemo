package com.dom.response;

import com.dom.rootbean.ResponseData;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: chendom
 * Date: 2018-04-02
 * Time: 14:59
 */
public class AppResponseData<T> extends ResponseData<T> {

    public AppResponseData() {
    }

    public AppResponseData(T data) {
        super(data);
    }

    public AppResponseData(int code, String retMessage) {
        super(code, retMessage);
    }

    public AppResponseData(T data, String retMessage) {
        super(data, retMessage);
    }

    public AppResponseData(T data, int code, String retMessage) {
        super(data, code, retMessage);
    }
    public static <T>AppResponseData<T> success(T data,String retMessage) {
        return new AppResponseData<T>(data,200,retMessage);
    }
    public static <T>AppResponseData<T> failure(int code,String retMessage){
        return new AppResponseData<T>(code,retMessage);
    }
}
