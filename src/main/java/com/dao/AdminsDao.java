package com.dao;

import com.entity.Account;
import com.entity.Admins;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@org.apache.ibatis.annotations.Mapper
public interface AdminsDao extends Mapper<Admins> {

    @Select("select * from admins a left join admin_info b  on b.aid=a.aid  where a.account=${account} and a.apwd=${apwd} ")
    List<Map> queryName(@Param("account") String account, @Param("apwd") String apwd);

    @Select("select * from admins a \n" +
            "left join admin_info b \n" +
            " on b.aid=a.aid " +
            " where  b.aname like '${aname}'")
    List<Map> query(@Param("aname") String aname);

    @Select("select * from admins a \n" +
            "left join admin_info b \n" +
            " on b.aid=a.aid ")
    List<Map> queryAll();
//


    @Select("SELECT * FROM authority WHERE auth_id in (SELECT auth_id FROM role  WHERE pid=${pid}) and auth_pid=${auth_pid}")
    List<Map<String,Object>> qxfp(@Param("pid")String pid,@Param("auth_pid") Integer auth_pid);
    @Update("UPDATE admins  SET account =#{account},apwd = #{apwd},astate = #{astate},alogintime =null ,avatar = #{avatar} WHERE  aid = #{aid}")
    int update(Admins a);
    @Insert("INSERT INTO admins  ( aid,account,apwd,astate,alogintime,avatar) VALUES(#{aid},#{account},#{apwd},#{astate},#{alogintime},#{avatar})")
    int add(Admins a);
    @Select(" select * from role r\n" +
            " left join admin_info a\n" +
            " on r.pid=a.pid\n" +
            " left join authority au\n" +
            " on r.auth_id=au.auth_id\n" +
            " where a.pid=#{pid}")
    List<Map> roleAdmin(Integer pid);
}