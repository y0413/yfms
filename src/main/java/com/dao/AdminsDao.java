package com.dao;

import com.entity.Account;
import com.entity.Admins;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@org.apache.ibatis.annotations.Mapper
public interface AdminsDao extends Mapper<Admins> {

    @Select("select * from admins a left join admin_info b  on b.aiId=a.aiId  where a.account=${account} and a.apwd=${apwd} ")
    List<Map> queryName(@Param("account") String account, @Param("apwd") String apwd);
   @Select("select * from admins where account=${account}")
   List<Admins> queryaccount(@Param("account") String account);

   @Select("select * from admins a \n" +
           "left join admin_info b \n" +
           " on b.aiId=a.aiId ")
   List<Admins> query();
//




    @Select("SELECT * FROM authority WHERE auth_id in (SELECT auth_id FROM role  WHERE pid=${pid}) and auth_pid=${auth_pid}")
    List<Map<String,Object>> qxfp(@Param("pid")String pid,@Param("auth_pid") Integer auth_pid);
}
