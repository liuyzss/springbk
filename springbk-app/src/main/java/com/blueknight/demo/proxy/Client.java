package proxy;

public class Client {  
	  
	 public static void main(String[] args) {  
	  
	  Subject proxy = DynProxyFactory.getInstance();  
	  proxy.dealTask("DBQueryTask");  
	 }   
	  
}