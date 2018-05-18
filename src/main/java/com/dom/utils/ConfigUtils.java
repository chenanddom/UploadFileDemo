package com.dom.utils;

import org.springframework.core.env.Environment;

/**
 * Created by chendom on 2017/02/24.
 *
 */
public class ConfigUtils {
    public static String getProperty(String key, String defaultValue) {
        String result = defaultValue;
        Environment environment = SpringUtils.getBean(Environment.class);
        if (environment != null) {
            result = environment.getProperty(key, defaultValue);
        }

        return result;
    }
}
