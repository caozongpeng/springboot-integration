package com.codegen.controller;

import com.codegen.core.model.ApiResponse;
import com.codegen.model.User;
import com.codegen.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户 controller
 *
 * @author KyrieCao
 * @date 2020/3/14 11:41
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 访问首页跳转到用户列表页面
     *
     * @return String
     * @author KyrieCao
     * @date 2020/3/14 11:41
     */
    @GetMapping("/")
    public ModelAndView index() {
        return new ModelAndView("user/manage");
    }

    /**
     * 用户列表
     *
     * @return java.lang.String
     * @author KyrieCao
     * @date 2020/3/14 11:42
     */
    @RequestMapping("/manage")
    public ModelAndView list() {
        ModelAndView mav = new ModelAndView("user/manage");
        List<User> users = userService.findList();
        mav.addObject("users", users);
        return mav;
    }

    /**
     * 用户新增方法
     *
     * @param user 用户对象
     * @return ApiResponse<User>
     * @author KyrieCao
     * @date 2020/3/14 11:43
     */
    @PostMapping("/create")
    public ApiResponse<User> create(User user) {
        return ApiResponse.success(userService.create(user));
    }

    /**
     * 通过id查询用户
     * @param id        用户id
     * @return ApiResponse<User>
     * @author KyrieCao
     * @date 2020/3/14 21:36
     */
    @GetMapping("/{id}")
    public ApiResponse<User> finById(@PathVariable Integer id) {
        return ApiResponse.success(userService.findById(id));
    }

    /**
     * 用户编辑方法
     *
     * @param user 用户对象
     * @return ApiResponse<User>
     * @author KyrieCao
     * @date 2020/3/14 11:44
     */
    @PostMapping("/updateById")
    public ApiResponse<User> updateById(User user) {
        return ApiResponse.success(userService.updateById(user));
    }

    /**
     * 用户删除方法
     *
     * @param id 用户id
     * @return String
     * @author KyrieCao
     * @date 2020/3/14 11:45
     */
    @RequestMapping("/delete/{id}")
    public ApiResponse delete(@PathVariable Long id) {
        userService.deleteById(id);
        return ApiResponse.success(null);
    }
}
