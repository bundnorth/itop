package cm.bund.north.test.jdk;

/**
 * @author hugo0129
 */
public class ThreadTest {
	public static void main(String[] args) {
		int count = 0;
		for (int i = 0; i < 5000; i++) {
			count += 1;
		}
		System.out.println("count:" + count);
		System.out.println("I am a main method");
	}

}
