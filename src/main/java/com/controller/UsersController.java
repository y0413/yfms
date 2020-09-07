package com.controller;

import com.dao.UsersDao;
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
    //查看提现记录
    @RequestMapping("queryTx")
    public List<Map> queryTx(Integer uid){
        return usersDao.queryTx(uid);
    }
    //添加提现记录
    @RequestMapping("addTx")
    public int addTx(Integer uid,Float total_price,Integer aid){
        return usersDao.addTx(uid,total_price,aid);
    }
    //修改金额
    @RequestMapping("upMoney")
    public int upMoney(Float upmoney, Integer uid){
        return usersDao.upMoney(upmoney,uid);
    }
    //修改支付
    @RequestMapping("updateAcc")
    public int updateAcc(String acc,String idcard,Integer uid){
        return usersDao.updateAcc(acc,idcard,uid);
    }
    //查询支付
    @RequestMapping("queryAcc")
    public Map queryAcc(Integer uid){
        return usersDao.queryAcc(uid);
    }
    @RequestMapping("queryBnb")
    //查询房源
    public List<Map> queryBnb(Integer uid){
        return usersDao.queryBnb(uid);
    }
    @RequestMapping("queryUid")
    public List<Map> queryUid(Integer uid){
//        System.out.println("执行");
        List<Map> users = usersDao.queryUid(uid);
//        System.out.println(users);
        return usersDao.queryUid(uid);
    }
    @RequestMapping("queryName")
    public List<Map> queryName(String uname,String upwd){

        List<Map> m =usersDao.queryName(uname,upwd);
//        System.out.println(m);
        return m;
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
    public int updates(String usex,String truename,String idcard,String uid,String email,String address){
        return usersDao.updates(usex,truename,idcard,email,address,uid);
    }
    Integer pteluid=0;
    @RequestMapping("Uid")
    public String Uid(Integer uid){
        pteluid=uid;
        System.out.println(pteluid);
        return "1";
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
