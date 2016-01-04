/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.cnooc.common.logging;

import java.util.Stack;

/**
 *
 * 代表一个nested diagnostic context.  参见log4j的相关文档.
 *
 * @author Xinux
 * @version $Id: NestedDiagnosticContext.java, v 0.1 2016-01-04 11:44 AM Xinux Exp $$
 */
public interface NestedDiagnosticContext {
    /**
     * 清除当前线程的堆栈.
     */
    void clearNDC();

    /**
     * 取得当前线程的堆栈的复本.
     *
     * @return 当前线程的堆栈的复本
     */
    Stack cloneNDCStack();

    /**
     * 取得当前线程的堆栈顶端的值.
     *
     * @return 当前线程的堆栈顶端的值
     */
    String getNDC();

    /**
     * 取得当前线程的堆栈深度.
     *
     * @return 当前线程的堆栈深度
     */
    int getNDCDepth();

    /**
     * 继承指定的堆栈.
     *
     * @param stack 被继承的堆栈
     */
    void inheritNDC(Stack stack);

    /**
     * 弹出当前线程的堆栈顶端的值.
     */
    void popNDC();

    /**
     * 向当前线程的堆栈压入指定的值.
     *
     * @param s 要压入的值
     */
    void pushNDC(String s);

    /**
     * 删除当前线程的堆栈, 创建NDC的代码有责任删除这个NDC.
     */
    void removeNDC();

    /**
     * 如果当前线程的堆栈深度大于指定值, 则截断堆栈到指定的深度.
     *
     * @param i 最大深度
     */
    void setNDCMaxDepth(int i);
}