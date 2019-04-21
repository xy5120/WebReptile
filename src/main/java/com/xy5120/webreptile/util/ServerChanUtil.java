package com.xy5120.webreptile.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLConnection;

public class ServerChanUtil {

	
	private static final String SCKEY = "SCU47799T555877fd11e7283129a1eb7fc33587895ca43f1183de2";
	private static final String URL = "http://sc.ftqq.com/" + SCKEY + ".send";

	
	/**
	 * 
	 *  Description:
	 *  @author xy  DateTime 2019年4月20日 下午7:58:03
	 *  @param title 消息标题，最长为256
	 *  @param msg	消息内容，最长64Kb，可空
	 *  @return JSON字串
	 */
	public static String send(String title, String msg) {
		String result = "";
		BufferedReader in = null;
		try {
			java.net.URL url = new java.net.URL(URL + "?text=" + title + "&desp=" + msg);
			URLConnection conn = url.openConnection();
			conn.connect();
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("发送GET请求出现异常！" + e);
			e.printStackTrace();
			
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;
	}

}
