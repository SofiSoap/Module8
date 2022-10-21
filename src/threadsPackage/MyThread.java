package threadsPackage;

public class MyThread extends Thread {
	
	private int[] numbers;
	private int endValue;
	
	public MyThread (int[] numbers) {
		this.numbers = numbers;
	}
	
	/**
	 * @Override
	 */
	public void run() {
		
//		printing out numbers to check if threads are running at same time		
//		for(int i = 0; i<100; i++) {
//			System.out.println(i);
//		}
//		
		
		int sum = 0;
		
		 for(int value: numbers) {
			 sum = sum +value;
		 }
		endValue = sum;
		//Thread.sleep(1000);
		
	}

	public int returnValue() {
		return endValue;
	}
	
	
}
