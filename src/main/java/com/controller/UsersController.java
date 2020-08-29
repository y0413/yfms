package com.controller;

import com.dao.UsersDao;
import org.apache.ibatis.annotations.Insert;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import javax.annotation.Resource;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("UsersController")
public class UsersController {
    @Resource
    UsersDao usersDao;
    @RequestMapping("queryName")
    public List<Map> queryName(String uname,String upwd){
        return usersDao.queryName(uname,upwd);
    }
    @RequestMapping("adduser")
    public int adduser(String uname,String upwd){
        return usersDao.adduser(uname,upwd);
    }
}
