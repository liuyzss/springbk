package date.test;

import java.util.List;


/**
 * 泛型测试和重载测试
 * @author liuyang
 *
 */

public class TDemo {
	public int list(List<String> list){
		System.out.println("HELLO STRING");
		return 1;
	}
	public boolean alist(List<Integer> list){
		System.out.println("HELLO Integer");
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String test = "54574_31912772_1";

		String[] arr = test.split("_");
		if (arr.length >= 3) {
			String outTradeNo = arr[0].toString() + "_" + arr[1].toString() + "_" + arr[2].toString();
			System.out.println(outTradeNo);
			
		}
		
		int a = 10;
		Long b = null;
		//b = a;
	}

}
