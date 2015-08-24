package com.bruce.testinwriting;

public class PadChar {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String orgin = "2014";
		
		System.out.println(padChar("2014", 3, '0'));
		System.out.println(padChar("2014", 8, '0'));
		System.out.println(padChar("2014", 0, '0'));
		System.out.println(padChar("", 4, '0'));
	}

	private static String padChar(String string, int minLength, char pad) {

		if(null==string) {
			return null;
		}
        StringBuilder builder = new StringBuilder("");
		for (int i = 0; i < minLength-string.length(); i++) {
			builder.append(pad);
		}
		
		return builder.append(string).toString();
	}

}
