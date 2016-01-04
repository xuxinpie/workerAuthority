/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package com.cnooc.core.utils;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.Assert;

import java.util.Map;

/**
 *
 * Json格式转换
 *
 * @author Xinux
 * @version $Id: JsonConvertUtils.java, v 0.1 2015-12-27 10:46 AM Xinux Exp $$
 */
public class JsonConvertUtils {

    /**
     * 将Map转换为json格式的字符串
     *
     * @param map
     * @return
     */
    public static String mapToJsonStr(Map<String, String> map) {
        Assert.notNull(map, "map对象不能为空！");
        return JSON.toJSONString(map);
    }

    /**
     * 将java类型的对象转换为JSON格式的字符串
     *
     * @param obj
     * @return
     */
    public static String objectToJsonStr(Object obj) {
        if (obj == null) {
            return "";
        }
        return JSON.toJSONString(obj);
    }

    /**
     * 将JSON格式的字符串转换为java类型的对象或者java数组类型的对象，不包括java集合类型
     * @param jsonStr JSON格式的字符串
     * @param beanClass java类型或者java数组类型，不包括java集合类型
     * @return java类型的对象或者java数组类型的对象，不包括java集合类型的对象
     */
    public static <T> T deserialize(String jsonStr, Class<T> beanClass) {
        if (StringUtils.isBlank(jsonStr) || beanClass == null) {
            return null;
        }
        return JSON.parseObject(jsonStr, beanClass);
    }

}