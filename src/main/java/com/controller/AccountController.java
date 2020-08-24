package com.controller;

import com.dao.AccountDao;
import com.entity.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("acc")
public class AccountController {
    @Resource
    AccountDao accountDao;
    @RequestMapping("query")
    public String query(Model model){
        model.addAttribute("acc",accountDao.selectAll());
        return "test";
    }
}
