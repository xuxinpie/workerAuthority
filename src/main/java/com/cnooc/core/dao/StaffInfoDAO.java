/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package com.cnooc.core.dao;

import com.cnooc.core.model.StaffInfo;

import java.util.List;

/**
 *
 * 员工信息DAO
 *
 * @author Xinux
 * @version $Id: StaffInfoDAO.java, v 0.1 2015-12-24 10:06 AM Xinux Exp $$
 */
public interface StaffInfoDAO {

    /**
     * 插入一条员工数据
     *
     * @param staffInfo
     */
    public int insertStaffInfo(StaffInfo staffInfo);

    /**
     * 根据员工工号查找对应员工，一个员工唯一对应一个staffId
     *
     * @param staffId
     * @return
     */
    public StaffInfo findStaffInfoById(String staffId);

    /**
     * 查找全部员工
     *
     * @return
     */
    public List<StaffInfo> findAllStaffInfos();

    /**
     * 更新员工信息
     *
     * @param staffInfo
     */
    public int updateStaffInfoInfo(StaffInfo staffInfo);

    /**
     * 根据员工工号删除一个员工
     *
     * @param staffId
     */
    public int deleteStaffInfoById(String staffId);

    /**
     * 根据员工姓名查找对应的员工列表
     *
     * @param staffName
     * @return
     */
    public List<StaffInfo> findStaffInfoByName(String staffName);

    /**
     *
     * 统计所有员工信息数量
     *
     * @return
     */
    public long countAllStaffInfo();

    /**
     *
     * 根据权限号分页查询对应的员工信息列表
     *
     * @param authorityNo
     * @param startRow
     * @param pageSize
     * @return
     */
    public List<StaffInfo> paginateStaffInfoByAuthorityNO(String authorityNo, int startRow, int pageSize);

    /**
     *
     * 根据权限号查询对应的所有员工
     *
     * @param authorityNo
     * @return
     */
    public List<StaffInfo> findAllStaffInfoByAuthorityNO(String authorityNo);

}