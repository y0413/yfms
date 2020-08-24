package com.dao;

import com.entity.Account;
import com.entity.Admins;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface AdminsDao extends Mapper<Admins> {

    @Select("select * from admins where account=${account} and apwd=${apwd}")
    List<Account> queryName(String account, String apwd);
}
