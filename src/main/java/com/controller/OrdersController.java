package com.controller;

import com.dao.OrdersDao;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
@CrossOrigin
@RestController
@RequestMapping("orders")
public class OrdersController {
    @Resource
    OrdersDao ordersDao;
    @RequestMapping("queryOrders")
    public List<Map<String, Object>> queryOrders(Integer uid,Integer state){
        return ordersDao.queryOrders(uid,state);
    }
    @RequestMapping("queryComments")
    public List<Map<String, Object>> queryComments(Integer uid){
        return ordersDao.queryComments(uid);
    }
}
