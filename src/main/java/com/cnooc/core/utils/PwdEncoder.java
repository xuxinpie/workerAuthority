/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package com.cnooc.core.utils;

import org.apache.commons.codec.binary.Hex;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * MD5密码加密工具类
 *
 * @author Xinux
 * @version $Id: PwdEncoder.java, v 0.1 2015-12-29 11:44 AM Xinux Exp $$
 */
public class PwdEncoder {

    /**
     * 混淆码
     * 加入经过MD5加密之后的密码中,防止破解。
     */
    private String defaultSalt;

    /**
     *
     * 对密码进行MD5进行加密处理
     *
     * @param rawPass
     * @return
     */
    public String encodePassword(String rawPass) {
        return encodePassword(rawPass, defaultSalt);
    }

    /**
     *
     * 对密码进行MD5加密处理
     *
     * @param rawPass
     * @param salt
     * @return
     */
    public String encodePassword(String rawPass, String salt) {
        String saltedPass = mergePasswordAndSalt(rawPass, salt, false);
        MessageDigest messageDigest = getMessageDigest();
        byte[] digest;
        try {
            digest = messageDigest.digest(saltedPass.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("UTF-8 not supported!");
        }
        return new String(Hex.encodeHex(digest));
    }

    /**
     * 对密码进行混淆
     * @param password
     * @param salt
     * @param strict
     * @return
     */
    private String mergePasswordAndSalt(String password, Object salt, boolean strict) {
        if (password == null) {
            password = "";
        }
        if (strict && (salt != null)) {
            if ((salt.toString().lastIndexOf("{") != -1)
                    || (salt.toString().lastIndexOf("}") != -1)) {
                throw new IllegalArgumentException("Cannot use { or } in salt.toString()");
            }
        }
        if ((salt == null) || "".equals(salt)) {
            return password;
        } else {
            return password + "{" + salt.toString() + "}";
        }
    }

    /**
     *
     * 密码校验
     *
     * @param encPass
     * @param rawPass
     * @return
     */
    public boolean isPasswordValid(String encPass, String rawPass) {
        return isPasswordValid(encPass, rawPass, defaultSalt);
    }

    /**
     *
     * 密码校验
     *
     * @param encPass
     * @param rawPass
     * @param salt
     * @return
     */
    public boolean isPasswordValid(String encPass, String rawPass, String salt) {
        if (encPass == null) {
            return false;
        }
        String pass2 = encodePassword(rawPass, salt);
        return encPass.equals(pass2);
    }

    /**
     * 返回指定算法的messageDigest对象
     * @return
     */
    private final MessageDigest getMessageDigest() {
        String algorithm = "MD5";
        try {
            return MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException("No such algorithm [" + algorithm + "]");
        }
    }

    /**
     * Setter method for property defaultSalt.
     *
     * @param defaultSalt value to be assigned to property defaultSalt
     */
    public void setDefaultSalt(String defaultSalt) {
        this.defaultSalt = defaultSalt;
    }
}