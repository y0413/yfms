package com.controller;

import com.dao.UsersDao;
import com.entity.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import javax.annotation.Resource;
import java.util.Map;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("UsersController")
public class UsersController {
    @Resource
    UsersDao usersDao;
    @RequestMapping("queryName")
    public List<Map> queryName(String uname,String upwd){
        return usersDao.queryName(uname,upwd);
    }
    @RequestMapping("adduser")
    public int adduser(String uname,String upwd){
        return usersDao.adduser(uname,upwd);
    }
    @RequestMapping("updateUpwd")
    public int updateUpwd(String upwd,String photo){
        return usersDao.updateUpwd(upwd,photo);
    }@RequestMapping("updateUname")
    public int updateUname(String uname,String uid){
        return usersDao.updateuname(uname,uid);
    }@RequestMapping("updatephoto")
    public int updatephoto(String photo,String uid){
        return usersDao.updatephoto(photo,uid);
    }@RequestMapping("updates")
    public int updates(String usex,String truename,String email,String idcard,String uid){
        return usersDao.updates(usex,truename,email,idcard,uid);
    }
    Integer pteluid=0;
    @RequestMapping("Uid")
    public String Uid(Integer uid){
        pteluid=uid;
        System.out.println(pteluid);
        return "1";
    }
    @RequestMapping("queryUid")
    public List<Map> queryUid(Integer uid){
//        System.out.println("执行");
        List<Map> users = usersDao.queryUid(uid);
//        System.out.println(users);
        return usersDao.queryUid(uid);
    }
    @Value("${prop.upload-folder}")
    private String UPLOAD_FOLDER;
    //图片上传
    @PostMapping("/singlefile")
    public Object singleFileUpload(@RequestParam("file") MultipartFile[] file, String pic) throws Exception  {
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
//                int bnbid=queryBnbid();
//                bnbid=bnbid-1;
                usersDao.updatePic(path.toString(),pteluid);
//                bnbinfoDao.upPic(pic,path.toString(),bnbid);
            }
        }
        return "ok";
    }
}
