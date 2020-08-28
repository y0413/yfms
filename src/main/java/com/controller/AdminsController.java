package com.controller;

import com.dao.AdminsDao;
import com.entity.Admins;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@CrossOrigin
@Controller
@RequestMapping("AdminsController")
public class AdminsController {
    @Resource
    AdminsDao adminsDao;
    @RequestMapping("queryName")
    @ResponseBody
    public List<Map> queryName(String account,String apwd){
        System.out.println(account);
        System.out.println(apwd);
        return adminsDao.queryName(account,apwd);
    }
    @RequestMapping("queryaccount")
    @ResponseBody
    public List<Map<String,Object>> queryaccount(String pid){
        List<Map<String,Object>> qxfp = adminsDao.qxfp(pid, 0);
        for (Map<String,Object> qx: qxfp){
            Integer auth_pid = Integer.parseInt(qx.get("auth_id").toString());
            System.out.println(auth_pid);
            List<Map<String,Object>> qxfp1 = adminsDao.qxfp(pid, auth_pid);
            System.out.println(qxfp1);
            qx.put("qxfp1",qxfp1);
        }
        System.out.println(qxfp.get(0).get("qxfp1"));
        return qxfp;
    }
    @RequestMapping("/query")
    @ResponseBody
    public List<Admins> query(){
        return adminsDao.query();
    }
}
