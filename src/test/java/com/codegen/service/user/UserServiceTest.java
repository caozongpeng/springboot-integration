package com.codegen.service.user;

import com.codegen.dao.user.model.User;
import com.codegen.service.BaseTest;
import com.codegen.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


/**
 * 用户service测试
 * @author KyrieCao
 * @date 2020/3/14 22:19
 */
@Slf4j
@EnableAutoConfiguration
@SpringBootTest(classes = UserServiceTest.class)
public class UserServiceTest extends BaseTest {

    @Autowired
    private UserService userService;

    @Test
    public void findListTest() {
        List<User> userList = userService.findList();
        log.info(userList.toString());
    }
}
