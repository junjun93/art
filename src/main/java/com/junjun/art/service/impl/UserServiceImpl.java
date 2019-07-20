package com.junjun.art.service.impl;

import com.junjun.art.common.Const;
import com.junjun.art.common.ServerResponse;
import com.junjun.art.common.util.Md5Util;
import com.junjun.art.pojo.User;
import com.junjun.art.mapper.UserMapper;
import com.junjun.art.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author junjun
 * @since 2019-07-18
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ServerResponse<User> login(String username, String password) {

        int resultCount = userMapper.checkUsername(username);
        if (resultCount == 0) {
            return ServerResponse.createByErrorMessage("用户名不存在");
        }
        String md5Password = Md5Util.Md5EncodeUtf8(password);
        User user = userMapper.selectLogin(username, md5Password);
        if (user == null) {
            return ServerResponse.createByErrorMessage("密码错误");
        }
        if (user.getStatus() == 0) {
            return ServerResponse.createByErrorMessage("用户已禁用，请联系管理员");
        }
        user.setPassword(StringUtils.EMPTY);
        return ServerResponse.createBySuccess("登录成功", user);
    }

    @Override
    public ServerResponse<String> register(User user) {

        ServerResponse volidResponse = this.checkValid(user.getUsername(), Const.USERNAME);
        if (!volidResponse.isSuccess()) {
            return volidResponse;
        }
        volidResponse = checkValid(user.getPhoneNumber(), Const.TEL);
        if (!volidResponse.isSuccess()) {
            return volidResponse;
        }
        volidResponse = checkValid(user.getMail(), Const.EMAIL);
        if (!volidResponse.isSuccess()) {
            return volidResponse;
        }

        user.setPassword(Md5Util.Md5EncodeUtf8(user.getPassword()));
        int resultCount = userMapper.insert(user);
        if (resultCount == 0) {
            return ServerResponse.createByErrorMessage("注册失败");
        }
        return ServerResponse.createBySuccessMessage("注册成功");
    }

    private ServerResponse<String> checkValid(String str, String type) {

        if (StringUtils.isNotBlank(type)) {
            if (Const.USERNAME.equals(type)) {
                int resultCount = userMapper.checkUsername(str);
                if (resultCount > 0) {
                    return ServerResponse.createByErrorMessage("用户名已存在");
                }
            }
            if (Const.TEL.equals(type)) {
                int resultCount = userMapper.checkTel(str);
                if (resultCount > 0) {
                    return ServerResponse.createByErrorMessage("手机号已存在");
                }
            }
            if (Const.EMAIL.equals(type)) {
                int resultCount = userMapper.checkEmail(str);
                if (resultCount > 0) {
                    return ServerResponse.createByErrorMessage("邮箱已存在");
                }
            }
        } else {
            return ServerResponse.createByErrorMessage("参数错误");
        }
        return ServerResponse.createBySuccessMessage("校验成功");
    }

}
