package date.test;

public class FinallyTest {
	public static int a  = 0; 
	public static Integer foo(A ac) {  
		int b = 0;
		String str = "1";
		A bc = new A();
	    try {  
	        System.out.println("try");  
	        a =2;
	        b=2;
	        str = "2";
	        ac.setName("liuy");
	        bc.setName("ll");
	        System.out.println("finsssssssally"); 
	        return b;
	       
	    } catch (Throwable e) {  
	        System.out.println("catch");  
	    } finally { 
	    	 a = 3;
	    	 b =3;
	    	 str = "3";
	    	 ac.setName("liuyang");
	    	 bc.setName("bb");
	        System.out.println("finally");  
	    }
		return b;  
	}  
	public static void main(String[] args) {
		A ac = new A();
		int resss = FinallyTest.foo(ac);
		System.out.println(resss+"@@@@@");
		System.out.println(FinallyTest.a);
		
		System.out.println(ac.getName());
		String s1 = "ddd";
		String re = FinallyStrTest.foo(s1);
		System.out.println(re);
		System.out.println(s1);
		
		
		
		String s2 = "ddd111";
		String re2 = FinallyStrTest.footest(s2);
		System.out.println(re2);
		System.out.println(s2);
		
		for(int i =0;i<10;i++){
			int test = 0;
		}
		
		// 无法访问 for循环内部变量test
		//System.out.println(test);
	}
}

class A{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}

class FinallyStrTest {
	public static String foo(String s1) {  
	    try {  
	    	s1 = "ll";
	        return s1;
	       
	    } catch (Throwable e) {  
	        System.out.println("catch");  
	    } finally { 
	    	s1 = "222";
	        System.out.println("finally");  
	    }
		return s1;  
	}  
	
	public static String footest(String s1) {  
	    s1 = "$$$$";
		return s1;  
	}
}
