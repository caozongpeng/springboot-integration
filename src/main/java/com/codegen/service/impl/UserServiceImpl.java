package com.codegen.service.impl;

import com.codegen.core.model.PageData;
import com.codegen.core.utils.MyBatisUtil;
import com.codegen.dao.user.UserMapper;
import com.codegen.dao.user.model.User;
import com.codegen.dao.user.model.UserExample;
//import com.codegen.dao.UserRepository;
import com.codegen.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户 service 接口实现
 *
 * @author KyrieCao
 * @date 2020/3/14 11:22
 */
@Service("userService")
public class UserServiceImpl implements UserService {

//    @Autowired
//    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;


    @Override
    public PageData<User> findPage(User user, PageData<User> page, String orderByClause) {
        PageHelper.startPage(page.getPage(), page.getCapacity());
        UserExample example = MyBatisUtil.toExample(user, UserExample.class);
        example.setOrderByClause(orderByClause);
        return PageData.from(new PageInfo(userMapper.selectByExample(example)));
    }

    @Override
    public List<User> findList() {
//        return userRepository.findAll();
        UserExample example = new UserExample();
        return userMapper.selectByExample(example);

    }

    @Override
    public User findById(Integer id) {
//        return userRepository.findById(id);
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int create(User user) {
//        return userRepository.save(user);
        return userMapper.insertSelective(user);
    }

    @Override
    public int updateById(User user) {
//        return userRepository.save(user);
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public void deleteById(Integer id) {
//        userRepository.deleteById(id);
        userMapper.deleteByPrimaryKey(id);
    }
}
