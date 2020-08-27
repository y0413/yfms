package com.controller;

import com.dao.BnbinfoDao;
import com.entity.Bnbinfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@CrossOrigin
@Controller
@RequestMapping("bnbinfo")
public class BnbinfoController {
    @Resource
    BnbinfoDao bnbinfoDao;

    @RequestMapping("list")
    @ResponseBody
    public List<Bnbinfo> listAll(){
        return bnbinfoDao.select();
    }
}
