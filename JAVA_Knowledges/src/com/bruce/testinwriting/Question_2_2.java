package com.bruce.testinwriting;

import java.io.File;
import java.util.Arrays;

public class Question_2_2 {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		// 递归显示C盘下所有文件夹及其中文件
		File root = new File(System.getProperty("user.dir"));
		showAllFiles(root);
	}

	final static void showAllFiles(File dir) throws Exception {
		File[] fs = dir.listFiles();
		for (int i = 0; i < fs.length; i++) {
			System.out.println(fs[i].getAbsolutePath());
			if (fs[i].isDirectory()) {
				try {
					showAllFiles(fs[i]);
				} catch (Exception e) {
				}
			}
		}
	}
}
