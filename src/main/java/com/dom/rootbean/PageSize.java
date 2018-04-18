package com.dom.rootbean;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: chendom
 * Date: 2018-04-18
 * Time: 15:06
 */
public class PageSize {
    public static int DEFAULT_PAGESIZE = 10;
    protected int page;
    protected int pageSize;

    public PageSize() {
        this.pageSize = DEFAULT_PAGESIZE;
    }

    public int getPage() {
        return this.page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
