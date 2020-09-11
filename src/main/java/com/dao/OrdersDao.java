package com.dao;

import com.entity.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface OrdersDao extends tk.mybatis.mapper.common.Mapper<Orders> {
    @Select("select * from orders o \n" +
            "join users u on o.uid=u.uid \n" +
            "where o.uid=#{uid} and o.state=#{state} ")
    List<Map<String,Object>> queryOrders(@Param("uid") Integer uid,@Param("state") Integer state);
    @Select("select * from orders o \n" +
            "join bnbinfo b on o.bnbid=b.bnbid\n" +
            "join users u on u.uid=o.uid\n" +
            "where b.uid=#{uid} and o.state=#{state}")
    List<Map<String,Object>> queryOrdersjx(@Param("uid") Integer uid,@Param("state") Integer state);

    @Select("select * from comments c\n" +
            "join users u on c.uid=u.uid\n" +
            "join bnbinfo b on c.bnbid=b.bnbid\n" +
            "where c.uid=#{uid}")
    List<Map<String,Object>> queryComments(Integer uid);

}
