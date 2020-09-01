package com.controller;

import com.dao.AdminsDao;
import com.dao.roleDao;
import com.entity.Admins;
import com.entity.Role;
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
    @Resource
    roleDao roleDao;
    @RequestMapping("queryName")
    @ResponseBody
    public List<Map> queryName(String account,String apwd){
        return adminsDao.queryName(account,apwd);
    }
    @RequestMapping("queryaccount")
    @ResponseBody
    public List<Map<String,Object>> queryaccount(String pid){
        List<Map<String,Object>> qxfp = adminsDao.qxfp(pid, 0);
        for (Map<String,Object> qx: qxfp){
            Integer auth_pid = Integer.parseInt(qx.get("auth_id").toString());
            List<Map<String,Object>> qxfp1 = adminsDao.qxfp(pid, auth_pid);
            qx.put("qxfp1",qxfp1);
        }
        System.out.println(qxfp.get(0).get("qxfp1"));
        return qxfp;
    }
    @RequestMapping("/query")
    @ResponseBody
    public List<Map> query(String aname){
        if(aname!=""){
            System.out.println("%"+aname+"%");
            return adminsDao.query("%"+aname+"%");
        }
        return adminsDao.queryAll();
    }

    @RequestMapping("/update")
    @ResponseBody
    public int update(@RequestBody Admins a){
        return adminsDao.update(a);
    }
    @RequestMapping("/add")
    @ResponseBody
    public int add(@RequestBody Admins a){
        return adminsDao.insert(a);
    }
    @RequestMapping("/queryrole")
    @ResponseBody
    public List<Map<String,Object>> queryrole(String pid){
        List<Map<String,Object>> qxfp = adminsDao.qxfp(pid, 0);
        for (Map<String,Object> qx: qxfp) {
            Integer auth_pid = Integer.parseInt(qx.get("auth_id").toString());
            List<Map<String, Object>> qxfp1 = adminsDao.qxfp(pid, auth_pid);
            qx.put("qxfp1", qxfp1);
        }
        return qxfp;
    }
    @RequestMapping("/delete")
    @ResponseBody
    public int delete(int aid){
        return adminsDao.deleteByPrimaryKey(aid);
    }
    @RequestMapping("/roleA")
    @ResponseBody
    public Integer roleA(String auth_id,Integer pid){
        String[] split = auth_id.split(",");
        int count=1;
        for (int i=0;i<split.length;i++) {
            System.out.println(split[i]);
            int i1 = Integer.parseInt(split[i]);
            roleDao.roleDele(i1,pid);
            count = roleDao.roleAdd(i1,pid);
        }
        return count;
        //        for (int i=0;i<auth_id.length;i++){
//            System.out.println(auth_id[i]);
//            Integer st = roleDao.roleAdd(auth_id[i],pid);
//            if(i==auth_id.length){
//                return st;
//            }
//        }
    }
    @RequestMapping("/roleAdmin")
    @ResponseBody
    public List<Map> roleAmin(Integer pid){
        return adminsDao.roleAdmin(pid);
    }
}
