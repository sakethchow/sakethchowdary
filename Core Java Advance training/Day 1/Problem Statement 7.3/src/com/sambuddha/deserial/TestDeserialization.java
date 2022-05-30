package com.sambuddha.deserial;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class TestDeserialization {

	public static void main(String[] args) {
		
		try {
			FileInputStream fis = new FileInputStream("Data.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			Object obj = ois.readObject();
			
			System.out.println(obj);
			
			fis.close();
			ois.close();
			
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		

	}

}