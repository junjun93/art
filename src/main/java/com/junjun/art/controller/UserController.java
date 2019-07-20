package com.junjun.art.controller;

import com.junjun.art.common.Const;
import com.junjun.art.common.ServerResponse;
import com.junjun.art.pojo.User;
import com.junjun.art.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author junjun
 * @since 2019-07-18
 */
@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("用户登录")
    @PostMapping("login")
    public ServerResponse<User> login(String username, String password, HttpSession session) {
        ServerResponse<User> response = userService.login(username, password);
        if (response.isSuccess()) {
            session.setAttribute(Const.CURRENT_USER, response.getData());
        }
        return response;
    }

    @ApiOperation("退出登录")
    @PostMapping("logout")
    public ServerResponse<String> logout(HttpSession session) {
        session.removeAttribute(Const.CURRENT_USER);
        return ServerResponse.createBySuccess();
    }

    @ApiOperation("用户注册")
    @PostMapping("register")
    public ServerResponse<String> register(User user) {
        return userService.register(user);
    }
}

