package com.bruce.testinwriting;

public class HouXuBianLi {

	/**
	 * @param args
	 */
	
	private static String last = "";
	public static void main(String[] args) {

		String pre = "ABDECFG";
		String mid = "DBEAFCG";
	    for (int i = 0; i < args.length; i++) {
			
		}
		
	    last = getLast(pre,mid);
	    System.out.println(last);
	}

	private static String getLast(String pre, String mid) {
		Node node = new Node();
		int length = pre.length();
		int index=0;
		for (int i = 0; i < length; i++) {
			if(mid.charAt(i) == pre.charAt(0)) {
				index = i;
				break;
			}
		}
		if (index>0) {
			getLast(pre.substring(1,index+1), mid.substring(0,index));
		}
		if (index <mid.length()-1) {
			getLast(pre.substring(index+1,length), mid.substring(index+1,length));
		}
		
		return last +=mid.charAt(0);
	}
	
	static class Node {
		char id;
		Node letf;
		Node right;
	}

}

