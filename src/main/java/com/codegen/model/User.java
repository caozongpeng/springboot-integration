package com.codegen.model;

import lombok.Data;

import java.util.Date;

/**
 * 用户实体类    jpa
 *
 * @author KyrieCao
 * @date 2020/3/14 11:07
 */
//@Entity
@Data
public class User {
//    @Id
//    @GeneratedValue
    private Integer id;

//    @Column(nullable = false, unique = true)
    private String username;

//    @Column(nullable = false)
    private String password;

//    @Column(nullable = false, unique = true)
    private String nickname;

    private String realName;

    private Date birthday;

    private Byte sex;

    private String email;

    private String mobile;

    private Date createTime;

    private Date updateTime;

    private Boolean isDelete;
}