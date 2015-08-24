package com.bruce.testinwriting;

import java.util.Arrays;

public class AnalysisOrders {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String orders = "-name qi   age 22  school \"si chuan da xue\"";
		System.out.println(analysisOrders(orders));
		String orders1 = "   -name \"qi\"   age 22  school \"si chuan da xue\"";
		System.out.println(analysisOrders(orders));
	}

	private static String analysisOrders(String orders) {
		String result = "";
		int index = 0;
		for (int i = 0; i < orders.length(); i++) {
			String temp = orders.charAt(i) + "";
			if (orders.charAt(i) == '\"') {
				for (i++; i < orders.length(); i++) {
					temp += orders.charAt(i);
					if (orders.charAt(i) == '\"') {
						break;
					}
				}
			} else if (orders.charAt(i) == ' ') {
				for (i++; i < orders.length(); i++) {
					if (orders.charAt(i) != ' ') {
						i--;
						index++;
						if (index % 2 == 0) {
							temp = temp + ", ";
						} else {
							temp = temp + " ";
						}
						break;
					}
				}
			}
			result += temp;
		}
		return "[" + result + "]";

		// // TODO Auto-generated method stub
		// String[] arrStr = orders.split(" ");
		// int numBlank = 0;
		// for (int i = 0; i < arrStr.length; i++) {
		// if(" ".equals(arrStr[i])) {
		// numBlank++;
		// }
		// }
		// String[] results = new String[(arrStr.length-numBlank)/2-1];
		// int index = 0;
		// String temp = "";
		// for (int i = 0; i < arrStr.length; i++) {
		// if (!"".equals(arrStr[i])) {
		// index++;
		// temp = temp + " " + arrStr[i];
		// }
		// if (index%2==0 && index>0 && !"".equals(temp)) {
		// results[index/2-1] = temp.substring(1,temp.length());
		// temp = "";
		// }
		// }
		//
		// for (int i = 0; i < results.length; i++) {
		// int k = i;
		// if(results[i].contains("\"")) {
		// int num = 0;
		// for (int j = 0; j < results[i].length(); j++) {
		// if(results[i].charAt(j) == '\"') {
		// num++;
		// }
		// }
		// if(num==1) {
		// for (i++;results[i] !=null && i < results.length; i++) {
		// results[k] += results[i];
		// if(results[i].contains("\"")) {
		// results[i] = null;
		// break;
		// }
		// results[i] = null;
		// }
		// }
		//
		// }
		// }
		// String s = Arrays.toString(results);
		// s.replaceAll(", null", "");
		//
		// return s;
	}

}
