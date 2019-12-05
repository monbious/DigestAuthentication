package com.example.demo.practice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Http Digest Request contains POST、GET、PUT
 * 
 * @author zhouzhixiang
 * @date 2019-05-14
 */
public class HttpRequestUtilsTest {

	private static final Logger logger = LoggerFactory.getLogger(HttpRequestUtilsTest.class);

	private static String PARAM = "";
	private static final String USERNAME = "admin";
	private static final String PASSWORD = "gsjjd2015";

	public static void main(String[] args) {
		testSendGet();
	}

	public static void testSendGet() {
		//PARAM += "tm=" + System.currentTimeMillis();
		String getUrl = "http://11.154.17.161/ISAPI/System/time/localTime";
		// String s = HttpRequestUtils.sendGet(getUrl, PARAM, USERNAME, PASSWORD, null);
		String s = HttpRequestUtils.sendGet(getUrl, PARAM, USERNAME, PASSWORD, "json");
		System.out.println("result: " + s);
		DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		System.out.println(formatter1.format(LocalDateTime.parse(s, formatter)));
	}

	public static void testSendDelete() {
		String deleteUrl = "http://192.168.200.117:8087/v2/servers/_defaultServer_/users/test6";
		// String s = sendDelete(deleteUrl, param, username, password, null, null);
		// String s = HttpRequestUtils.sendDelete(deleteUrl, PARAM, USERNAME, PASSWORD,
		// null,"json");
		String s = HttpRequestUtils.sendDelete(deleteUrl, PARAM, USERNAME, PASSWORD, null, null);
		logger.info(s);
	}

	public static void testSendPost() {
		String postUrl2 = "http://192.168.200.117:8087/v2/servers/_defaultServer_/publishers";
		String postJson2 = "{ \"password\": \"1579655633@qq.com\", \"name\": \"test15\", \"serverName\": \"_defaultServer_\", \"description\": \"test\", \"saveFieldList\": [ \"\" ], \"version\": \"v1.0\" }";
		// 返回json
		String s = HttpRequestUtils.sendPost(postUrl2, PARAM, USERNAME, PASSWORD, postJson2, "json");
		// 返回xml
		// String s = HttpRequestUtils.sendPost(postUrl2, PARAM, USERNAME, PASSWORD,
		// postJson2, null);
		logger.info(s);
	}

	public static void testSendPUT() {
		String putUrl = "http://192.168.200.117:8087/v2/servers/_defaultServer_/vhosts/_defaultVHost_/applications/Relay/streamfiles/6D07D7E7623B95889C33DC5901307461_0/actions/connect";
		String putJson = "{ \"vhost\":\"_defaultVHost_\", \"mediaCasterType\":\"liverepeater\" }";
		// String s = HttpRequestUtils.sendPUT(putUrl, PARAM, USERNAME, PASSWORD,
		// putJson, "json");
		String s = HttpRequestUtils.sendPUT(putUrl, PARAM, USERNAME, PASSWORD, putJson, null);
		logger.info(s);
	}

}
