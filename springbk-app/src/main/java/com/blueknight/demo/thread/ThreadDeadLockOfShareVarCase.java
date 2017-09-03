package thread;

import java.sql.SQLException;

public class ThreadDeadLockOfShareVarCase implements Runnable {

	private Boolean flag = false;

	public ThreadDeadLockOfShareVarCase() {
	}

	public ThreadDeadLockOfShareVarCase(boolean flag) {
		this.flag = flag;
	}

	@Override
	public void run() {
		if (flag) {
			System.out.println(Thread.currentThread().getName() + " 改前：" + flag.hashCode());
			synchronized (flag) {
				System.out.println(Thread.currentThread().getName() + " start" + "-- flag:" + flag);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				flag = false;
				System.out.println(Thread.currentThread().getName() + " 改后：" + flag.hashCode());
				synchronized (flag) {
					System.out.println(Thread.currentThread().getName() + " end" + "-- flag:" + flag);
				}
			}
		} else {
			System.out.println(Thread.currentThread().getName() + " 改前：" + flag.hashCode());
			synchronized (flag) {
				System.out.println(Thread.currentThread().getName() + " start" + "-- flag:" + flag);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				flag = true;
				System.out.println(Thread.currentThread().getName() + " 改后：" + flag.hashCode());
				synchronized (flag) {
					System.out.println(Thread.currentThread().getName() + " end" + "-- flag:" + flag);
				}
			}
		}
	}

	public static void main(String[] args) {
		new Thread(new ThreadDeadLockOfShareVarCase(true)).start();
		new Thread(new ThreadDeadLockOfShareVarCase(false)).start();
		
		String a = "a";

		String b = "a";
		System.out.print(a==b);
	}

}