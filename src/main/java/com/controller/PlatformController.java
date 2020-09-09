package com.controller;

import com.dao.PlatformDao;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@RequestMapping("plat")
public class PlatformController {
    @Resource
    PlatformDao platformDao;
    //更改平台余额
    @RequestMapping("upFmoney")
    public int upFmoney(Float money){
        return platformDao.upPmoney(money);
    }
    //添加流水
    @RequestMapping("addWaterqx")
    public int addWaterqx(Float wmoney,Integer uid,Integer wstate){
        return platformDao.addWaterqx(wmoney,uid,wstate);
    }
    //添加流水
    @RequestMapping("upUmoney")
    public int upUmoney(Float money,Integer uid){
        return platformDao.upUmoney(money,uid);
    }
}
