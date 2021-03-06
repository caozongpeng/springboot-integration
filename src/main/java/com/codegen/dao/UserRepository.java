package com.codegen.dao;

import com.codegen.model.User;
//import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 用户数据访问层
 *
 * @author KyrieCao
 * @date 2020/3/14 11:20
 */
public interface UserRepository  {
    /**
     * 通过id查询
     *
     * @param id 用户id
     * @return User
     * @author KyrieCao
     * @date 2020/3/14 11:30
     */
    User findById(Integer id);

    /**
     * 通过id删除
     *
     * @param id 用户id
     * @author KyrieCao
     * @date 2020/3/14 11:32
     */
    void deleteById(Long id);
}
