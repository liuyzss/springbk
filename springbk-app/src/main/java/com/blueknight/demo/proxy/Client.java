package com.blueknight.demo.proxy;

import com.blueknight.demo.proxy.DynProxyFactory;
import com.blueknight.demo.proxy.Subject;

public class Client {
	  
	 public static void main(String[] args) {  
	  
	  Subject proxy = DynProxyFactory.getInstance();
	  proxy.dealTask("DBQueryTask");
	 }   
	  
}