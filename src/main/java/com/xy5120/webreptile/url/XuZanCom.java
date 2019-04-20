package com.xy5120.webreptile.url;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.xy5120.webreptile.util.FileUtils;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import cn.hutool.setting.Setting;

public class XuZanCom {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//String url="https://mati.vsszan.com/";
		//getHtml(url);
		String url="https://www.vsszan.com/t-862.html";
		String downPackage="C:\\Users\\xy\\Desktop\\XuZan";
		action(url,downPackage);
	}
	
	/**
	 * 
	 *  Description:获取请求头信息
	 *  @author xy  DateTime 2019年4月19日 下午11:10:53
	 *  @return
	 */
	private static Map<String,List<String>> getXuZanHeader(){
		String url="config\\header.Setting";
		Map<String, List<String>> map=new HashMap<String, List<String>>();
		List<String> list;
		Setting setting = new Setting(new File(url),CharsetUtil.CHARSET_UTF_8,false);
		Map<String, String> m = setting.getMap("XuZan");
		Set<String> keySet = m.keySet();
		for (String key : keySet) {
			list=new ArrayList<String>();
			list.add(m.get(key));
			map.put(key, list);
		}
		return map;
	}
	
	public static void action(String url,String downPackage) throws IOException {
		String html = getHtml(url);
		List<String> list=queryDom(html);
		downResource(list,downPackage);
	}
	/**
	 * 
	 *  Description:获取网页的内容
	 *  @author xy  DateTime 2019年4月19日 下午11:10:41
	 *  @param url
	 *  @return
	 */
	public static String getHtml(String url) {
		Map<String, List<String>> xuZanHeader = getXuZanHeader();
		return HttpRequest.get(url).header(xuZanHeader).execute().body();
	}
	
	/**
	 * 
	 *  Description:查询要操作的dom
	 *  @author xy  DateTime 2019年4月19日 下午11:12:57
	 *  @param body
	 */
	public static List<String> queryDom(String body) {
		List<String> list=new ArrayList<String>();
		Document doc = Jsoup.parse(body);
		Elements els = doc.getElementsByClass("aimg");
		for (Element e : els) {
			String attr = e.child(0).attr("file");
			int index =-1;
			if((index=attr.indexOf(".jpg"))!=-1) {
				//attr=attr.substring(0, index+1);
			}else if((index=attr.indexOf(".png"))!=-1) {
				//attr=attr.substring(0, index+1);
			}else {
				System.out.println(attr);
				continue;
			}
			attr=attr.substring(0, index+4);
			//System.out.println(attr);
			list.add(attr);
		}
		return list;
	}
	
	public static void downResource(List<String> list,String downPackage) throws IOException {
		File file = new File(downPackage);
		//判断是否为文件
		if(file.isFile()) {
			try {
				throw new Exception("保存地址不是一个文件夹");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//判断文件夹是否存在
		if(!file.exists()) {
			file.mkdirs();
		}
		String path=null;
		for (String url : list) {
			path=downPackage+File.separator+FileUtils.getFileName(url);
			boolean flog = FileUtils.downURLFile(url,path );
			if(flog) {
				System.out.println(path+"下载成功");
			}else {
				System.out.println("---------------失败的文件---------------> url："+url+"。下载本地的路径是："+path);
			}
		}
		
		
		
		
		
		
	}
	
	public static void getHtml2 (String url)  {
		String body = HttpRequest.get(url).execute().body();
		//IoUtil.write(new FileOutputStream(new File("a.txt")), true, body.getBytes());
		Document doc = Jsoup.parse(body);
		//System.out.println(doc);
		Elements els = doc.getElementsByClass("vz-grid");
		System.out.println(els.size());
		for (Element e : els) {
			//System.out.println(e.text());
			String attr = e.attr("href");
			//Console.log(attr);
			String string = HttpUtil.get(attr);
			System.out.println(string);
			break;
		}
	}

}
