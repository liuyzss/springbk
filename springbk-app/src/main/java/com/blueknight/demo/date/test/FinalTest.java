package date.test;

public class FinalTest {
	public static void main(String[] args) {
		final StringBuffer sb = new StringBuffer("HelloWorld");  
		//sb = new StringBuffer("Hello"); // 编译失败，不能修改sb引用的指向  
		sb.append("China"); // sb指向的对象可以被修改。 
		
		System.out.println(sb);
		
		final int a = 1;
		//a=2;
	}
}
