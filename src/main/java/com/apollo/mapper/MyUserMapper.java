package com.apollo.mapper;

import com.apollo.bean.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface MyUserMapper extends JpaRepository<MyUser,String>  {
    /**
     * 根据用户名查询
     * @param username
     * @return
     */
    public MyUser findByUserName(String username);

    /**
     * 根据用户名和密码查询
     * @param username
     * @param password
     * @return
     */
    public MyUser findByUserNameAndUserPwd(String username,String password);

    /**
     * 根据用户状态查询用户
     * @param userstatus
     * @return
     */
    public Integer findByUserStatus(String userstatus);
}
