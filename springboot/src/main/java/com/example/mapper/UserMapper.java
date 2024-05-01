package com.example.mapper;
import com.example.entity.Admin;
import com.example.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 操作user相关数据接口(传给数据库进行数据处理)
*/
public interface UserMapper {
    int insert(User user);

    List<User> selectAll(User user);

    int updateById(User user);

    //@delete("delete from user where id=#{id}")
    int deleteById(Integer id);

    @Select("select *from user where username=#{username}")
    User selectByUsername(String username);

    @Select("select *from user where id=#{id}")
    User selectById(Integer id);
    //可以在这里面直接编辑运用@insert但是在这里不可以动态的写sql语句


}