package com.sambuddha.day1;
import java.io.Serializable;

public class Student implements Serializable{
	
	private int rollNumber;
	
	private int age;
	
	private String name;
	
	private String address;

	public int getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [rollNumber=" + rollNumber + ", age=" + age + ", name=" + name + ", address=" + address + "]";
	}
	
	
	
	
}