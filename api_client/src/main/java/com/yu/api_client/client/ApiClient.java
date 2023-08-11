package com.yu.api_client.client;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import com.common.model.entity.InvokeRequest;
import com.yu.api_client.util.SignUtils;

import java.util.HashMap;
import java.util.Map;



public class ApiClient {
    private static final String GATEWAY_HOST = "http://8.130.134.112:8090";

    private String accessKey;

    private String secretKey;

    private String url;

    public ApiClient(String accessKey, String secretKey, String url) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
        this.url = url;
    }

    public String invokeInterface(InvokeRequest invokeRequest ){
        String json = JSONUtil.toJsonStr(invokeRequest);
        HttpResponse httpResponse = HttpRequest.post( url)
                .addHeaders(getHeaderMap(json))
                .body(json)
                .execute();
        return httpResponse.body();
    }



    private Map<String, String> getHeaderMap(String body) {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("accessKey", accessKey);
        // 一定不能直接发送
        //hashMap.put("secretKey", secretKey);
        hashMap.put("nonce", RandomUtil.randomNumbers(4));
        hashMap.put("body", body);
        hashMap.put("timestamp", String.valueOf(System.currentTimeMillis()));
        hashMap.put("sign", SignUtils.getSign(body, secretKey));
        return hashMap;
    }


}