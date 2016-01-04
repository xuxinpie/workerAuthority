/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package com.cnooc.core.model;

import java.util.Date;

/**
 * 员工信息类_Model
 *
 * @author Xinux
 * @version $Id: StaffInfoDO.java, v 0.1 2015-12-24 12:07 AM Xinux Exp $$
 */
public class StaffInfoDO {

    /**
     * 员工工号
     */
    private String staffId;

    /**
     * 员工姓名
     */
    private String staffName;

    /**
     * 员工性别
     */
    private String sex;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 修改时间
     */
    private Date gmtModified;

    /**
     * Getter method for property staffId.
     *
     * @return property value of staffId
     */
    public String getStaffId() {
        return staffId;
    }

    /**
     * Setter method for property staffId.
     *
     * @param staffId value to be assigned to property staffId
     */
    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    /**
     * Getter method for property staffName.
     *
     * @return property value of staffName
     */
    public String getStaffName() {
        return staffName;
    }

    /**
     * Setter method for property staffName.
     *
     * @param staffName value to be assigned to property staffName
     */
    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    /**
     * Getter method for property sex.
     *
     * @return property value of sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * Setter method for property sex.
     *
     * @param sex value to be assigned to property sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * Getter method for property gmtCreate.
     *
     * @return property value of gmtCreate
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * Setter method for property gmtCreate.
     *
     * @param gmtCreate value to be assigned to property gmtCreate
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * Getter method for property gmtModified.
     *
     * @return property value of gmtModified
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * Setter method for property gmtModified.
     *
     * @param gmtModified value to be assigned to property gmtModified
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}