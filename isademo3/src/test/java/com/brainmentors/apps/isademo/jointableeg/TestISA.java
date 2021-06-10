package com.brainmentors.apps.isademo.jointableeg;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestISA {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		Employee emp = new Employee(99999, "Brain Mentors", "Ram","Delhi");
//		Student stud = new Student(1111, "Java", "Shyam", "Mumbai");
//		Person person = new Person("Sohan","Delhi");
//		DAO.save(person, emp, stud);	
		String path = "/Users/amit/Downloads/nodejsreactmcq.rtf"; 
		File file = new File(path);
		if(!file.exists()) {
			System.out.println("File not exist");
			return ;
		}
		System.out.println("Read Start");
		FileInputStream fs = new FileInputStream(file);
		byte b[] = fs.readAllBytes();
//		BufferedInputStream bi = new BufferedInputStream(fs);
//		int singleByte = bi.read();
//		final int EOF = -1;
//		List<Byte> bytes = new ArrayList<>();
//		while(singleByte!=EOF) {
//			bytes.add((byte)singleByte);
//			singleByte = bi.read();
//			
//		}
//		bi.close();
		fs.close();
//		System.out.println("File Read Done....");
//		Byte b[] = new Byte[bytes.size()];
//		int index = 0;
//		for(byte c : bytes) {
//			b[index] = c;
//			index++;
//		}
		System.out.println("Read Ends and Filled Up the Array");
		LargeObjects largeObjects = new LargeObjects();
		largeObjects.setDocBytes(b);
		largeObjects.setName("AAAA");
		DAO.saveLOB(largeObjects);

	}

}
