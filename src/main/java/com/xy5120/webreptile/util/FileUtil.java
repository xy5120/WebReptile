package com.xy5120.webreptile.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class FileUtil {
	
	
	//字节数组容量
	private static final int BYTE_SIZE=1024*1024;
	
	/**
	 * 
	 *  Description:根据路径取出文件名，文件名不能包含/\符号
	 *  @author xy  DateTime 2018-12-6 下午11:25:06
	 *  @param path
	 *  @return
	 */
	public static String getFileName(String str){
		String fileName=null;
		int lastIndexOf=-1;
		if(str.startsWith("http")) {
			//url
			lastIndexOf = str.lastIndexOf("/");
			fileName=str.substring(lastIndexOf+1);
		}else {
			//文件路径
			if((lastIndexOf=str.lastIndexOf("/"))!=-1){
			}else if((lastIndexOf=str.lastIndexOf("\\"))!=-1) {
			}else {
				return null;
			}
		}
		fileName=str.substring(lastIndexOf+1);
		return fileName;
	}
	
	
	/**
	 * 创建一个文件夹
	 * 如果存在       不创建 
	 * 如果不存在    创建
	 * @param filePath
	 * @return
	 */
	public static boolean makeDirs(String filePath) {
        File folder = new File(filePath);
        return (folder.exists() && folder.isDirectory()) ? true : folder.mkdirs();
    }
	/**
	 * 
	 *  Description:网页链接下载
	 *  @author xy  DateTime 2018-12-6 下午10:35:52
	 *  @param url
	 *  @param path
	 *  @return
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws MalformedURLException 
	 */
	public static boolean downURLFile(String url,String path) throws IOException{
		return copy(new URL(url).openStream(),new FileOutputStream(new File(path)));
		
	}
	
	/**
	 * 
	 *  Description:复制文件抽取
	 *  @author xy  DateTime 2018-12-6 下午10:44:37
	 *  @param input
	 *  @param output
	 *  @return
	 */
	private static boolean copy(InputStream input,OutputStream output){
		BufferedInputStream bfi=null;
		BufferedOutputStream bfo=null;
		try {
			 bfi = new BufferedInputStream(input) ;
			bfo = new BufferedOutputStream(output);
			byte[] b =new  byte[BYTE_SIZE];
			int len=0;
			while((len=bfi.read(b))!=-1){
				bfo.write(b,0, len);
			}
			bfo.flush();
			return true;
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}finally{
			try {
				if(bfi!=null){
					bfi.close();
				}
				if(bfo!=null){
					bfo.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
  	 * 
  	 *  Description:拷贝文件
  	 *  @author xy  DateTime 2018-12-6 下午07:28:09
  	 *  @param in
  	 *  @param out
  	 *  @return
  	 *  @throws Exception
  	 */
    public static final boolean CopyFile(File in, File out) throws Exception {
    	return copy(new FileInputStream(in),new FileOutputStream(out));
        
    	
    	
    	
    }
	
	/**
     * 删除单个文件
     * 路径 是全路径
     * c盘啥啥的全路径
     * @param fileName  要删除的文件的文件名
     * @return 单个文件删除成功返回true，否则返回false
     */
    public static boolean deleteFile(String fileName) {
        File file = new File(fileName);
        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                return true;
            } else {
                //System.out.println("删除单个文件" + fileName + "失败！");
                return false;
            }
        } else {
            //System.out.println("删除单个文件失败：" + fileName + "不存在！");
            return false;
        }
    }
    
    /**
     * 得到文件的类型。
     * 实际上就是得到文件名中最后一个“.”后面的部分。
     * @param fileName 文件名
     * @return 文件名中的类型部分
     * @since  1.0
     */
    public static String getTypePart(String fileName) {
      int point = fileName.lastIndexOf('.');
      int length = fileName.length();
      if (point == -1 || point == length - 1) {
        return "";
      }
      else {
        return fileName.substring(point + 1, length);
      }
    }

    /**
     * 得到文件的类型。
     * 实际上就是得到文件名中最后一个“.”后面的部分。
     * @param file 文件
     * @return 文件名中的类型部分
     * @since  1.0
     */
    public static String getFileType(File file) {
      return getTypePart(file.getName());
    }
    
  	
    /**
     * 将文件名中的类型部分去掉。
     * @param filename 文件名
     * @return 去掉类型部分的结果
     * @since  1.0
     */
    public static String trimType(String filename) {
      int index = filename.lastIndexOf(".");
      if (index != -1) {
        return filename.substring(0, index);
      }
      else {
        return filename;
      }
    }
    
    
}
