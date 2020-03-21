package com.codegen.api.user;

import com.codegen.api.BaseController;
import com.codegen.core.model.ApiResponse;
import com.codegen.dao.user.model.User;
import com.codegen.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "用户模块接口")
public class UserController extends BaseController {

    @Resource
    private UserService userService;

    /**
     * 用户页面
     *
     * @return String
     * @author KyrieCao
     * @date 2020/3/14 11:41
     */
    @GetMapping("/")
    @ApiOperation("欢迎页面")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    /**
     * 用户管理
     *
     * @return java.lang.String
     * @author KyrieCao
     * @date 2020/3/14 11:42
     */
    @GetMapping("/manage")
    @ApiOperation("用户管理")
    public ModelAndView list() {
        ModelAndView mav = new ModelAndView("user/manage");
        List<User> users = userService.findList();
        mav.addObject("userList", users);
        return mav;
    }

    /**
     * 创建用户
     *
     * @param user 用户对象
     * @return ApiResponse<User>
     * @author KyrieCao
     * @date 2020/3/14 11:43
     */
    @PostMapping("/create")
    @ApiOperation("创建用户")
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
    @ApiOperation("根据ID查询用户")
    public ApiResponse<User> finById(@PathVariable Integer id) {
        return ApiResponse.success(userService.findById(id));
    }

    /**
     * 修改用户
     *
     * @param user 用户对象
     * @return ApiResponse<User>
     * @author KyrieCao
     * @date 2020/3/14 11:44
     */
    @PostMapping("/updateById")
    @ApiOperation("修改用户")
    public ApiResponse<User> updateById(User user) {
        return ApiResponse.success(userService.updateById(user));
    }

    /**
     * 用户删除
     *
     * @param id 用户id
     * @return String
     * @author KyrieCao
     * @date 2020/3/14 11:45
     */
    @GetMapping("/delete/{id}")
    @ApiOperation("删除用户")
    public ApiResponse<?> delete(@PathVariable Integer id) {
        userService.deleteById(id);
        return ApiResponse.success(null);
    }
}
