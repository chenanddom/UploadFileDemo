package com.dom.utils;

import org.springframework.util.AntPathMatcher;
import org.springframework.util.CollectionUtils;
import org.springframework.util.PathMatcher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/***
 *URL工具类
 * @author chendom
 * @createTime 2017-03-21 17:30
 */
public class UrlUtils {
    /**
     * 进行URL地址匹配
     *
     * @param lookupPath URL访问的地址
     * @return 返回转换后的地址
     */
   /* public static String pattern(String pattern, String lookupPath) {
        if (pattern.equals(lookupPath)) {
            return pattern;
        }
        PathMatcher pathMatcher = new AntPathMatcher();
        if (pathMatcher.match(pattern, lookupPath)) {
            return pattern;
        }
        return null;
    }*/

    /**
     * 判断是否符合匹配规则
     * @param lookupPath
     * @param method
     * @param urlMethod
     * @return
     */
    public static boolean pattern(String lookupPath, String method, UrlMethod urlMethod) {
        if (urlMethod.getUrl().equals(lookupPath) && urlMethod.getMethod().equals(method)) {
            return true;
        }
        PathMatcher pathMatcher = new AntPathMatcher();
        if (pathMatcher.match(urlMethod.getUrl(), lookupPath) && method.equals(urlMethod.getMethod())) {
            return true;
        }
        return false;
    }


    /**
     * 根据访问的URL地址返回符合条件的匹配地址
     *
     * @param lookupPath 访问地址
     * @param method     访问的方法
     * @param matchs     匹配规则列表
     * @return 返回符合匹配规则的List
     */
    public static List<UrlMethod> matchList(String lookupPath, String method, List<UrlMethod> matchs) {
        List<UrlMethod> patterns = new ArrayList<UrlMethod>();
        for (UrlMethod match : matchs) {
            if (UrlUtils.pattern(lookupPath, method, match)) {
                patterns.add(match);
            }
        }
        return patterns;
    }


    /**
     * 根据访问的URL地址返回最符合条件的匹配地址
     *
     * @param lookupPath 访问地址
     * @param method     访问的方法
     * @param matchs     匹配规则列表
     * @return 返回最符合匹配规则
     */
    public static UrlMethod bestMatch(String lookupPath, String method, List<UrlMethod> matchs) {
        List<UrlMethod> patterns = UrlUtils.matchList(lookupPath, method, matchs);
        if(CollectionUtils.isEmpty(patterns)){
            return  null;
        }
        Collections.sort(patterns, new Comparator<UrlMethod>() {
            @Override
            public int compare(UrlMethod o1, UrlMethod o2) {
                if (o1.getUrl().equals(o2.getUrl()) && o1.getMethod().equals(o2.getMethod())) {
                    return 0;
                } else {
                    return o1.getUrl().length() - o2.getUrl().length();
                }
            }
        });
        return patterns.get(0);
    }

}