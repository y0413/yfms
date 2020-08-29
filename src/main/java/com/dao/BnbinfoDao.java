package com.dao;


import com.entity.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;


import com.entity.Bnbinfo;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;
@org.apache.ibatis.annotations.Mapper
public interface BnbinfoDao extends Mapper<Bnbinfo> {
//    @Select("select b.*,r.rname,l.lnotes,h.hname,d.title " +
//            "from bnbinfo as b " +
//            "join rommtype as r " +
//            "on b.rid=r.rid " +
//            "join livable as l " +
//            "on b.liva_id=l.liva_id " +
//            "join house_type as h " +
//            "on b.hid=h.hid " +
//            "join describes as d " +
//            "on b.did=d.did ")
//    List<Bnbinfo>  select();
    @Update("update bnbinfo set did=${did} where bnbid=${bnbid}")
    int upDid(@Param("did") Integer did,@Param("bnbid") Integer bnbid);
    @Update("update id set bnbid=bnbid+1")
    int upBnbid();
    @Update("update id set did=did+1")
    int upIDid();
//    @Select("select bedroom,room,toilet,kitchen,other from bnbinfo where bnbid=2")
//    Map<String,Object> selectPic();
//    @Update("update bnbinfo set bedroom=${p1},room=${p2},toilet=${p3},kitchen=${p4},other=${p5} where bnbid=${bnbid}")
//    int upPic(@Param("p1") String p1,@Param("p2") String p2,@Param("p3") String p3,@Param("p4") String p4,@Param("p5") String p5,@Param("bnbid") Integer bnbid);
    //图片
    @Update("update bnbinfo set ${d}=#{p1} where bnbid=${bnbid}")
    int upPic(@Param("d") String d,@Param("p1") String p1,@Param("bnbid") Integer bnbid);
    //设施
    @Update("update bnbinfo set ${s}=0 where bnbid=${bnbid}")
    int upSs(@Param("s") String s,@Param("bnbid") Integer bnbid);
}
