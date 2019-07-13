package com.eurekaclient.example.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.eurekaclient.example.model.Student;

public class StudentTable {

	private static Map<String,List<Student>> schools=new HashMap<>();
	
	static {
		List<Student> davstudents=new ArrayList<>();
		
		Student student1=new Student();
		student1.setStudentId(1001);
		student1.setFirstname("Anil");
		student1.setLastname("Kumar");
		
		Student student2=new Student();
		student2.setStudentId(1002);
		student2.setFirstname("Sohan");
		student2.setLastname("Mishra");
		
		Student student3=new Student();
		student3.setStudentId(1003);
		student3.setFirstname("Kuldeep");
		student3.setLastname("Sagwan");
		
		davstudents.add(student1);
		davstudents.add(student2);
		davstudents.add(student3);
		
		schools.put("DAV School", davstudents);
		
		List<Student> sunshinestudents=new ArrayList<>();
		
		Student student11=new Student();
		student11.setStudentId(1001);
		student11.setFirstname("Ankit");
		student11.setLastname("Sharma");
		
		Student student12=new Student();
		student12.setStudentId(1002);
		student12.setFirstname("Babloo");
		student12.setLastname("Mishra");
		
		Student student13=new Student();
		student13.setStudentId(1003);
		student13.setFirstname("Lalit");
		student13.setLastname("Kumar");
		
		sunshinestudents.add(student1);
		sunshinestudents.add(student2);
		sunshinestudents.add(student3);
		
		schools.put("Sunshine School", sunshinestudents);
		
	}
	
	public static Map<String,List<Student>> schoolTable(){
		return schools;
	}
}
