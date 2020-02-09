package cn.edu.zjut.authcode;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 王凌云
 * 用户注册时，手机验证码的发送和验证
 */
@Service
public class AuthCodeService implements IAuthCodeService {
    //发送验证码的请求路径URL
    private static final String
            SERVER_URL="https://api.netease.im/sms/sendcode.action";
    //网易云信分配Appkey
    private static final String
            APP_KEY="APP KEY";
    //网易云信分配的密钥
    private static final String APP_SECRET="APP SECRET";
    //随机数
    private static final String NONCE="123456789";
    //短信模板ID
    private static final String TEMPLATEID="TEMPLATE ID";
    //验证码长度，范围4～10，默认为4
    private static final String CODELEN="6";

    /**
     * @param phone 手机号
     * @return boolean
     */
    @Override
    public boolean sendMsg(String phone) {
        System.out.println("正在执行sendMsg方法...");

        HttpPost httpPost = new HttpPost(SERVER_URL);
        String curTime = String.valueOf((new Date()).getTime() / 1000L);
        String checkSum = CheckSumBuilder.getCheckSum(APP_SECRET, NONCE, curTime);

        // 设置请求的header
        httpPost.addHeader("AppKey", APP_KEY);
        httpPost.addHeader("Nonce", NONCE);
        httpPost.addHeader("CurTime", curTime);
        httpPost.addHeader("CheckSum", checkSum);
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

        // 设置请求的的参数，requestBody参数
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        nameValuePairs.add(new BasicNameValuePair("templateid", TEMPLATEID));
        nameValuePairs.add(new BasicNameValuePair("mobile", phone));
        nameValuePairs.add(new BasicNameValuePair("codeLen", CODELEN));

        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, "utf-8"));
            // 执行请求
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpResponse response = httpClient.execute(httpPost);
            String responseResult = EntityUtils.toString(response.getEntity(), "utf-8");
            System.out.println("responseResult: "+responseResult);

            String stateCode = JSON.parseObject(responseResult).getString("code");
            return stateCode.equals("200");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @param mobile 手机号
     * @param code 表单输入验证码
     * @return boolean
     */
    @Override
    public boolean verifyCode(String mobile, String code){
        System.out.println("正在执行verifyCode方法...");

        HttpPost httpPost = new HttpPost("https://api.netease.im/sms/verifycode.action");
        String currentTime = String.valueOf(new Date().getTime()/1000L);
        String checkSum = CheckSumBuilder.getCheckSum(APP_SECRET,NONCE,currentTime);

        // 设置请求的header
        httpPost.setHeader("AppKey",APP_KEY);
        httpPost.setHeader("CurTime",currentTime);
        httpPost.setHeader("Nonce",NONCE);
        httpPost.setHeader("CheckSum",checkSum);
        httpPost.setHeader("Content-Type","application/x-www-form-urlencoded;charset=utf-8");

        // 设置请求的的参数，requestBody参数
        List<NameValuePair> nameValuePairList = new ArrayList<NameValuePair>();
        nameValuePairList.add(new BasicNameValuePair("code",code));
        nameValuePairList.add(new BasicNameValuePair("mobile",mobile));

        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairList,"utf-8"));
            // 执行请求
            CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
            HttpResponse httpResponse = closeableHttpClient.execute(httpPost);
            String responseResult = EntityUtils.toString(httpResponse.getEntity(),"utf-8");
            System.out.println("responseResult:"+responseResult);
            String stateCode = JSON.parseObject(responseResult).getString("code");
            return stateCode.equals("200");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
