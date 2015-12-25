/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package com.cnooc.core.service;

import com.cnooc.core.model.StaffInfo;

import java.util.List;

/**
 *
 * 员工信息操作服务接口
 *
 * @author Xinux
 * @version $Id: StaffInfoOperationService.java, v 0.1 2015-12-24 12:04 AM Xinux Exp $$
 */
public interface StaffInfoOperationService {

    /**
     * 根据员工工号查找对应员工信息
     *
     * @param staffId
     * @return User
     */
    public StaffInfo queryStaffInfoByStaffId(String staffId);

    /**
     * 列出所有员工信息
     *
     * @return
     */
    public List<StaffInfo> queryAllStaffInfo();

    /**
     * 分页查询
     *
     * @return
     */
    public List<StaffInfo> queryStaffByAuthorityNO4PageIndex(String authorityNO, int startRow, int pageSize);

    /**
     * 添加一个员工
     *
     * @param staffInfo
     * @return
     */
    public boolean insertStaff(StaffInfo staffInfo);

    /**
     * 根据员工工号删除对应员工信息
     *
     * @param staffId
     * @return
     */
    public boolean deleteStaffInfoByStaffId(String staffId);

    /**
     * 更新员工信息
     *
     * @param staffInfo
     * @return
     */
    public boolean updateStaff(StaffInfo staffInfo);

    /**
     *
     * 统计所有员工信息数量
     *
     * @return
     */
    public long countAllStaffInfo();

    /**
     *
     * 根据权限号查询对应的所有员工
     *
     * @param authorityNo
     * @return
     */
    public List<StaffInfo> queryAllStaffInfoByAuthorityNO(String authorityNo);

}