package com.dao;

import com.entity.Users;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.Map;

@org.apache.ibatis.annotations.Mapper
public interface UsersDao extends Mapper<Users> {
    @Select("select * from users where uname=#{uname} and upwd=#{upwd} and ustate=0")
    List<Map> queryName(@Param("uname") String uname,@Param("upwd") String upwd);
    @Select("select * from users where uid=#{uid}")
    List<Map> queryUid(@Param("uid") Integer uid);
    @Insert("insert into users (uname,upwd) values (#{uname},#{upwd})")
    int adduser(@Param("uname") String uname,@Param("upwd") String upwd);
    @Insert("insert into users (uname,upwd,photo) values (#{uname},#{upwd},#{photo})")
    int addusers(@Param("uname") String uname,@Param("upwd") String upwd,@Param("photo") String photo);
    @Select("select * from users where photo =#{photo}")
    List<Map> usersphoto(@Param("photo") String photo);
    @Update("update users set upwd=#{upwd} where photo=#{photo}")
    int updateUpwd (@Param("upwd") String upwd,@Param("photo") String photo);
    @Update("update users set uname=#{uname} where uid=#{uid}")
    int updateuname(@Param("uname")String uname,@Param("uid")String uid);
    @Update("update users set photo=#{photo} where uid=#{uid}")
    int updatephoto(@Param("photo")String photo,@Param("uid")String uid);
    @Update("update users set usex=#{usex},truename=#{truename},email=#{email},idcard=#{idcard} where uid=#{uid}")
    int updates(@Param("usex") String usex,@Param("truename")String truename,@Param("email") String email,@Param("idcard")String idcard,@Param("uid")String uid);
    @Update("update users set ptel=#{ptel} where uid=#{uid}")
    int updatePic(@Param("ptel") String ptel,@Param("uid") Integer uid);


    //查询房源
    @Select("select * from users u \n" +
            "join bnbinfo b on u.bnbid=b.bnbid\n" +
            "where uid=#{uid}")
    List<Map> queryBnb(Integer uid);
    //查询支付宝
    @Select("select * from account where uid=#{uid}")
    Map queryAcc(Integer uid);
    //修改支付宝
    @Update("update account set acc=#{acc},idcard=#{idcard} where uid=#{uid}")
    int updateAcc(@Param("acc") String acc,@Param("idcard") String idcard,@Param("uid") Integer uid);
    //修改账户余额
    @Update("update users set money=money-#{upmoney} where uid=#{uid}")
    int upMoney(@Param("upmoney") Float upmoney,@Param("uid") Integer uid);
    //添加提现记录
    @Insert("insert into withdrawal (uid,times,total_price,coll_mode) values(#{uid},now(),#{total_price},#{aid}) ")
    int addTx(@Param("uid") Integer uid,@Param("total_price") Float total_price,@Param("aid") Integer aid);
    //查看提现记录
    @Select("select * from withdrawal w \n" +
            "join users u on w.uid=u.uid \n" +
            "join account a on w.coll_mode=a.aid\n" +
            "where w.uid=#{uid}")
    List<Map> queryTx(Integer uid);

}
