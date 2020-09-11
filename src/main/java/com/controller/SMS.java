package com.controller;



import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.dao.UsersDao;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
@CrossOrigin
@RequestMapping("/test")
@Controller
public class SMS {
@Resource
    UsersDao usersDao;
    String Url = "http://106.ihuyi.cn/webservice/sms.php?method=Submit";
    private String json;
    private static  int mobile_code = (int)((Math.random()*9+1)*100000);
    @RequestMapping("show")
    @ResponseBody
    public void main(String phone){
        HttpClient client = new HttpClient();
        PostMethod method = new PostMethod(Url);
        client.getParams().setContentCharset("GBK");

//        method.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"GBK");
        method.setRequestHeader("ContentType","application/x-www-form-urlencoded;charset=GBK");
        String content = ("您的验证码是：" + mobile_code + "。请不要把验证码泄露给其他人。");
        NameValuePair[] data = {//提交短信
                new NameValuePair("account", "C32117758"), //查看用户名是登录用户中心->验证码短信->产品总览->APIID
                new NameValuePair("password", "e0584c22d30543cae845e975ae02ec50 "),  //查看密码请登录用户中心->验证码短信->产品总览->APIKEY
                //new NameValuePair("password", util.StringUtil.MD5Encode("密码")),
                new NameValuePair("mobile", phone),
                new NameValuePair("content", content),
                new NameValuePair("format",json)
        };
        method.setRequestBody(data);
        System.out.println(data);

        try {
            client.executeMethod(method);

            String SubmitResult =method.getResponseBodyAsString();

            //System.out.println(SubmitResult);

            Document doc = DocumentHelper.parseText(SubmitResult);
            Element root = doc.getRootElement();

            String code = root.elementText("code");
            String msg = root.elementText("msg");
            String smsid = root.elementText("smsid");

            System.out.println(code);
            System.out.println(msg);
            System.out.println(smsid);

            if("2".equals(code)){
                System.out.println("短信提交成功");
            }

        } catch (HttpException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @RequestMapping("content")
    @ResponseBody
    public int content(int mobile){
        System.out.println(mobile_code);
        if(mobile ==mobile_code){
            System.out.println(111);
            return 1;
        }
        return 2;
    }
    @RequestMapping("addusers")
    @ResponseBody
    public int addusers(String uname,String upwd,String photo){
        return usersDao.addusers(uname,upwd,photo);
    }
    @RequestMapping("usersphoto")
    @ResponseBody
        public List<Map> usersphoto(String photo){
            return usersDao.usersphoto(photo);
    }

}