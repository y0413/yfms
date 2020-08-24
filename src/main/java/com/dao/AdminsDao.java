package com.dao;

import com.entity.Account;
import com.entity.Admins;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface AdminsDao extends Mapper<Admins> {

    @Select("select * from admins where account=${account} and apwd=${apwd}")
    List<Admins> queryName(@Param("account") String account,@Param("apwd") String apwd);
   @Select("select * from admins where account=${account}")
   List<Admins> queryaccount(@Param("account") String account);
////
//    SELECT * FROM authority
//    WHERE auth_id in
//            (SELECT pid FROM role
//                    WHERE pid=2) and auth_pid=0;
}
