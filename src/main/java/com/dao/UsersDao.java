package com.dao;

import com.entity.Users;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.Map;

@org.apache.ibatis.annotations.Mapper
public interface UsersDao extends Mapper<Users> {
    @Select("select * from users where uname=#{uname} and upwd=#{upwd} and ustate=0")
    List<Map> queryName(@Param("uname") String uname,@Param("upwd") String upwd);

    @Insert("insert into users (uname,upwd) values (#{uname},#{upwd})")
    int adduser(@Param("uname") String uname,@Param("upwd") String upwd);
    @Insert("insert into users (uname,upwd,photo) values (#{uname},#{upwd},#{photo})")
    int addusers(@Param("uname") String uname,@Param("upwd") String upwd,@Param("photo") String photo);
    @Select("select * from users where photo =#{photo}")
    List<Map> usersphoto(@Param("photo") String photo);
    @Update("update users set upwd=#{upwd} where photo=#{photo}")
    int updateUpwd (@Param("upwd") String upwd,@Param("photo") String photo);
    @Update("update users set uname=#{uname} where uid=#{uid}")
    int updateuname(@Param("uname")String uname,@Param("uid")String uid);
    @Update("update users set photo=#{photo} where uid=#{uid}")
    int updatephoto(@Param("photo")String photo,@Param("uid")String uid);
    @Update("update users set usex=#{usex},truename=#{truename},idcard=#{idcard} where uid=#{uid}")
    int updates(@Param("usex") String usex,@Param("truename")String truename,@Param("idcard")String idcard,@Param("uid")String uid);


}
