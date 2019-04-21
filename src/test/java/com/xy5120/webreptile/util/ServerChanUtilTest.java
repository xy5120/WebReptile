package com.xy5120.webreptile.util;

import org.junit.Test;

public class ServerChanUtilTest {

	@Test
	public static void sendTest() {
		String send = ServerChanUtil.send("我是标题", "我是测试内容");
		System.out.println(send);
	}
}
