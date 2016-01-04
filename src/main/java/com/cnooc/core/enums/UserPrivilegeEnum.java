/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package com.cnooc.core.enums;

import org.apache.commons.lang.StringUtils;

/**
 *
 * 用户权限枚举
 *
 * @author Xinux
 * @version $Id: UserPrivilegeEnum.java, v 0.1 2015-12-26 11:39 AM Xinux Exp $$
 */
public enum UserPrivilegeEnum {

    ADMIN("ADMIN", "管理员"),

    COMMON("COMMON", "普通用户");

    private String code;

    private String desc;

    /**
     *
     * 私有构造函数
     *
     * @param code
     * @param desc
     */
    private UserPrivilegeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * 根据code获取对应枚举
     * @param code
     * @return
     */
    public static UserPrivilegeEnum getByCode(String code) {
        for (UserPrivilegeEnum type : UserPrivilegeEnum.values()) {
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