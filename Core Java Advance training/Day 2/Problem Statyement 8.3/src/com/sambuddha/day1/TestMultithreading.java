package com.sambuddha.day1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

class Buffer{
	
	private Stack<Integer> listOfNumbers = new Stack<Integer>();
	
	public static boolean flag = false;
	
	public void addInteger(int num) {
		
		this.listOfNumbers.push(num);
	}

	public Stack<Integer> getListOfNumbers() {
		return listOfNumbers;
	}
	
}
public class TestMultithreading {
	
	static void readNumbers(Buffer buffer) {
		
		
		Thread readThread = new Thread()
				{
					    public void run() {
					    	
					    	synchronized (buffer) {
					    	    try {
									Scanner scanner = new Scanner(new File("Number.txt"));
									while(scanner.hasNext()) {
										
										buffer.addInteger(scanner.nextInt());
										buffer.notify();
										buffer.wait();
									}
								} catch (FileNotFoundException | InterruptedException e) {
									e.printStackTrace();
								}
					    	    
						    	Buffer.flag = true;
						    	buffer.notify();
					    	    
							}
					    	
					    	
					    }
			
				};
		
		   readThread.start();
		   
		
	}
	
	static void getFactorial(Buffer buffer) {
		
		  Thread factorialThread = new Thread()
				  {
			         public void run() {
			        	 
			        	 	synchronized (buffer) {
			        	 		
			        	 		 while(true)
			        	 		 {
			        	 			 if(Buffer.flag)
			        	 				 break;
			        	 			 
			        	 			 if(!buffer.getListOfNumbers().isEmpty())
			        	 			 {
			        	 				 int num = buffer.getListOfNumbers().pop();
			        	 				 int fact = 1;
			        	 				 
			        	 				 for(int i=num;i>=1;i--) {
			        	 					 fact*=i;
			        	 				 }
			        	 				 try {
			        	 					 
			        	 					 Thread.sleep(3000);
				        	 				 System.out.println("The factorial of "+num+" is -> "+fact);

			        	 					 buffer.notify();
											buffer.wait();
										} catch (InterruptedException e) {
											e.printStackTrace();
										}
			        	 				 
			        	 			 }
			        	 			 else {
			        	 				 try {
											buffer.wait();
										} catch (InterruptedException e) {
											e.printStackTrace();
										}
			        	 			 }
			        	 		 }
								
							}
			        	 
			        	
			        }
				};
				  
				  factorialThread.start();
		
		}
    
	public static void main(String[] args) throws FileNotFoundException {
		
		Buffer buffer = new Buffer();
		
		getFactorial(buffer);

		readNumbers(buffer);
		
		

	}

}
