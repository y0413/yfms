package com.controller;

import com.dao.OrdersDao;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

import com.dao.OrderDao;
import com.entity.Orders;
import com.util.AlipayConfig;
import lombok.extern.slf4j.Slf4j;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.Resource;

@CrossOrigin
@Controller
@RequestMapping("order")
public class OrdersController {

    @Resource
    OrderDao orderDao;

    @Resource
    OrdersDao ordersDao;

    @RequestMapping("queryOrders")
    public List<Map<String, Object>> queryOrders(Integer uid,Integer state){
        return ordersDao.queryOrders(uid,state);
    }
    @RequestMapping("queryComments")
    public List<Map<String, Object>> queryComments(Integer uid){
        return ordersDao.queryComments(uid);
    }

    @RequestMapping("query")
    @ResponseBody
    public List<Map> query(){
        return orderDao.query();
    }

    @RequestMapping("listAll")
    @ResponseBody
    public Object listAll(){
        return orderDao.listAll();
    }

    @RequestMapping("addOrder")
    @ResponseBody
    public Object addOrder(@RequestBody Orders ordetails) {
        Integer i = orderDao.addOrder(ordetails);
        if (i>0){
            return i;
        }
        return null;
    }

   @RequestMapping(value = "pay")
   @ResponseBody
    public void pay(String order_number,String bnbname,String order_price, HttpServletRequest request, HttpServletResponse response) throws IOException{
       //获得初始化的AlipayClient
       AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl,AlipayConfig.app_id,AlipayConfig.merchant_private_key,"json",AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

       //设置请求参数
       AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
       alipayRequest.setReturnUrl(AlipayConfig.return_url);
       alipayRequest.setNotifyUrl(AlipayConfig.notify_url);


       //商户订单号，商户网站订单系统中唯一订单号，必填
       String out_trade_no = order_number;
       //付款金额，必填
       String total_amount = order_price;
       //订单名称，必填
       String subject = bnbname;
       //商品描述，可空
//       String body = "sd";
//        String timeout_express = "1m";
       alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
               + "\"total_amount\":\""+ total_amount +"\","
               + "\"subject\":\""+ subject +"\","
//               + "\"body\":\""+ body +"\","
               + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

       //请求
       String form="";
       try {
           form = alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单
       } catch (AlipayApiException e) {
           e.printStackTrace();
       }
       response.setContentType("textml;charset=" + AlipayConfig.charset);
       response.getWriter().write(form);//直接将完整的表单html输出到页面
       response.getWriter().flush();
       response.getWriter().close();
   }

}
