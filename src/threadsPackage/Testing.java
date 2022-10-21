package threadsPackage;
import  java.util.Arrays ;

public class Testing {

	
	public static void main(String[] args) {
		
		int[] array1 = {2,2,
				2,2,
				2,2,
				2,2,
				2,2,
				2,2,
				2,2,
				2,2,
				2,2,
				2,2};
		int totalSum = 0;
		
		MyThread thread1 = new MyThread(Arrays.copyOfRange(array1, 0, 5));
		MyThread thread2 = new MyThread(Arrays.copyOfRange(array1, 5, 10));
		MyThread thread3 = new MyThread(Arrays.copyOfRange(array1, 10, 15));
		MyThread thread4 = new MyThread(Arrays.copyOfRange(array1, 15, 20));

		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		
//		try {
//			thread1.join();
//			thread2.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		
		boolean allDead = false;
		
		while(allDead == false) {
			if( thread1.isAlive() == false && thread2.isAlive() == false && thread3.isAlive() == false && thread4.isAlive() == false) {
				allDead = true;
			}
		}
		
		System.out.println(thread1.isAlive());
		
		totalSum = thread1.returnValue() + thread2.returnValue() + thread3.returnValue() +thread4.returnValue();;
		
		System.out.println("Total Sum: " +totalSum);

	}
}
