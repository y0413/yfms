package com.dao;

import com.entity.Comments;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@org.apache.ibatis.annotations.Mapper
public interface CommentsDao {

    @Select("select * from comments c \n" +
            "join users u \n" +
            "on c.uid = u.uid \n" +
            "join bnbinfo b \n" +
            "on c.bnbid = b.bnbid")
    List<Comments> listAll();

    @Select("select * from comments where cid = #{cid}")
    Comments listById(@Param("cid") Integer cid);

    @Insert("insert into comments \n" +
            "(context,ctime,uid,bnbid) \n" +
            "values \n" +
            "(#{context},now(),#{uid},#{bnbid})")
    Integer addCom(Comments comments);
}
