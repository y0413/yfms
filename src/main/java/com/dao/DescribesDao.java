package com.dao;

import com.entity.Describes;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface DescribesDao extends Mapper<Describes> {
    //添加
//    @Insert("insert into describes " +
//            "(title,desbes,internal,traffic,spots) " +
//            "values " +
//            "(#{title},#{desbes},#{internal},#{traffic},#{spots} )")
//    Integer addDes(Describes describes);
    //查询
    @Select("select * from describes")
    List<Describes> listAll();
}
