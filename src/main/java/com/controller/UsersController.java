package com.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.CertAlipayRequest;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayFundTransUniTransferModel;
import com.alipay.api.domain.Participant;
import com.alipay.api.request.AlipayFundTransUniTransferRequest;
import com.alipay.api.response.AlipayFundTransUniTransferResponse;
import com.dao.UsersDao;
import com.entity.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import java.util.Map;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("UsersController")
public class UsersController {
    @Resource
    UsersDao usersDao;
    @RequestMapping("queryName")
    public List<Map> queryName(String uname,String upwd){
        return usersDao.queryName(uname,upwd);
    }
    @RequestMapping("adduser")
    public int adduser(String uname,String upwd){
        return usersDao.adduser(uname,upwd);
    }
    @RequestMapping("updateUpwd")
    public int updateUpwd(String upwd,String photo){
        return usersDao.updateUpwd(upwd,photo);
    }@RequestMapping("updateUname")
    public int updateUname(String uname,String uid){
        return usersDao.updateuname(uname,uid);
    }@RequestMapping("updatephoto")
    public int updatephoto(String photo,String uid){
        return usersDao.updatephoto(photo,uid);
    }@RequestMapping("updates")
    public int updates(String usex,String truename,String email,String idcard,String uid){
        return usersDao.updates(usex,truename,email,idcard,uid);
    }
    Integer pteluid=0;
    @RequestMapping("Uid")
    public String Uid(Integer uid){
        pteluid=uid;
        System.out.println(pteluid);
        return "1";
    }
    @RequestMapping("queryUid")
    public List<Map> queryUid(Integer uid){
//        System.out.println("执行");
        List<Map> users = usersDao.queryUid(uid);
//        System.out.println(users);
        System.out.println(111);
        return usersDao.queryUid(uid);
    }
    @Value("${prop.upload-folder}")
    private String UPLOAD_FOLDER;
    //图片上传
    @PostMapping("/singlefile")
    public Object singleFileUpload(@RequestParam("file") MultipartFile[] file, String pic) throws Exception  {
        for (MultipartFile s : file) {
            byte[] bytes = s.getBytes();;
            // 原文件名
            String originalFilename = s.getOriginalFilename();
            // 判断是否有文件
            if(null != originalFilename && !"".equals(originalFilename)){
                //获取文件后缀
                String fileExt = s.getOriginalFilename().substring(s.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();
                // 重构文件名称
                String pikId = UUID.randomUUID().toString().replaceAll("-", "");
//                System.out.println("xxx:"+pikId);
                Path path = Paths.get(UPLOAD_FOLDER + s.getOriginalFilename().lastIndexOf(".")+ pikId + "." + fileExt);
                System.out.println("xx:"+path);
                //如果没有files文件夹，则创建
                if (!Files.isWritable(path)) {
                    Files.createDirectories(Paths.get(UPLOAD_FOLDER));
                    // System.out.println(Files.createDirectories(Paths.get(UPLOAD_FOLDER)));
                }
                //上传文件
                Files.write(path, bytes);
//                int bnbid=queryBnbid();
//                bnbid=bnbid-1;
                usersDao.updatePic(path.toString(),pteluid);
//                bnbinfoDao.upPic(pic,path.toString(),bnbid);
            }
        }
        return "ok";
    }

    //修改金额
    @RequestMapping("upMoney")
    public Object upMoney(Float upmoney, Integer uid){
        //String publicKey = AlipaySignature.getAlipayPublicKey("E:/Alipayzs/appCertPublicKey_2016102100729420.crt");
        //System.out.println("应用公钥数据："+publicKey);
        /** 初始化 **/
        CertAlipayRequest certAlipayRequest = new CertAlipayRequest();
        /** 支付宝网关 **/
        certAlipayRequest.setServerUrl("https://openapi.alipaydev.com/gateway.do");
        /** 应用id，如何获取请参考：https://opensupport.alipay.com/suppv90iort/helpcenter/190/201602493024 **/
        certAlipayRequest.setAppId("2021000119609154");
        /** 应用私钥, 如何获取请参考：https://opensupport.alipay.com/support/helpcenter/207/201602471154?ant_source=antsupport **/
        certAlipayRequest.setPrivateKey("MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCzfYMsyGznRfeuHAfCanBun/sl2xmtNHxi+42RWQMdzI5J34ytZ9ClmPw9xOzKrsFvo3K/JOQt1VkJf1c9d5cK/N/ukuA2zaO5+U0HPkQBIS8W6SgJhekklsTYd55b0QWfF6VFArfYjuerfUhwcijiJ1yiWwq/GdACh6FbqNUIWQouG7o+GUXBQrJ6H0YN0xFR9WW5KpfhuwSveKzybFCnDDlZohSsdKQPrlugs4bmfy/H1svpx44Zme5eCAmMgLDr8G2s1Xmd8218ACYOH1urDo8czMjSAyBdk6nXojEvwcTTC0jmls9OyWQ+iQv7qLWeX7NQI+Omp/eNWVogS6czAgMBAAECggEAD2I1iPQQqW3MwaZzX81hn4mkq+TweXDjLFSlGI0JgFdU5q37T61zK45GKEEljmWV/KyEnC9cQzVi8TZx0rnaPz3XL4p1Hx1W6Aye9nz2tSYT9CG9pbtNdS5a5rax4uqyUaVkK9sEyNHOt1sAh2qxaFi5Ts0Ayco7ksvvH30D7TgXr8+dXj0FEiNArP95EAPIa6sQWzwWC4sGIHEM57ZePU7tjxm6+oNX54DGb974dlaYc6JyolLHxtW3x3R98UaVZ19Utr9nTpcBdjYcIijRrp6uTWp+/2jhAEFUy4GFaQ7AfGV82jMBibDHnRQJN3rlG4ajCuiR56sdEAwXPMGBSQKBgQDanBqu6lM02RkD/I9uM9n9PDYIBpF1lNt2eWnvSy2MYcSUClmF1gH9AiK2+wBMY0cEZtWaruqOn6++U3rfl6Sg3SlQXBRAOkxXkWwdTkIJHlfAlzEjAR/1+fbnubs5mZnN+lHlge14KMtqJcqoszp73egCdfBPXRLvuoYhhCM/vQKBgQDSMIyLQ/ybOP/xSxpBJ7uH9seF4ctv4y32DreszQ+NXcrGE9bXqCxyVByTzOB4Y/9M3eMlQP9EOOamfDSXfGyNk2p0aE/rgBPrJ/0SK+G0eOrnT5BqzKeIlqRpqU34+RgUPH230GjRH5jUgMOR7d25HgvsZS4eXyODX1/PVio5rwKBgEvqoB2URHb62YQX5htoKFCX40+gME1790bKXS57lgLFRQYAHhyrOB+L6VBQFEdyxovRxmYkTlJfRCG9TdNuDv7KLvm4MFQpqq9SUhBPSAFwpxq7ppW4Y0gBmWvZhRo4rD/qqRwhpbzvtcxT+W/iZfH0GwkXue9lrBjSVpg3EiKlAoGBAMepEnhgFp6kYIunGcN2qK8Y/qLwv70DAm/Pvy5IhFN3Gt1ZjyXAPKhFufe0EC6MXsF3rQOAYHs/yemv5o1Xxg4eUGtPg0tjmIgyrjUKthYnHoynibnJugMHhhpQlx7AD915MLrhIBA2gYiq4BvI5muoXQ8rdcmn+iYa/PoJEYdFAoGAW1Y6G31WyWpipdAKVkThh/mN6rPUhxdbmgX5KXff7oCERp5RfTRs/B9Yxuu/SXvnuWMNRoIFqrG/0VkUI+pOD3c2pMsxc4A9riQtEzUPUYOaDahzPr2wmXz2nTQaf/nq+i2O2PTGyd0ixKm7W90WBtiofqR5q7orJ2ldY7ZSVIE=");
        /** 应用公钥证书路径，下载后保存位置的绝对路径 **/
        certAlipayRequest.setCertPath("E:/Alipaymy/appCertPublicKey_2021000119609154.crt");
        /** 支付宝公钥证书路径，下载后保存位置的绝对路径 **/
        certAlipayRequest.setAlipayPublicCertPath("E:/Alipaymy/alipayCertPublicKey_RSA2.crt");
        /** 支付宝根证书路径，下载后保存位置的绝对路径 **/
        certAlipayRequest.setRootCertPath("E:/Alipaymy/alipayRootCert.crt");
        /** 设置签名类型 **/
        certAlipayRequest.setSignType("RSA2");
        /** 设置请求格式，固定值json **/
        certAlipayRequest.setFormat("json");
        /** 设置编码格式 **/
        certAlipayRequest.setCharset("UTF-8");

        AlipayClient alipayClient = null;
        try {
            alipayClient = new DefaultAlipayClient(certAlipayRequest);
        } catch (AlipayApiException e1) {
            e1.printStackTrace();
        }
        /** 实例化具体API对应的request类，类名称和接口名称对应,当前调用接口名称：alipay.fund.trans.uni.transfer(单笔转账接口) **/
        AlipayFundTransUniTransferRequest request = new AlipayFundTransUniTransferRequest();
        /** 设置业务参数，具体接口参数传值以文档说明为准：https://opendocs.alipay.com/apis/api_28/alipay.fund.trans.uni.transfer/ **/
        AlipayFundTransUniTransferModel model = new AlipayFundTransUniTransferModel();
        //获取当前时分秒生成订单号
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddkkmmss ");
        String dd=sdf.format(d);
        System.out.println("格式化输出：" + sdf.format(d));
        /** 商户端的唯一订单号，对于同一笔转账请求，商户需保证该订单号唯一 **/
        model.setOutBizNo(dd);
        /** 转账金额，TRANS_ACCOUNT_NO_PWD产品取值最低0.1 **/
        model.setTransAmount(upmoney.toString());
        /** 产品码，单笔无密转账到支付宝账户固定为：TRANS_ACCOUNT_NO_PWD **/
        model.setProductCode("TRANS_ACCOUNT_NO_PWD");
        /** 场景码，单笔无密转账到支付宝账户固定为：DIRECT_TRANSFER **/
        model.setBizScene("DIRECT_TRANSFER");
        /** 转账业务的标题，用于在支付宝用户的账单里显示 **/
        model.setOrderTitle("阳房");
        Participant participant = new Participant();
        /** 参与方的唯一标识,收款支付宝账号或者支付宝吧账号唯一会员ID **/
        participant.setIdentity("gfkyun2561@sandbox.com");

        /** 参与方的标识类型：ALIPAY_USER_ID 支付宝的会员ID **/
        participant.setIdentityType("ALIPAY_LOGON_ID");
        /** 参与方真实姓名，如果非空，将校验收款支付宝账号姓名一致性。当identity_type=ALIPAY_LOGON_ID时，本字段必填 **/
        participant.setName("沙箱环境");
        model.setPayeeInfo(participant);
        /** 业务备注 **/
        model.setRemark("ddd");
        request.setBizModel(model);
        AlipayFundTransUniTransferResponse response = null;
        try {
            response = alipayClient.certificateExecute(request);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        /** 获取接口调用结果，如果调用失败，可根据返回错误信息到该文档寻找排查方案：https://opensupport.alipay.com/support/helpcenter/107 **/
        System.out.println(response.getBody());
        System.out.println();
        Integer i = usersDao.upMoney(upmoney,uid);
//        System.out.println("金額:"+upmoney+", 用戶ID:"+uid);
//        System.out.println("提現成功:"+i);
        if(i>0){
            return i;
        }
        return null;
    }
}
