package thread;

public class ThreadLocalDemo {

	private static ThreadLocal<Person> seqNum = new ThreadLocal<Person>(){

		@Override
		protected Person initialValue() {
			Person p = new Person();
			p.setAge(0);
			return p;
		}
		
	};

	public int growUp() {
		Person p = seqNum.get();
		p.setAge(p.getAge() + 1);
		seqNum.set(p);
		return p.getAge();
	}

	public static void main(String[] args) {
		//HashMap
		// 2147483647
		//1111111111111111111111111111111
		//1000000000000000000000000000000
		//111111111111111111111111111111
		//1073741823
		//10000000000000000000000000000000
		Integer intValue = Integer.MIN_VALUE;
		System.out.println((1 << 30)-1);
		System.exit(0);
		ThreadLocalDemo demo = new ThreadLocalDemo();
		for (int i = 0; i < 10; i++) {
			TestClient test = new TestClient(demo);
			test.start();
		}
		//HashMap
		System.out.println(demo.growUp());
	}

}

class Person {
	private Integer age;

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}

class TestClient extends Thread {
	private ThreadLocalDemo sn;

	public TestClient(ThreadLocalDemo sn) {
		this.sn = sn;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			// ④每个线程打出3个序列值
			System.out.println("thread[" + Thread.currentThread().getName() + "] --> sn[" + sn.growUp() + "]");
		}
	}
}