package com.junjun.art.mapper;

import com.junjun.art.common.ServerResponse;
import com.junjun.art.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author junjun
 * @since 2019-07-18
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * 用户登录
     * @param username
     * @param password
     * @return ServerResponse<User>
     * */
    @Select("select * from user where username = #{username} and password = #{password}")
    User selectLogin(@Param("username") String username, @Param("password") String password);

    @Select("select count(1) from user where username = #{username}")
    Integer checkUsername(String username);

    @Select("select count(1) from user where phone_number = #{phoneNumber}")
    Integer checkTel(String phoneNumber);

    @Select("select count(1) from user where email = #{email}")
    Integer checkEmail(String email);

    @Override
    @Insert("insert into user(id, username, phone_number, mail, password, salt, operate_time, operate_ip) " +
            "values(#{id}, #{username}, #{phoneNumber}, #{mail}, #{password}, '0', now(), '0.0.0.0')")
    int insert(User user);
}
