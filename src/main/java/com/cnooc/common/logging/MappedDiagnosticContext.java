/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.cnooc.common.logging;

import java.util.Map;

/**
 *
 * 代表一个nested diagnostic context.  参见log4j的相关文档.
 *
 * @author Xinux
 * @version $Id: MappedDiagnosticContext.java, v 0.1 2016-01-04 11:46 AM Xinux Exp $$
 */
public interface MappedDiagnosticContext {

    /**
     * 在当前线程的context map中, 将指定key和指定对象相关联.
     *
     * @param key 指定key
     * @param obj 指定对象
     */
    void putMDC(String key, Object obj);

    /**
     * 从当前线程的context map中, 取得指定key所关联的对象.
     *
     * @param key 指定key
     *
     * @return 指定key所关联的对象, 如果不存在, 则返回<code>null</code>
     */
    Object getMDC(String key);

    /**
     * 从当前线程的context map中, 删除指定key所关联的对象.
     *
     * @param key 指定key
     */
    void removeMDC(String key);

    /**
     * 取得当前线程的context map.
     *
     * @return 当前线程的context map
     */
    Map getMDCContext();

}