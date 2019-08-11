package com.apollo.service;

import com.apollo.bean.MssLogin;

public interface StaffService {
    MssLogin findStaffByLoginNameAndPwd(String loginName,String pwd);
    MssLogin findStaffByLoginName(String loginName);
}
