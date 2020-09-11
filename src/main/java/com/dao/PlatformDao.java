package com.dao;

import com.entity.Platform;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;
@org.apache.ibatis.annotations.Mapper
public interface PlatformDao extends Mapper<Platform> {
    //更改平台余额
    @Update("update platform set pmoney=pmoney-#{money}")
    int upPmoney(Float money);
    //添加平台余额
    @Update("update platform set pmoney=pmoney+#{money}")
    int upaddPmoney(Float money);
    //添加平台流水记录
    @Insert("insert into water (wmoney,state,uid,createtime,wstate) values (#{wmoney},1,#{uid},now(),#{wstate})")
    int addWaterqx(@Param("wmoney") Float wmoney,@Param("uid") Integer uid,@Param("wstate") Integer wstate);
    @Insert("insert into water (wmoney,state,uid,createtime,wstate) values (#{wmoney},0,#{uid},now(),0)")
    int addWateryd(@Param("wmoney") Float wmoney,@Param("uid") Integer uid);
    //更改用户余额
    @Update("update users set money=money+#{money} where uid=#{uid}")
    int upUmoney(@Param("money") Float money,@Param("uid") Integer uid);
    //取消订单
    @Update("update orders set state=1 where oid=#{oid} ")
    int upOrders(Integer oid);
}
