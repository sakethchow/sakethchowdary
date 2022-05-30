package com.sambuddha.day1;
import java.io.Serializable;

import com.sambuddha.exception.AgeNotWithinRangeException;
import com.sambuddha.exception.FieldBlankException;
import com.sambuddha.exception.RollNumberNotWithinRangeException;

public class Student implements Serializable{
	
	private int rollNumber;
	
	private int age;
	
	private String name;
	
	private String address;

	

	public int getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(int rollNumber) throws RollNumberNotWithinRangeException {
		
		if(rollNumber<1 || rollNumber>200)
			throw new RollNumberNotWithinRangeException("Roll Number is not within Range");
		this.rollNumber = rollNumber;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) throws AgeNotWithinRangeException {
		
		if(age<2 || age>40)
			throw new AgeNotWithinRangeException("Age is not within range");
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) throws FieldBlankException {
		
		if(name.length()<1)
			throw new FieldBlankException("Name can't be blank");
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) throws FieldBlankException {
		
		if(address.length()<1)
			throw new FieldBlankException("Address can't be blank");
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [rollNumber=" + rollNumber + ", age=" + age + ", name=" + name + ", address=" + address + "]";
	}
	
	

}