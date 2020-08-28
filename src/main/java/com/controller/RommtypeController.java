package com.controller;

import com.dao.RommtypeDao;
import com.entity.Rommtype;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("rommtype")
public class RommtypeController {


    @Resource
    RommtypeDao rommtypeDao;
    @RequestMapping("queryAll")
    public List<Rommtype> queryAll() {
        return rommtypeDao.selectAll();
    }
    @RequestMapping("list")
    public List<Rommtype> listAll() {
        return rommtypeDao.selectAll();
    }

    @RequestMapping("add")
    public int add(@RequestBody Rommtype rommtype) {
        return rommtypeDao.insert(rommtype);
    }

    @RequestMapping("del")
    public int del(@RequestBody Rommtype rommtype) {
        return rommtypeDao.deleteByPrimaryKey(rommtype);
    }

    @RequestMapping("update")
    public int update(@RequestBody Rommtype rommtype) {
        return rommtypeDao.updateByPrimaryKey(rommtype);
    }
}

//@RestController
//@RequestMapping("rommtype")
//public class RommtypeController {
//    @Resource
//    RommtypeDao rommtypeDao;
//    @RequestMapping("queryAll")
//    public List<Rommtype> queryAll(){
//        return rommtypeDao.selectAll();
//    }
//
//}
