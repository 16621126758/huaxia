
package cn.com.chnsys.ThreadSafe;

class ThreadTrain2 implements Runnable {
	private static int count = 100;
	public boolean flag = true;
	private static Object oj = new Object();

	@Override
	public void run() {
		if (flag) {

			while (count > 0) {

				synchronized (ThreadTrain2.class) {
					if (count > 0) {
						try {
							Thread.sleep(50);
						} catch (Exception e) {
							// TODO: handle exception
						}
						System.out.println(Thread.currentThread().getName() + ",���۵�" + (100 - count + 1) + "Ʊ");
						count--;
					}
				}

			}

		} else {
			while (count > 0) {
				sale();
			}
		}

	}

	public static synchronized void sale() {

		// ǰ�� ���߳̽���ʹ�á�����߳�ֻ���õ�һ������
		// ��ֻ֤����һ���߳� ��ִ�� ȱ��Ч�ʽ���
		// synchronized (oj) {
		if (count > 0) {
			try {
				Thread.sleep(50);
			} catch (Exception e) {
				// TODO: handle exception
			}
			System.out.println(Thread.currentThread().getName() + ",���۵�" + (100 - count + 1) + "Ʊ");
			count--;
		}
		// }
	}
}

public class ThreadDemo2 {
	public static void main(String[] args) throws InterruptedException {
		ThreadTrain2 threadTrain1 = new ThreadTrain2();
		Thread t1 = new Thread(threadTrain1, "�ٺŴ���");
		Thread t2 = new Thread(threadTrain1, "�ںŴ���");
		t1.start();
		Thread.sleep(40);
		threadTrain1.flag = false;
		t2.start();
	}
}
