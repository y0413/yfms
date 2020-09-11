package com.dao;

import com.entity.Role;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;
@org.apache.ibatis.annotations.Mapper
public interface roleDao extends Mapper<Role> {
    @Insert("insert into role (auth_id,pid) values (${auth_id},${pid})")
    int roleAdd(@Param("auth_id") Integer auth_id, @Param("pid")Integer pid);
    @Delete("delete from role where pid=${pid}")
    int roleDele(@Param("pid")Integer pid);
}
