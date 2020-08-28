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
}
