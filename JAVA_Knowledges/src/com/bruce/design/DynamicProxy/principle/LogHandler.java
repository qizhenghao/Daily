package com.bruce.design.DynamicProxy.principle;

import java.lang.reflect.Method;

public class LogHandler implements InvocationHandler{

	private Object target;



	public LogHandler(Object target) {
		super();
		this.target = target;
	}



	@Override
	public void invoke(Object o, Method m) {
		System.out.println("我是一个log");
		System.out.println(o.getClass().getName());

		try {
			m.invoke(target);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("我也是一个log");
	}

}
