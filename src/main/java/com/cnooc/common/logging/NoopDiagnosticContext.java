/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.cnooc.common.logging;

import java.util.Map;
import java.util.Stack;

/**
 * @author Xinux
 * @version $Id: NoopDiagnosticContext.java, v 0.1 2016-01-04 2:17 PM Xinux Exp $$
 */
public class NoopDiagnosticContext implements NestedDiagnosticContext, MappedDiagnosticContext {

    private static final NoopDiagnosticContext instance = new NoopDiagnosticContext();

    /**
     * 取得<code>NoopDiagnosticContext</code>的singleton.
     *
     * @return <code>NoopDiagnosticContext</code>的singleton
     */
    public static NoopDiagnosticContext getInstance() {
        return instance;
    }

    /* ============================================================================ */
    /* 以下是实现NestedDiagnosticContext接口的方法                                  */
    /* ============================================================================ */

    /**
     * 清除当前线程的堆栈.
     */
    public void clearNDC() {
    }

    /**
     * 取得当前线程的堆栈的复本.
     *
     * @return 当前线程的堆栈的复本
     */
    public Stack cloneNDCStack() {
        return new Stack();
    }

    /**
     * 取得当前线程的堆栈顶端的值.
     *
     * @return 当前线程的堆栈顶端的值
     */
    public String getNDC() {
        return null;
    }

    /**
     * 取得当前线程的堆栈深度.
     *
     * @return 当前线程的堆栈深度
     */
    public int getNDCDepth() {
        return 0;
    }

    /**
     * 继承指定的堆栈.
     *
     * @param stack 被继承的堆栈
     */
    public void inheritNDC(Stack stack) {
    }

    /**
     * 弹出当前线程的堆栈顶端的值.
     */
    public void popNDC() {
    }

    /**
     * 向当前线程的堆栈压入指定的值.
     *
     * @param s 要压入的值
     */
    public void pushNDC(String s) {
    }

    /**
     * 删除当前线程的堆栈, 创建NDC的代码有责任删除这个NDC.
     */
    public void removeNDC() {
    }

    /**
     * 如果当前线程的堆栈深度大于指定值, 则截断堆栈到指定的深度.
     *
     * @param i 最大深度
     */
    public void setNDCMaxDepth(int i) {
    }

    /* ============================================================================ */
    /* 以下是实现MappedDiagnosticContext接口的方法.                                 */
    /* ============================================================================ */

    /**
     * 在当前线程的context map中, 将指定key和指定对象相关联.
     *
     * @param key 指定key
     * @param obj 指定对象
     */
    public void putMDC(String key, Object obj) {
    }

    /**
     * 从当前线程的context map中, 取得指定key所关联的对象.
     *
     * @param key 指定key
     *
     * @return 指定key所关联的对象, 如果不存在, 则返回<code>null</code>
     */
    public Object getMDC(String key) {
        return null;
    }

    /**
     * 从当前线程的context map中, 删除指定key所关联的对象.
     *
     * @param key 指定key
     */
    public void removeMDC(String key) {
    }

    /**
     * 取得当前线程的context map.
     *
     * @return 当前线程的context map
     */
    public Map getMDCContext() {
        return null;
    }

}