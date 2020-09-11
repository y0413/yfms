package com.controller;

import com.dao.BnbinfoDao;
import com.dao.DescribesDao;
import com.dao.IdDao;
import com.entity.Bnbinfo;
import com.entity.Describes;
import com.entity.Id;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

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
    //查询进行中订单
    @RequestMapping("selectOrYd")
    public List<Map> selectOrYd(String sttime, Integer bnbid){
        return bnbinfoDao.selectOrYd(sttime,bnbid);
    }
    //下架
    @RequestMapping("upBnbshelf")
    public int upBnbshelf(Integer bnbid){
        return bnbinfoDao.upBnbshelf(bnbid);
    }
    //查询房源下的订单
    @RequestMapping("queryBnbOrder")
    public List<Map<String, Object>> queryBnbOrder(Integer bnbid){
        return bnbinfoDao.queryBnbOrder(bnbid);
    }
    //查询关联数据
    @RequestMapping("select")
    public List<Map<String,Object>> selectBnb(@RequestBody Map map){
        List<Map<String, Object>> maps = bnbinfoDao.selectListB(map);
        if(maps.isEmpty()){
            map.replace("city","");
            return bnbinfoDao.selectListB(map);
        }
        return bnbinfoDao.selectListB(map);
    }
    //查询房源信息
    @RequestMapping("query")
    public List<Bnbinfo> query(){
        return bnbinfoDao.selectLimit();
    }
    //根据主键查询
    @RequestMapping("queryId")
    public Map<String, Object> queryId(Integer bnbid){
        return bnbinfoDao.queryBnbinfo(bnbid);
    }
    //添加房源信息
    @RequestMapping("add")
    public Integer add(@RequestBody Bnbinfo bnb){
        bnb.setBnbid(queryBnbid());
        String money="0";
        bnb.setMoney(Float.parseFloat(money));
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
    @Value("${prop.upload-folder}")
    private String UPLOAD_FOLDER;
    //图片上传
    @PostMapping("/singlefile")
    public Object singleFileUpload(@RequestParam("file") MultipartFile[] file,String pic) throws Exception  {
        for (MultipartFile s : file) {
            byte[] bytes = s.getBytes();;
            // 原文件名
            String originalFilename = s.getOriginalFilename();
            // 判断是否有文件
            if(null != originalFilename && !"".equals(originalFilename)){
                //获取文件后缀
                String fileExt = s.getOriginalFilename().substring(s.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();
                // 重构文件名称
                String pikId = UUID.randomUUID().toString().replaceAll("-", "");
//                System.out.println("xxx:"+pikId);
                Path path = Paths.get(UPLOAD_FOLDER + s.getOriginalFilename().lastIndexOf(".")+ pikId + "." + fileExt);
//                System.out.println("xx:"+path);
                //如果没有files文件夹，则创建
                if (!Files.isWritable(path)) {
                    Files.createDirectories(Paths.get(UPLOAD_FOLDER));
                    // System.out.println(Files.createDirectories(Paths.get(UPLOAD_FOLDER)));
                }
                //上传文件
                Files.write(path, bytes);
                int bnbid=queryBnbid();
                bnbid=bnbid-1;
                bnbinfoDao.upPic(pic,path.toString(),bnbid);
            }
        }
        return "ok";
    }
    @PostMapping("/ws")
    public Object ws(@RequestParam("file") MultipartFile[] file) throws Exception  {
        this.singleFileUpload(file,"bedroom");
        return "ok";
    }
    @PostMapping("/kt")
    public Object kt(@RequestParam("file") MultipartFile[] file) throws Exception  {
        this.singleFileUpload(file,"room");
        return "ok";
    }
    @PostMapping("/wsj")
    public Object wsj(@RequestParam("file") MultipartFile[] file) throws Exception  {
        this.singleFileUpload(file,"toilet");
        return "ok";
    }
    @PostMapping("/cf")
    public Object cf(@RequestParam("file") MultipartFile[] file) throws Exception  {
        this.singleFileUpload(file,"kitchen");
        return "ok";
    }
    @PostMapping("/qt")
    public Object qt(@RequestParam("file") MultipartFile[] file) throws Exception  {
        this.singleFileUpload(file,"other");
        return "ok";
    }
    //添加设施
    @RequestMapping("ptss")
    public void ptss(Integer uid,@RequestBody String[] checklist ){
        int bnbid=queryBnbid();
        bnbid=bnbid-1;
        bnbinfoDao.upBnbUB(uid,bnbid);
        bnbinfoDao.upUstate(uid);
        for (String s :
                checklist) {
            bnbinfoDao.upSs(s,bnbid);
        }

    }
}
