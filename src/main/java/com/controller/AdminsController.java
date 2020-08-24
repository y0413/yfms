package com.controller;

import com.dao.AdminsDao;
import com.entity.Account;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("AdminsController")
public class AdminsController {
    @Resource
    AdminsDao adminsDao;
    @RequestMapping("queryName")
    public List<Account> queryName(String account,String apwd){
        System.out.println(account);
        System.out.println(apwd);
        return adminsDao.queryName(account,apwd);
    }
}
