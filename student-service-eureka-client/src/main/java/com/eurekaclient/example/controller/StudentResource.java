package com.eurekaclient.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.eurekaclient.example.db.StudentTable;
import com.eurekaclient.example.exception.ResourceNotFoundException;
import com.eurekaclient.example.model.Student;

@RestController
public class StudentResource {

	@GetMapping("/students/{schoolname}")
	public List<Student> getStudentBySchoolName(@PathVariable("schoolname") String schoolName) throws ResourceNotFoundException{
		List<Student> students=StudentTable.schoolTable().get(schoolName);
		if(students==null) {
			throw new ResourceNotFoundException("Student Not Found for the school:"+schoolName);
		}
		return StudentTable.schoolTable().get(schoolName);
	}
}
