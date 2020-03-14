package com.codegen.service;

import com.codegen.model.User;

import java.util.List;

/**
 * 用户 service 接口
 *
 * @author KyrieCao
 * @date 2020/3/14 11:21
 */
public interface UserService {
    /**
     * 查询用户列表
     *
     * @return List<User>
     * @author KyrieCao
     * @date 2020/3/14 11:27
     */
    List<User> getUserList();

    /**
     * 通过id查询
     *
     * @param id 用户id
     * @return User
     * @author KyrieCao
     * @date 2020/3/14 11:27
     */
    User findById(long id);

    /**
     * 保存
     *
     * @param user 用户对象
     * @author KyrieCao
     * @date 2020/3/14 11:27
     */
    User create(User user);

    /**
     * 编辑
     *
     * @param user 用户对象
     * @author KyrieCao
     * @date 2020/3/14 11:27
     */
    User updateById(User user);

    /**
     * 删除
     *
     * @param id 用户id
     * @author KyrieCao
     * @date 2020/3/14 11:26
     */
    void deleteById(long id);
}
