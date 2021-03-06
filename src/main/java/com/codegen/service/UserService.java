package com.codegen.service;


import com.codegen.core.model.PageData;
import com.codegen.dao.user.model.User;

import java.util.List;

/**
 * 用户 service 接口
 *
 * @author KyrieCao
 * @date 2020/3/14 11:21
 */
public interface UserService {

    /**
     * 分页查询
     * @param user              用户对象
     * @param page              分页对象
     * @param orderByClause     排序字段
     * @return PageData<User>
     * @author KyrieCao
     * @date 2020/3/29 22:48
     */
    PageData<User> findPage(User user, PageData<User> page, String orderByClause);

    /**
     * 查询用户列表
     *
     * @return List<User>
     * @author KyrieCao
     * @date 2020/3/14 11:27
     */
    List<User> findList();

    /**
     * 通过id查询
     *
     * @param id 用户id
     * @return User
     * @author KyrieCao
     * @date 2020/3/14 11:27
     */
    User findById(Integer id);

    /**
     * 保存
     *
     * @param user 用户对象
     * @author KyrieCao
     * @date 2020/3/14 11:27
     */
    int create(User user);

    /**
     * 编辑
     *
     * @param user 用户对象
     * @author KyrieCao
     * @date 2020/3/14 11:27
     */
    int updateById(User user);

    /**
     * 删除
     *
     * @param id 用户id
     * @author KyrieCao
     * @date 2020/3/14 11:26
     */
    void deleteById(Integer id);
}
