package com.dom.rootbean;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: chendom
 * Date: 2018-03-30
 * Time: 10:07
 */
public class ResponseData<T> {

    private T data;

    private int code;

    private String retMessage;

    public ResponseData() {
    }

    public ResponseData(T data) {
        this.data = data;
    }

    public ResponseData(int code, String retMessage) {
        this.code = code;
        this.retMessage = retMessage;
    }

    public ResponseData(T data, String retMessage) {
        this.data = data;
        this.retMessage = retMessage;
    }

    public ResponseData(T data, int code, String retMessage) {
        this.data = data;
        this.code = code;
        this.retMessage = retMessage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getRetMessage() {
        return retMessage;
    }

    public void setRetMessage(String retMessage) {
        this.retMessage = retMessage;
    }
}
