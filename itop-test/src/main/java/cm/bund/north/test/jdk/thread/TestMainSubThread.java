package cm.bund.north.test.jdk.thread;

/**
 * @author yougui.xiong
 * @description 主线程比子线程先执行完
 */
public class TestMainSubThread {
	public static void main(String[] args) {
		System.out.println("This is main Thread start:" + Thread.currentThread().getName());
		SubThread subThread = new SubThread();
		subThread.run();
		System.out.println("This is main Thread end:" + Thread.currentThread().getName());

	}
}

class SubThread {
	public void run() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("This is sub Thread:" + Thread.currentThread().getName());
	}
}
