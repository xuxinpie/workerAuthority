/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.cnooc.common.logging;

import java.text.MessageFormat;

/**
 *
 * 规范化日志打印工具。
 *
 * <p>注意日志的级别选择:

 * <ol>
 *  <li>DEBUG <b>开发环境</b>应用调试，输出详细的应用状态。
 *  <li>INFO  <b>生产环境</b>运行状态观察，输出应用生命周期的中<b>正常重要事件</b>。
 *  <li>WARN  <b>生产环境</b>故障诊断，输出应用中的<b>可预期的异常事件</b>。
 *  <li>ERROR <b>生产环境</b>境故障诊断，输出应用中的<b>未预期的异常事件</b>。
 * </ol>
 *
 * @author Xinux
 * @version $Id: LogUtil.java, v 0.1 2016-01-04 3:00 PM Xinux Exp $$
 */
public final class LogUtil {

    /**
     * 防止实例化。
     */
    private LogUtil() {
    }

    /**
     * <p>生成调试级别日志</p>
     * <p>
     * 根据带参数的日志模板和参数集合，生成debug级别日志
     * 带参数的日志模板中以{数字}表示待替换为变量的日志点，如a={0}，表示用参数集合中index为0的参数替换{0}处
     * </p>
     * @param logger        logger引用
     * @param template      带参数的日志模板
     * @param parameters    参数集合
     */
    public static void debug(Logger logger, String template, Object... parameters) {
        if (logger.isDebugEnabled()) {
            logger.debug(MessageFormat.format(template, parameters));
        }
    }

    /**
     * <p>生成通知级别日志</p>
     * <p>
     * 根据带参数的日志模板和参数集合，生成info级别日志
     * 带参数的日志模板中以{数字}表示待替换为变量的日志点，如a={0}，表示用参数集合中index为0的参数替换{0}处
     * </p>
     * @param logger        logger引用
     * @param template      带参数的日志模板
     * @param parameters    参数集合
     */
    public static void info(Logger logger, String template, Object... parameters) {
        if (logger.isInfoEnabled()) {
            logger.info(MessageFormat.format(template, parameters));
        }
    }

    /**
     * <p>生成警告级别日志</p>
     * <p>
     * 根据带参数的日志模板和参数集合，生成warn级别日志
     * 带参数的日志模板中以{数字}表示待替换为变量的日志点，如a={0}，表示用参数集合中index为0的参数替换{0}处
     * </p>
     * @param logger        logger引用
     * @param template      带参数的日志模板
     * @param parameters    参数集合
     */
    public static void warn(Logger logger, String template, Object... parameters) {
        logger.warn(MessageFormat.format(template, parameters));
    }

    /**
     * <p>生成警告级别日志</p>
     * <p>带异常堆栈</p>
     * @param e
     * @param logger
     * @param template
     * @param parameters
     */
    public static void warn(Throwable e, Logger logger, String template, Object... parameters) {
        logger.warn(MessageFormat.format(template, parameters), e);
    }

    /**
     * <p>生成错误级别日志</p>
     * <p>
     * 根据带参数的日志模板和参数集合，生成error级别日志
     * 带参数的日志模板中以{数字}表示待替换为变量的日志点，如a={0}，表示用参数集合中index为0的参数替换{0}处
     * </p>
     * @param e             错误异常堆栈
     * @param logger        logger引用
     * @param template      带参数的日志模板
     * @param parameters    参数集合
     */
    public static void error(Throwable e, Logger logger, String template, Object... parameters) {
        logger.error(MessageFormat.format(template, parameters), e);
    }

    /**
     * <p>生成错误级别日志</p>
     * <p>
     * 根据带参数的日志模板和参数集合，生成error级别日志
     * 带参数的日志模板中以{数字}表示待替换为变量的日志点，如a={0}，表示用参数集合中index为0的参数替换{0}处
     * </p>
     * @param logger        logger引用
     * @param template      带参数的日志模板
     * @param parameters    参数集合
     */
    public static void error(Logger logger, String template, Object... parameters) {
        logger.error(MessageFormat.format(template, parameters));
    }

}