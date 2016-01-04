/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.cnooc.core.enums;

import org.apache.commons.lang.StringUtils;

/**
 *
 * 放入Session中对象对应的key
 *
 * @author Xinux
 * @version $Id: SessionKeyEnum.java, v 0.1 2016-01-04 11:03 AM Xinux Exp $$
 */
public enum SessionKeyEnum {

    SESSION_USER("SESSION_USER", "用户Session");

    private String code;

    private String desc;

    /**
     *
     * private constructor
     *
     * @param code
     * @param desc
     */
    private SessionKeyEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     *
     * 根据code获得对应枚举
     *
     * @param code
     * @return
     */
    public static SessionKeyEnum getByCode(String code) {
        for (SessionKeyEnum type : SessionKeyEnum.values()) {
            if (StringUtils.equals(code, type.getCode())) {
                return type;
            }
        }
        return null;
    }

    /**
     * Getter method for property code.
     *
     * @return property value of code
     */
    public String getCode() {
        return code;
    }

    /**
     * Getter method for property desc.
     *
     * @return property value of desc
     */
    public String getDesc() {
        return desc;
    }
}