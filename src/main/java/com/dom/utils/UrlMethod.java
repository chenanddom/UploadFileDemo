package com.dom.utils;

/***
 * 一句话的功能说明描述
 * @author chendom
 * @createTime 2017-04-05 10:22
 */
public final  class UrlMethod {
    public  static final String GET="GET";
    public static final String POST="POST";
    public static final String DELETE="DELETE";
    public static final String PUT="PUT";

    private String url;

    private String method;

    public UrlMethod(){}

    public UrlMethod(String url){
        this.url=url;
        this.method= UrlMethod.GET;
    }

    public UrlMethod(String url, String method){
        this.url=url;
        this.method=method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
