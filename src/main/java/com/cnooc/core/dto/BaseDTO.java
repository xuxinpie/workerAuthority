/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package com.cnooc.core.dto;

import com.cnooc.core.utils.JsonConvertUtils;

import java.io.Serializable;

/**
 *
 * 基本的数据传输模型
 *
 * @author Xinux
 * @version $Id: BaseDTO.java, v 0.1 2015-12-28 12:18 AM Xinux Exp $$
 */
public class BaseDTO implements Serializable {

    private static final long serialVersionUID = 4261096525447782272L;

    @Override
    public String toString() {
        return JsonConvertUtils.objectToJsonStr(this);
    }
}