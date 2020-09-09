package com.controller;

import com.dao.CommentsDao;
import com.entity.Comments;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@CrossOrigin
@Controller
@RequestMapping("comment")
public class CommentsController {

    @Resource
    CommentsDao commentsDao;

    @RequestMapping("listAll")
    @ResponseBody
    public Object listAll(Integer bnbid){
        return commentsDao.listAll(bnbid);
    }

    @RequestMapping("listById")
    @ResponseBody
    public Object listById(Integer cid){
        return commentsDao.listById(cid);
    }

    @RequestMapping("addCom")
    @ResponseBody
    public Object addCom(@RequestBody Comments comments){
//        System.out.println("添加成功");
        return commentsDao.addCom(comments);
    }

}
