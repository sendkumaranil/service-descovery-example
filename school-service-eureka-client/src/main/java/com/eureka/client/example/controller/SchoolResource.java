package com.eureka.client.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class SchoolResource {

	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/{schoolname}/students")
	public String getStudents(@PathVariable("schoolname") String schoolName) throws Exception {
		String url="http://student-service/students/{schoolname}";
		String response=null;
		try {
			HttpStatus statusCode=restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<String>() {},schoolName).getStatusCode();
			if(statusCode==HttpStatus.OK) {
				response=restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<String>() {},schoolName).getBody();
			}else if(statusCode==HttpStatus.NOT_FOUND) {
				throw new ResourceNotFoundException("School Name Not Found:"+schoolName);
			}
			
		}catch(Exception exp) {
			throw new Exception(exp.getMessage());
		}
		
		return response;
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
