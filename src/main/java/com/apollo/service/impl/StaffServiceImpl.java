package com.apollo.service.impl;

import com.apollo.bean.MssLogin;
import com.apollo.service.StaffService;

public class StaffServiceImpl implements StaffService {
    @Override
    public MssLogin findStaffByLoginNameAndPwd(String loginName, String pwd) {
        return new MssLogin();
    }

    @Override
    public MssLogin findStaffByLoginName(String loginName) {
        return new MssLogin();
    }
}
