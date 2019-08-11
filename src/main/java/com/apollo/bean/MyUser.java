package com.apollo.bean;

import lombok.*;

import javax.persistence.*;
import javax.print.attribute.standard.MediaSize;

/**
 * 用户
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="my_user")
public class MyUser {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "user_id")
    private String userId;
    @Column(name="user_name")
    private String userName;
    @Column(name = "user_real_name")
    private String userRealName;
    @Column(name = "user_tel")
    private String userTel;
    @Column(name = "user_pwd")
    private String userPwd;
    @Column(name = "user_status")
    private String userStatus; // 0-正常 1-注销 2-禁用 3-锁定
    @Column(name = "user_code")
    private String userCode;
    @Column(name = "create_date_time")
    private String createDateTime;
    @Column(name = "update_date-time")
    private String updateDateTime;
    @Column(name = "pwd_update_date_time")
    private String pwdUpdateDateTime;
    @Column(name = "pwd_error_num")
    private Integer pwdErrorNum;
    @Column(name = "remark")
    private String remark;
}
