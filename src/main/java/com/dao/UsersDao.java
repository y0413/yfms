package com.dao;

import com.entity.Users;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.Map;

@org.apache.ibatis.annotations.Mapper
public interface UsersDao extends Mapper<Users> {
    @Select("select * from users where uname=#{uname} and upwd=#{upwd} and ustate=0")
    List<Map> queryName(@Param("uname") String uname,@Param("upwd") String upwd);

    @Insert("insert into users (uname,upwd) values (#{uname},#{upwd})")
    int adduser(@Param("uname") String uname,@Param("upwd") String upwd);
}
