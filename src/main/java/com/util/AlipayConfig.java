package com.util;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {

    // 作为身份标识的应用ID
    public static String app_id = "2021000116699112";
    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key  = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCS8Bs5nkglyAjtPEXZbZ0A8ueVg/yFtBHw/G6onGyH2ywAuIrBsF5ozooPffKQgkzIdJW4+ML97Vx+XQgumj2K8KCETGLMFIPb2omFPORdDZLVx95oalaO16MFkj9KSh3zAw2zRLGQglDTCHND67bYmXOavVfrnq2kHQdi7l5VNZmOok7OI52T77C+ABBoV8PTIgFRwHgBb5B1QAG4Haoqb19yO013cxBMHkKk16w17aHAs87v3tf75XfRBFNoPs3FkhRlGrJp6pnC86ZxogSNVX1WnnNOsbn0OEv3mPfzxHEAlFEmKODeKLI57rgIMHOxk0DqaxEivIomSiBShCNnAgMBAAECggEAFLLeIu+5GhljqIelD0vxogCVvuoo2GzVWi01KWtfnoOxXyif40kFA56UtDn5wYGZb2N88+GXFk4piWNxk58GrFvZQMnB4R3CtWXDmZFKWhFfbd4J5ouURer6e/5uC/kE3wa/F1HF8aVp3VCDbD34M+rp7hJeIELqEwRD1hveDgKYG1ClY3ZsnLkEY3TzDBWx8M5pkIZFnZv+LHh6835GM+u44Jfw0BXuJgpRQJaFMMiiEdQI3fY0J24Hcb8VTdMeeHd2b8mft5xPPWoUm2IF8Y1073Dy7AmnGVk8o66Dx6hzlR6M+1MrercbWJzJwwuwdecg1lub126zA+YdM7MmgQKBgQDSjFT7b/VXnq3C1pQExyK5C3HSF+FqT5J7jQp9fuvfZ2KgOAAXLZLbZHmKhs3ZyjuLRcL8OzRme4UIdeAX6BltI9jR7r7oFIftQfuBd3UmYZXuh1WhAMkmY504T85KIpHdaij79vCKOI6iDnItOSfN++LihxehycfRXcg9qiMmxQKBgQCyqG/pqNWJTyrT0zKhkBrriuUjRr4NJLsJIwh/5fi7nbpP96hRIVCBVBvdhvk+6xcqmWKM/ldq6XeJif1v8JsNyX1k3i034wcWRbPDN6mA5nDY/UNuj6rRmJUkmbp/8pPfhfG1MBpschBbKJlQsSgNCqn4aaLKqPf7Qybm0oSkOwKBgQCwNucBMWjDFnkTMofbn9a9zIhMb9QnJ8XPRfHbqpg698ohkfzxaSEaIXNfrwcmGg3PuGlCtUJb61EiDZWqLITrRS84NHruvhAtUCXw60vO/amAYyAVihTP3ls9P/3FKj2udCUtDDWxWTh3BWQl2UopKYFwWeQ7ciecYMMwaO7WiQKBgQCla5IbrmjxNy03bsDdmTljyHo7PIAyWUUYw6hWDBBPX06oRm5BmHAbH06hwhy75h7QIa9/TuyQIFW/MtZHtGdMz7hcEd+adIoWVDmK0toOcNAiCfZKw5ltcjL97Z0iZPAIMdRIaJ6+tKpyTVgPv8iOssYILX8+2E6sBlRZuqh4CwKBgHe6ViDFmx2KrsylLoqq/+2s+tqDuIiBJqfV0vp75eLOuA/69f9Vv2hlLl6+Nqor2QCdOm4Jha6ezPwZ0btSHkY/bxkG9XfUBHYgmsYq1YIYfQo7yoaVljE7PmNFLXzyJfncCxjNjj9inDXPh3SqrPDAJAVwoJr7kCOxunG9FjOJ";
    //MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCVYPmbq6Vs1ubs/VUtRE0kOb8Xyl/5GwQV3vlad28c7ijiO4dWkVk8v0MKo/+rU5hkT0zS/ME+mp95FvyQq810zudUmnoLR9Y3MMLpemiQHmClQwcSbpINu/YF0L8+hvJXhY0y/xKemUKZ2Vs9EIMON0HJWCwzXQfbeBIv+S+t1TCS5dLBgJzp1OmpHZTIrRDDZq1pS8BuX4Hr0qDIKxridRPYoO3b+89/hC2hQ+qd6QiXytRVPKSaR7zktJDRna4ysvFeYTC5bK+qlx8EsJS0nAgMBAAECggEAdOV8r/u06uWJtS/SdigbDhw6lI2EaVZg7hSdodQRGdyuFcxr7qyz3rv15N/G63gs0rVAyMP0Sje8/j0mg8nXJtJiIPfHhR/Gtf+Ml6npzNYAtzO3ZKmvdpFxUzaEsLKYMVF4150g19RKNt6LmSj1aMMmMKCe01uL6ZzAW8PYKjAN6A1YOY++lb545WfEqZY2voH40H58uc+z5MGI1+1PvU1YglYKyf1L97DW558SCx4ebZfdkz6m9E3+lHgJr0gL70H+GrXxSNrNju/8vpmZacEG1SgtfQCMCbORmCyXdvjgvFgkacjkRmz8G9k5wcn+9GO8dWCElcDLLoglSNiAEQKBgQDiISQNPo+HwmWYx1m8kJe/onYPGah80g6nHhXInHAPR/ufUnaDw0tszN2zc+ou6pBFrhgrce7tggfT/m3jANOam7TVA6cH1jwDTUGyjQ82CzlZn0Lp4Am/4QRK3OtpHDo3tmeVE5HJy6Y8CsBtskfcHI1QhXnAi0qh4Yin4bz9AwKBgQCpHGl+GvF2R+MjqqqjGSfzNBx+rWQrlhwsJa6LRmSVbne4us9H+iftNJ4+CasI+Pzk8ib7vEXOkUb/k2r78u8yuQG0hFN9XXNHKBtBiD9XgY0Fav8G80H45QFRfLvqVzNjmjDOKYj57ItnkkZv/PhRnupeZCujqQS1xuAb+KAcDQKBgQDZjFysyUU4rNMlWpSAjvMPEHNYL60i+MvUB2OZrrc4XF49dw5B0X8c2zNnU9s267+E6eqi0We14+U4FI0PWVo6YhZk4LCvH3J5Erhj2MWLjtzL1iZ/7mQyz35br5Jjex6fPsMEbuFRLLVvCkD6yAvOPUHO97qcfOV+PAZGzSwOlQKBgFhzWeHxabX5552yGEnyUGjuKrE/M5Nwkg+tLdv+14EpJElkvCHjf5qb2OCN4f1xbaS52xXz5XcjmUT38A8Tg3S+O1wVki2SAUeIfKkMAEVep0ncKsOR3EG4VbYvTYJGVcSU004hf1lpFYj4gwrz/1WBjwgL0J9rOeFxwaofom7JAoGAF5E5XzDFC7REi14KvPYZko2vlkAcP/C3rWUoz8YK4BWitwLl/lwmWkymbEfSLw26Lo4zNnWKfdfc71AxhiafTSshWNo7gGgL21lgN9F5NG9B60txNl9pRrpKjTA+V63bfrD+jtu/l5+l7GjaBA9n8bFzfPz4swzAIfrV4NCffIo=";
    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkvAbOZ5IJcgI7TxF2W2dAPLnlYP8hbQR8PxuqJxsh9ssALiKwbBeaM6KD33ykIJMyHSVuPjC/e1cfl0ILpo9ivCghExizBSD29qJhTzkXQ2S1cfeaGpWjtejBZI/Skod8wMNs0SxkIJQ0whzQ+u22Jlzmr1X656tpB0HYu5eVTWZjqJOziOdk++wvgAQaFfD0yIBUcB4AW+QdUABuB2qKm9fcjtNd3MQTB5CpNesNe2hwLPO797X++V30QRTaD7NxZIUZRqyaeqZwvOmcaIEjVV9Vp5zTrG59DhL95j388RxAJRRJijg3iiyOe64CDBzsZNA6msRIryKJkogUoQjZwIDAQAB";
    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://www.baidu.com";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://www.baidu.com";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
}

