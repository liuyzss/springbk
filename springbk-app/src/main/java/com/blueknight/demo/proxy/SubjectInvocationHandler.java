package com.blueknight.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理类对应的调用处理程序类
 */
// aopproxy
public class SubjectInvocationHandler implements InvocationHandler {

	// 代理类持有一个委托类的对象引用
	private Object delegate;

	public SubjectInvocationHandler(Object delegate) {
		this.delegate = delegate;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		long stime = System.currentTimeMillis();
		// chain = getIntercepter
		// 利用反射机制将请求分派给委托类处理。Method的invoke返回Object对象作为方法执行结果。
		// 因为示例程序没有返回值，所以这里忽略了返回值处理
		//for(chain:chains){
		//chain.before();
		
		
		//}
		method.invoke(delegate, args);
		
		//for(chain:chains){
			//chain.after();	
	    //}
		
		long ftime = System.currentTimeMillis();
		System.out.println("执行任务耗时" + (ftime - stime) + "毫秒");
		return null;
	}

}