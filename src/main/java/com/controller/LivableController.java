package com.controller;

import com.dao.LivableDao;
import com.entity.Livable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("livable")
public class LivableController {
    @Resource
    LivableDao livableDao;
    @RequestMapping("queryAll")
    public List<Livable> queryAll(){
        return livableDao.selectAll();
    }
}
