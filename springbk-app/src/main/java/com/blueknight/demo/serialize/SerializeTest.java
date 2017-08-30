package serialize;

public class SerializeTest {
	public static void main(String[] args) throws InterruptedException {
		Person person = new Person(100, "alan");
		byte[] bytes = SerializeUtil.serialize(person);
		System.out.println(bytes);
		String str = new String(bytes);
		byte[] temB = str.getBytes();
		System.out.println(bytes);
		System.out.println(temB);
	}
}
