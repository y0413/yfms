package com.controller;

import com.dao.BnbinfoDao;
import com.dao.DescribesDao;
import com.dao.IdDao;
import com.entity.Bnbinfo;
import com.entity.Describes;
import com.entity.Id;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("bnbinfo")
public class BnbinfoController {
    @Resource
    BnbinfoDao bnbinfoDao;
    @Resource
    DescribesDao describesDao;
    @Resource
    IdDao idDao;
    public Integer queryBnbid(){
        List<Id> ids = idDao.selectAll();
        return ids.get(0).getBnbid();
    }
    public Integer queryDid(){
        List<Id> ids = idDao.selectAll();
        return ids.get(0).getDid();
    }
    //添加房源信息
    @RequestMapping("add")
    public Integer add(@RequestBody Bnbinfo bnb){
        bnb.setBnbid(queryBnbid());
        int num=bnbinfoDao.insert(bnb);
        if(num>0){
            //自增
            bnbinfoDao.upBnbid();
            return num;
        }
        return null;
    }
    //添加房源描述信息
    @RequestMapping("addDes")
    public Integer addDes(@RequestBody Describes describes){
        int did=queryDid();
        describes.setDid(did);
        Integer i = describesDao.insert(describes);
        if (i>0){
            int bnbid=queryBnbid();
            bnbid=bnbid-1;
            //修改房源的房源描述
            bnbinfoDao.upDid(did,bnbid);
            //自增
            bnbinfoDao.upIDid();
            return i;
        }
        return null;
    }
}
