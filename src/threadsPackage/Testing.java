package threadsPackage;
import  java.util.Arrays ;
import java.util.*;

public class Testing {

	
	public static void main(String[] args) {
		
		int arraySize = 200000000;
		
		int array1[] =  new int[arraySize];
		int totalSum1 = 0;
		int totalSum2 = 0;
		Random rn = new Random();
		
		//Random Numbers into int array
		for(int i = 0; i<array1.length; i++) {
			int value =rn.nextInt(10) + 1;
			array1[i] = value;
//			System.out.println("Value of arrary [" + i+"] is " +value);
		}
		
		MyThread thread1 = new MyThread(Arrays.copyOfRange(array1, 0, 40000000));
		MyThread thread2 = new MyThread(Arrays.copyOfRange(array1, 40000000, 80000000));
		MyThread thread3 = new MyThread(Arrays.copyOfRange(array1, 80000000, 120000000));
		MyThread thread4 = new MyThread(Arrays.copyOfRange(array1, 120000000, 160000000));
		MyThread thread5 = new MyThread(Arrays.copyOfRange(array1, 160000000, 200000000));

		long startTime1 = System.nanoTime(); //Find start Time of multiThread, startTime 1
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
		boolean allDead = false;
		long endTime1 = 0;
		
		while(allDead == false) {
			if( thread1.isAlive() == false && thread2.isAlive() == false && thread3.isAlive() == false && thread4.isAlive() == false && thread5.isAlive() == false) {
				allDead = true;
				endTime1 = System.nanoTime(); //Find end time of multithread, endTime1
			}
		}
		
		//check that thread are dead, before finding return value 
//		System.out.println(thread1.isAlive());
//		System.out.println(thread4.isAlive());
		totalSum1 = thread1.returnValue() + thread2.returnValue() + thread3.returnValue() +thread4.returnValue() +thread5.returnValue();;
		
	
	
		//Adding sum by Single Thread ***************************************************************************************************
		
		MyThread singleThread = new MyThread(array1);
		long startTime2 = System.nanoTime(); //Find start Time of singleThread, startTime2
		singleThread.start();
		
		try {
			singleThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long endTime2 = System.nanoTime(); //End Time of singleThread, startTime2
		totalSum2 = singleThread.returnValue();
		
		
		
		//Printing ****************************************************************************************
		System.out.println("The arraySize is: " +arraySize);
		
		long totalTime1 = endTime1 - startTime1; //Calc Total Time, multi thread
		System.out.println("By Multi Thread- \tTotal Sum: " +totalSum1 +"\tTotal Time: " + totalTime1);
		
		long totalTime2 = endTime2 - startTime2; //Calc Total Time, single thread
		System.out.println("By Single Thread- \tTotal Sum: " +totalSum2 +"\tTotal Time: " + totalTime2);
		
	}
}
