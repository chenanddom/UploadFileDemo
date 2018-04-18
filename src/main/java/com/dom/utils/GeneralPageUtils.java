package com.dom.utils;


import com.dom.rootbean.Pagination;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:通用的分页工具
 * User: chendom
 * Date: 2018-04-18
 * Time: 14:52
 */
public class GeneralPageUtils<T, R> {
    private static final Logger logger = LoggerFactory.getLogger(GeneralPageUtils.class);

    private static final GeneralPageUtils generalPageUtils = new GeneralPageUtils();

    public static GeneralPageUtils getInstance() {
        return generalPageUtils;
    }

    //函数式接口
    @FunctionalInterface
    public interface Function<T, R> {
        /**
         * 实际调用函数
         *
         * @param searBean 查询条件对象
         * @return
         */
        List<R> search(T searBean);
    }

    public interface SearchCallBack<T, R> {
        List<R> executeSearch(T conditionBean);
    }

    public void query(Pagination<R> pagination, T conditionBean, Function<T, R> c) {

        executePageQuery(new SearchCallBack<T, R>() {
            @Override
            public List<R> executeSearch(T conditionBean) {
                return c.search(conditionBean);
            }
        }, pagination, conditionBean);
    }

    private void executePageQuery(SearchCallBack<T, R> callback, Pagination<R> pagination, T conditionBean) {
        try {
            if (pagination != null) {
                PageHelper.startPage(pagination.getPage(), pagination.getPageSize(), pagination.isCount());
            }
            List<R> pageResult = callback.executeSearch(conditionBean);
            if (pagination != null) {
                if (pagination.isCount()) {
                    Page page = (Page) pageResult;
                    pagination.setRowTotal((int) page.getTotal());
                    pagination.setPageTotal(page.getPages());
                }
            }
            List<R> result = new ArrayList<R>();
            if (pageResult != null && pageResult.size() > 0) {
                result.addAll(pageResult);
            }
            pagination.setRows(result);
        } catch (Exception e) {
        logger.error("分页数据获取失败");
        }
    }
}
