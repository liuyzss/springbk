package com.blueknight.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class DynProxyFactory {
	// 客户类调用此工厂方法获得代理对象。
	// 对客户类来说，其并不知道返回的是代理类对象还是委托类对象。
	public static Subject getInstance() {
		Class onwClass = null;
		Object o = null;
		try {
			onwClass = Class.forName("proxy.RealSubject");
			o = onwClass.newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Subject delegate = new RealSubject();
		InvocationHandler handler = new SubjectInvocationHandler(o);
		Subject proxy = null;
		proxy = (Subject) Proxy.newProxyInstance(onwClass.getClassLoader(), onwClass.getInterfaces(), handler);
		
		return proxy;
	}
}
