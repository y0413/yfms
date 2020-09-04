package com.controller;

import com.dao.UsersDao;
import com.entity.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping("updateUpwd")
    public int updateUpwd(String upwd,String photo){
        return usersDao.updateUpwd(upwd,photo);
    }@RequestMapping("updateUname")
    public int updateUname(String uname,String uid){
        return usersDao.updateuname(uname,uid);
    }@RequestMapping("updatephoto")
    public int updatephoto(String photo,String uid){
        return usersDao.updatephoto(photo,uid);
    }@RequestMapping("updates")
    public int updates(String usex,String truename,String idcard,String uid){
        return usersDao.updates(usex,truename,idcard,uid);
    }
}
