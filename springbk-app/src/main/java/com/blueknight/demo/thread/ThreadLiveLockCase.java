package thread;
public class ThreadLiveLockCase {
	public synchronized void a() {
		System.out.println("a");
	}

	public synchronized void b() {
		System.out.println("b");
	}

	public static void main(String[] args) {
		final ThreadLiveLockCase lcc = new ThreadLiveLockCase();
		new Thread(new Runnable() {
			public void run() {
				System.out.println(Thread.currentThread().getName());
				lcc.a();
				lcc.b();
			}
		}).start();
		new Thread(new Runnable() {
			public void run() {
				System.out.println(Thread.currentThread().getName());
				lcc.b();
				lcc.a();
			}
		}).start();
	}
}
