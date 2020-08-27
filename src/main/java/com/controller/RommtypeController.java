package com.controller;

import com.dao.RommtypeDao;
import com.entity.Rommtype;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("rommtype")
public class RommtypeController {
      @Resource
      RommtypeDao rommtypeDao;
      @RequestMapping("list")
      @ResponseBody
      public List<Rommtype> listAll(){
          return rommtypeDao.selectAll();
      }
      @RequestMapping("add")
      @ResponseBody
      public int add(@RequestBody Rommtype rommtype){
          return rommtypeDao.insert(rommtype);
      }
      @RequestMapping("del")
      @ResponseBody
      public int del(@RequestBody Rommtype rommtype){
          return rommtypeDao.deleteByPrimaryKey(rommtype);
      }
      @RequestMapping("update")
    @ResponseBody
    public int update(@RequestBody Rommtype rommtype){
          return rommtypeDao.updateByPrimaryKey(rommtype);
      }
}
