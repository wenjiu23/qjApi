package com.yu.api_client.util;

import cn.hutool.crypto.digest.DigestUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SignUtils {
	public static String getSign(String body, String secretKey) {
		String content = body + "." + secretKey;
		return DigestUtil.md5Hex(content);
	}
	public static StringBuilder sendHttp(String apiUrl) throws IOException {
		URL url = new URL(apiUrl);
		// 创建HttpURLConnection对象，并设置请求方法为GET
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		// 发送请求并获取响应状态码
		int responseCode = connection.getResponseCode();
		System.out.println("Response Code: " + responseCode);
		// 读取响应内容
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String line;
		StringBuilder response = new StringBuilder();
		while ((line = reader.readLine()) != null) {
			response.append(line);
		}
		reader.close();
		return response;
	}
}