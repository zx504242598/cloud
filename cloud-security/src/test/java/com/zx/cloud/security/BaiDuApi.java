package com.zx.cloud.security;

import com.baidu.aip.ocr.AipOcr;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * @author zhaoxuan
 * @date 2021-02-01 10:08
 **/
public class BaiDuApi {
    //设置APPID/AK/SK
    public static final String APP_ID = "10788887";
    public static final String API_KEY = "pdGahT3ggPjhLGSPKbu4eV2U";
    public static final String SECRET_KEY = "Lxp4DP0HIjDPPYBe6c3dtW6pt6fIeAaH";

    public static void main(String[] args) throws JSONException {
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
        //client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
        //client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
        //System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

        // 调用接口
        String path = "D:\\八个抓要求2.0（电脑版） (1).png";
        JSONObject res = client.basicAccurateGeneral(path, new HashMap<String, String>());
        System.out.println(res.toString(2));

    }
}
