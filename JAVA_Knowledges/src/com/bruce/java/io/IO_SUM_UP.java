package com.bruce.java.io;

import java.io.File;
import java.io.IOException;

public class IO_SUM_UP {

	static String separator = File.separator;  //在windows下是“\”，而在Linux下是“/”,为了跨平台性，请使用这个
	public static void main(String[] args) {
		
		//测试createFile()
//		String parent = "qizhenghao" + separator + "ducuments";
//		String chile = "1.txt";
//		createFile(chile);
//		createFile(parent, chile);
		
		//测试delFile()
//		delFile(chile);
//		delFile(parent, chile);
		
		
		
	}
	
	public static boolean isDirectory(String path) {
		File file = new File(path);
		if (!file.isDirectory()) {
			return false;
		}
		return true;
	}
	
	/**
	 * 对比file.list() 和 file.listFiles()
	 * @param path 路径
	 * @author qizhenghao
	 */
	public static void listVsListFiles(String path) {
		File file = new File(path);
		String[] list = file.list(); //只包含文件名
		File[] listFile = file.listFiles();//包含的是文件
	}
	
	/**
	 * 在当前目录下删除一个文件
	 * @param name 文件名
	 * @author qizhenghao
	 */
	public static void delFile(String name) {
		File file = new File(name);
		if (file.exists()) {
			file.delete();
		} else {
			System.out.println(name + " not exists");
		}
	}

	/**
	 * 在指定目录下删除一个文件
	 * @param parent 指定目录
	 * @param chile  文件名
	 * @author qizhenghao
	 */
	public static void delFile(String parent, String child) {
		File file = new File(parent, child);
		if (file.exists()) {
			file.delete();
		} else {
			System.out.println(child + " not exists");
		}
	}

	
	/**
	 * 在当前目录下创建一个文件
	 * @param name 文件名
	 * @author qizhenghao
	 */
	public static void createFile(String name) {
		File file = new File(name);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


	/**
	 * 在指定目录下创建一个文件
	 * @param parent 指定目录
	 * @param chile  文件名
	 * @author qizhenghao
	 */
	public static void createFile(String parent, String child) {
		File file = new File(parent, child);
		if (!file.exists()) {
			file.getParentFile().mkdirs();
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
