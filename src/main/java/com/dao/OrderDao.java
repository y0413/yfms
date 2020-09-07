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

    @Insert("insert into orders \n" +
            "(order_num,bnbid,uid,createtime,order_notes,order_price,order_people) \n" +
            "values \n" +
            "(#{order_num},#{bnbid},#{uid},now(),#{order_notes},#{order_price},#{order_people}) ")
    Integer addOrder(Orders orders);

}
