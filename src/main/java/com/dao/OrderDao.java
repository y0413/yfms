package com.dao;

import com.entity.Orders;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface OrderDao {

    @Select("select *  from orders o \n" +
            "join bnbinfo b \n" +
            "on o.bnbid = b.bnbid \n" +
            "join users u \n" +
            "on o.uid = u.uid")
    List<Map> listAll();

    @Select("select * from users u \n" +
            "join bnbinfo b \n" +
            "on u.bnbid = b.bnbid ")
    List<Map> query ();

    @Insert("insert into orders \n" +
            "(order_num,uid,bnbname,createtime,order_price,sendtime,starttime) \n" +
            "values \n" +
            "(#{order_num},#{uid},#{bnbname},now(),#{order_price},#{sendtime},#{starttime}) ")
    Integer addOrder(Orders orders);

}
