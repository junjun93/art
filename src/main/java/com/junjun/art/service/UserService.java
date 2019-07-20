package com.junjun.art.service;

import com.junjun.art.common.ServerResponse;
import com.junjun.art.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author junjun
 * @since 2019-07-18
 */
public interface UserService extends IService<User> {

    ServerResponse<User> login(String username, String password);

    ServerResponse register(User user);
}
