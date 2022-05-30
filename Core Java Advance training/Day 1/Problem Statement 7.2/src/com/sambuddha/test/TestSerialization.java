package com.sambuddha.test;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import com.sambuddha.exception.AgeNotWithinRangeException;
import com.sambuddha.exception.FieldBlankException;
import com.sambuddha.exception.RollNumberNotWithinRangeException;
import com.sambuddha.day1.Student;

public class TestSerialization {

	public static void main(String[] args) {
		
		Scanner scannerObj = new Scanner(System.in);
		
		System.out.print("Enter Roll No : ");
		int roll = scannerObj.nextInt();
		
		System.out.print("Enter Age : ");
		int age = scannerObj.nextInt();
		
		scannerObj.nextLine();
		
		System.out.print("Enter Name : ");
		String name = scannerObj.nextLine();
		
		System.out.print("Enter Address : ");
		String address = scannerObj.nextLine();
		
		
		try {
			Student s1 = new Student();

			s1.setRollNumber(roll);
			s1.setAge(age);
			s1.setName(name);
			s1.setAddress(address);
			
			System.out.print("Do You want to save data to the file ? Y/N : ");
			
			char ch = scannerObj.nextLine().toLowerCase().charAt(0);
			
			if(ch == 'y') {
			
					FileOutputStream fis = new FileOutputStream("Data.ser");
					
					ObjectOutputStream oos = new ObjectOutputStream(fis);
					
					oos.writeObject(s1);
					
					fis.close();
					oos.close();
					scannerObj.close();
					
					System.out.println("Student is successfully serialized");
			}
			else {
				System.out.println("***Thank You*****");
			}
			
			
			
		} catch (RollNumberNotWithinRangeException | AgeNotWithinRangeException | FieldBlankException | IOException e) {
			e.printStackTrace();
		}
		

	}

}
