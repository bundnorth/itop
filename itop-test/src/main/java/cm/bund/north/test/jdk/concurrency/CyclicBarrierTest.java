package cm.bund.north.test.jdk.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
	private static final int SIZE = 5;

	public static void main(String[] args) {
		CyclicBarrier cb = new CyclicBarrier(SIZE, new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + ":" + "all sub thread end");
			}

		}
		);
		for (int i = 0; i < SIZE; i++) {
			new Thread(new SubThread(cb)).start();

		}
	}

	static class SubThread implements Runnable {
		// 栅栏对象
		private CyclicBarrier cb;

		public SubThread(CyclicBarrier cb) {
			this.cb = cb;
		}

		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName() + ":sub thread starting running");
			try {
				cb.await();
				System.out.println(Thread.currentThread().getName() + ":" + " all sub thread start doing other things");
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}
		}
	}
}
