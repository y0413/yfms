package com.controller;

import com.dao.AdminsDao;
import com.entity.Admins;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
@CrossOrigin
@Controller
@RequestMapping("AdminsController")
public class AdminsController {
    @Resource
    AdminsDao adminsDao;
    @RequestMapping("queryName")
    @ResponseBody
    public List<Admins> queryName(String account,String apwd){
        System.out.println(account);
        System.out.println(apwd);
        return adminsDao.queryName(account,apwd);
    }
    @RequestMapping("queryaccount")
    @ResponseBody
    public List<Admins> queryaccount(String account){
        System.out.println(account);
        return adminsDao.queryaccount(account);
    }
    @RequestMapping("/query")
    @ResponseBody
    public String query(){
        System.out.println("xxx");
        return "od";
    }
}
