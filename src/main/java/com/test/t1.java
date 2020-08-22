package com.test;

import com.Dao.boardDao;
import com.Entity.board;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
@RestController
public class t1 {
        @Resource
         boardDao boardDao;
        @RequestMapping("select")
        public List<board> select(){
            System.out.println(111);
            return  boardDao.selectAll();
        }
}
