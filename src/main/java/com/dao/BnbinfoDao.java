package com.dao;

import com.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface BnbinfoDao {
    @Select("select b.*,r.rname,l.lnotes,h.hname,d.title " +
            "from bnbinfo as b " +
            "join rommtype as r " +
            "on b.rid=r.rid " +
            "join livable as l " +
            "on b.liva_id=l.liva_id " +
            "join house_type as h " +
            "on b.hid=h.hid " +
            "join describes as d " +
            "on b.did=d.did ")
    List<Bnbinfo>  select();
}
