package com.controller;

import com.dao.ReplyDao;
import com.entity.Reply;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("rep")
public class ReplyController {

    @Resource
    ReplyDao replyDao;

    @RequestMapping("listAll")
    @ResponseBody
    public Object listAll(){
        return replyDao.listAll();
    }

    @RequestMapping("addRep")
    @ResponseBody
    public Object addRep(@RequestBody Reply reply) {
        return  replyDao.addRep(reply);
    }

}
