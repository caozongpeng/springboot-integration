package com.codegen.controller;

import com.codegen.model.User;
import com.codegen.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户 controller
 *
 * @author KyrieCao
 * @date 2020/3/14 11:41
 */
@Controller
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
    @RequestMapping("/")
    public String index() {
        return "redirect:/list";
    }

    /**
     * 用户列表
     *
     * @param model
     * @return java.lang.String
     * @author KyrieCao
     * @date 2020/3/14 11:42
     */
    @RequestMapping("/list")
    public String list(Model model) {
        List<User> users = userService.getUserList();
        model.addAttribute("users", users);
        return "user/list";
    }

    /**
     * 用户新增页面
     *
     * @return String
     * @author KyrieCao
     * @date 2020/3/14 11:42
     */
    @RequestMapping("/toAdd")
    public String toAdd() {
        return "user/userAdd";
    }

    /**
     * 用户新增方法
     *
     * @param user 用户对象
     * @return String
     * @author KyrieCao
     * @date 2020/3/14 11:43
     */
    @RequestMapping("/add")
    public String add(User user) {
        userService.save(user);
        return "redirect:/list";
    }

    /**
     * 用户编辑页面
     *
     * @param model model对象
     * @param id    用户id
     * @return String
     * @author KyrieCao
     * @date 2020/3/14 11:44
     */
    @RequestMapping("/toEdit")
    public String toEdit(Model model, Long id) {
        User user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "user/userEdit";
    }

    /**
     * 用户编辑方法
     *
     * @param user 用户对象
     * @return String
     * @author KyrieCao
     * @date 2020/3/14 11:44
     */
    @RequestMapping("/edit")
    public String edit(User user) {
        userService.edit(user);
        return "redirect:/list";
    }

    /**
     * 用户删除方法
     *
     * @param id 用户id
     * @return String
     * @author KyrieCao
     * @date 2020/3/14 11:45
     */
    @RequestMapping("/delete")
    public String delete(Long id) {
        userService.delete(id);
        return "redirect:/list";
    }
}
