package com.dao;

import com.entity.Platform;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;
@org.apache.ibatis.annotations.Mapper
public interface PlatformDao extends Mapper<Platform> {

    @Update("update platform set pmoney=pmoney-#{money}")
    int upPmoney(Float money);
    @Insert("insert into water (wmoney,state,uid,createtime,wstate) values (#{wmoney},1,#{uid},now(),#{wstate})")
    int addWaterqx(@Param("wmoney") Float wmoney,@Param("uid") Integer uid,@Param("wstate") Integer wstate);
    @Update("update users set money=money+#{money} where uid=#{uid}")
    int upUmoney(@Param("money") Float money,@Param("uid") Integer uid);
}
