package com.bruce.design.strategy;

/**
 * 策略：它定义了算法家庭，分别封装起来。让它们之间可以互相替换，此模式让算法的变化，不会影响到使用算法的客户。
 */

public class Test {

	public static void main(String[] args) throws Exception {
        QueryUtil query = new QueryUtil();
		query.findUserInfo(new String[] { "Tom", "Jim", "Anna" }, new Strategy1());
		query.findUserInfo(new String[] { "Jac", "Joe", "Rose" }, new Strategy2());
	}

}
