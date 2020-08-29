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
    @Value("${prop.upload-folder}")
    private String UPLOAD_FOLDER;
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
                System.out.println("xx:"+path);
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
    @RequestMapping("ptss")
    public void ptss(@RequestBody String[] checklist ){
        int bnbid=queryBnbid();
        bnbid=bnbid-1;
        for (String s :
                checklist) {
            bnbinfoDao.upSs(s,bnbid);
        }
    }
}
