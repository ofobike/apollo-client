package com.apollo.controller;

import com.apollo.bean.MyUser;
import com.apollo.mapper.MyUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private MyUserMapper myUserMapper;

    @RequestMapping(value = "login",produces = "application/json;charset=utf-8")
    public String login(@ModelAttribute MyUser myUser, HttpServletRequest request, HttpSession session){
        try{
            //验证参数
            if (myUser == null){
                throw new RuntimeException("用户名或者密码错误");
            }
            MyUser userName = myUserMapper.findByUserName(myUser.getUserName());
            if (userName!=null && "1".equals(userName.getUserStatus())){
                throw new RuntimeException("用户已经被停用");
            }
            return "登陆成功";
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("登陆失败");
        }
    }
}
