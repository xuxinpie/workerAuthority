/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package com.cnooc.core.serviceImpl;

import com.cnooc.core.model.StaffInfoDO;
import com.cnooc.core.service.StaffInfoOperationService;

import java.util.List;

/**
 *
 * 员工信息操作服务实现类
 *
 * @author Xinux
 * @version $Id: StaffInfoOperationServiceImpl.java, v 0.1 2015-12-24 12:22 AM Xinux Exp $$
 */
public class StaffInfoOperationServiceImpl implements StaffInfoOperationService {

    @Override
    public StaffInfoDO queryStaffInfoByStaffId(String staffId) {
        return null;
    }

    @Override
    public List<StaffInfoDO> queryAllStaffInfo() {
        return null;
    }

    @Override
    public List<StaffInfoDO> queryStaffByAuthorityNO4PageIndex(String authorityNO, int startRow, int pageSize) {
        return null;
    }

    @Override
    public boolean insertStaff(StaffInfoDO staffInfoDO) {
        return false;
    }

    @Override
    public boolean deleteStaffInfoByStaffId(String staffId) {
        return false;
    }

    @Override
    public boolean updateStaff(StaffInfoDO staffInfoDO) {
        return false;
    }

    @Override
    public long countAllStaffInfo() {
        return 0;
    }

    @Override
    public List<StaffInfoDO> queryAllStaffInfoByAuthorityNO(String authorityNo) {
        return null;
    }
}