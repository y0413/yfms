package com.controller;


import com.dao.DescribesDao;
import com.entity.Describes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@RequestMapping("des")
@CrossOrigin
@Controller
public class DescribesController {

    @Resource
    DescribesDao describesDao;

    @RequestMapping("listAll")
    @ResponseBody
    public Object listAll(){
        return describesDao.listAll();
    }

    @RequestMapping("addDes")
    @ResponseBody
    public Integer addDes(@RequestBody Describes describes){

        Integer i = describesDao.addDes(describes);
        if (i>0){
            //System.out.println("添加成功");
            return i;
        }
        return null;
    }

}
