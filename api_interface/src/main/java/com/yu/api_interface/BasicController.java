/*
 * Copyright 2013-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.yu.api_interface;


import com.common.model.entity.InvokeRequest;

import com.yu.api_client.util.SignUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
@RequestMapping("/api")
public class BasicController {


    /**
     * QQ翻译接口
     */
    @PostMapping("/txt/QQFanyi")
    public String getNameByGet(@RequestBody InvokeRequest param) {
        StringBuilder response = null;
        try {
            //"%20"是URL编码中表示空格的方式
            String apiUrl = "https://api.oioweb.cn/api/txt/QQFanyi?sourceText=" + param.getSourceText().replace(" ", "%20");
            // 创建URL对象
            response = SignUtils.sendHttp(apiUrl);
            // 输出响应内容
            System.out.println("Response Body: " + response.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //断言检查
        assert response != null;
        return response.toString();
    }

    /**
     * IP归属地查询接口
     *
     * @param param
     */
    @PostMapping("/ip/ipaddress")
    public String getIpAddress(@RequestBody InvokeRequest param) {
        StringBuilder response = null;
        try {
            String apiUrl = "https://api.oioweb.cn/api/ip/ipaddress?ip=" + param.getIp().replace(" ", "%20");
            // 创建URL对象
            response = SignUtils.sendHttp(apiUrl);
            // 输出响应内容
            System.out.println("Response Body: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assert response != null;
        return response.toString();
    }


    /**
     * 随机头像接口
     */
    @PostMapping("/picture/miyoushe_avatar")
    public String getAvatarByPost() {
        String location=null;
        try {
            String apiUrl = "https://www.loliapi.com/acg/pp/";
            HttpURLConnection conn = (HttpURLConnection) new URL(apiUrl)
                    .openConnection();
            conn.setInstanceFollowRedirects(false);
            conn.setConnectTimeout(5000);
            location = conn.getHeaderField("Location");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return location;
    }


    /**
     * 登录用户名接口
     *
     * @param param
     * @param request
     * @return
     */
    @PostMapping("/name")
    public String getUserNameByPost(@RequestBody InvokeRequest param, HttpServletRequest request) {
        return "当前系统登录用户名为 " + param.getName();
    }




    /**
     * 每日一句英文接口
     */
    @PostMapping("/common/OneDayEnglish")
    public String getOneDayEnglish(@RequestBody InvokeRequest param) {
        StringBuilder response = null;
        try {
            String apiUrl = "https://api.oioweb.cn/api/common/OneDayEnglish";
            // 创建URL对象
            response = SignUtils.sendHttp(apiUrl);
            // 输出响应内容
            System.out.println("Response Body: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assert response != null;
        return response.toString();
    }


    /**
     * 聊天机器人接口
     */
    @PostMapping("/ai/chat")
    public String getChat(@RequestBody InvokeRequest param) {
        StringBuilder response = null;
        try {
            String apiUrl = "https://api.oioweb.cn/api/ai/chat?text="+param.getText().replace(" ", "%20");;;
            // 创建URL对象
            response = SignUtils.sendHttp(apiUrl);
            // 输出响应内容
            System.out.println("Response Body: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assert response != null;
        return response.toString();
    }


    /**
     * 判断是否是骚扰号码
     * @param param
     * @return
     */
    @PostMapping("/search/harassPhone")
    public String getHarassPhone(@RequestBody InvokeRequest param) {
        StringBuilder response = null;
        try {
            String apiUrl = "https://api.oioweb.cn/api/search/harassPhone?phone="+param.getPhone().replace(" ", "%20");;;
            // 创建URL对象
            response = SignUtils.sendHttp(apiUrl);
            // 输出响应内容
            System.out.println("Response Body: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assert response != null;
        return response.toString();
    }

    /**
     * QQ信息接口
     */
    @PostMapping("/qq/info")
    public String getQqInfo(@RequestBody InvokeRequest param) {
        StringBuilder response = null;
        try {
            String apiUrl = "https://api.oioweb.cn/api/qq/info?qq="+param.getQq().replace(" ", "%20");
            // 创建URL对象
            response = SignUtils.sendHttp(apiUrl);
            // 输出响应内容
            System.out.println("Response Body: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assert response != null;
        return response.toString();
    }


}
