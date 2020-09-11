package com.dao;


import com.entity.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;


import com.entity.Bnbinfo;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;
@org.apache.ibatis.annotations.Mapper
public interface BnbinfoDao extends Mapper<Bnbinfo> {
    //查询预定日期
    @Select("select * from orders where #{sttime} between starttime and sendtime and bnbid=#{bnbid} and state=0")
    List<Map> selectOrYd(@Param("sttime") String sttime,@Param("bnbid") Integer bnbid);
    //下架房源
    @Update("update bnbinfo set bnbshelf=1 where bnbid=#{bnbid}")
    int upBnbshelf(Integer bnbid);
    //添加房源成功
    @Update("update bnbinfo set uid=#{uid},bnbstate=0,bnbshelf=0 where bnbid=#{bnbid}")
    int upBnbUB(@Param("uid") Integer uid,@Param("bnbid") Integer bnbid);
    //更改房客为房东
    @Update("update users set state=0 where uid=#{uid}")
    int upUstate(Integer uid);
    @Select("select * from bnbinfo b \n" +
            "join orders o on b.bnbid=o.bnbid\n" +
            "where b.bnbid=#{bnbid} and o.state=0")
    List<Map<String,Object>> queryBnbOrder(Integer bnbid);
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
    @Select("select * from bnbinfo b join rommtype r on b.rid=r.rid join livable l on b.liva_id=l.liva_id\n" +
            "join house_type h on b.hid=h.hid join describes d on b.did=d.did where bnbid=#{bnbid}")
    Map<String,Object> queryBnbinfo(Integer bnbid);
    @Select("select * from bnbinfo where bnbstate=0 and bnbshelf=0 limit 7 ")
    List<Bnbinfo> selectLimit();
    @SelectProvider(type = SelectBnbinfo.class,method = "selectBnb")
    List<Map<String,Object>> selectListB(Map map);
    class SelectBnbinfo{
        public String selectBnb(Map map){
            String city=(String) map.get("city");
            String bnbname=(String) map.get("bnbname");
            String hid=(String) map.get("hid");
            Integer liva_id= (Integer) map.get("liva_id");
            Object startprice = map.get("startprice");
            Object endprice = map.get("endprice");
            String sql="select * from bnbinfo b " +
                    "join rommtype r on b.rid=r.rid " +
                    "join livable l on b.liva_id=l.liva_id\n" +
                    "join house_type h on b.hid=h.hid " +
                    "join describes d on b.did=d.did where 1=1 and bnbstate=0 and bnbshelf=0 ";
            if(!city.equals("")){
                sql+=" and city='"+city+"'";
            }
            if(!bnbname.equals("")){
                sql+=" and bnbname like '%"+bnbname+"%'";
            }
            if(!hid.equals("")){
                sql+=" and b.hid='"+hid+"'";
            }
            if(liva_id!=0){
                sql+=" and b.liva_id='"+liva_id+"'";
            }
            sql+=" and price between '"+startprice+"' and '"+endprice+"'";
            return sql;
        }
    }
}
