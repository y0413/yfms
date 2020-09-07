package com.dao;

import com.entity.Reply;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@org.apache.ibatis.annotations.Mapper
public interface ReplyDao {

    @Select("select r.*,u.uname as pinglun_person,us.uname as huifu_person,r.context,r.rtime\n" +
            " from reply r \n" +
            " join users u \n" +
            " on r.uid = u.uid\n" +
            " join users us \n" +
            " on r.reply_person = us.uid \n" +
            " join comments c \n" +
            " on c.cid = r.cid ")
    List<Reply> listAll();

    @Insert("insert into reply \n" +
            "(uid,context,rtime,cid,reply_person) \n" +
            "values \n" +
            "(#{uid},#{context},now(),cid,reply_person)")
    Integer addRep(Reply reply);

}
