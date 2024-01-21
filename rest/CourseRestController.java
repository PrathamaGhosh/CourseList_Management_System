package com.example.demo.rest;

//import org.hibernate.mapping.List;
//import org.hibernate.mapping.List;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.ModelAndView;

import com.example.demo.binding.Course;
import com.example.demo.service.CourseService;

@RestController
public class CourseRestController {
	
	@Autowired
	private CourseService courseService; // IOC container will find the implementation class for  service layer
	
	 
	
	
	@PostMapping("/course")
	public ResponseEntity<String> createCourse(@RequestBody Course course){  //in request body json data will come from postman and converted into java object
		 String status=courseService.upsert(course);
		 return new ResponseEntity<>(status, HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/course/{course_id}")
	public ResponseEntity<Course> getCourse(@PathVariable Integer course_id){
		Course course=courseService.getById(course_id);
		return new ResponseEntity<>(course, HttpStatus.OK);
	}
	
	
	@GetMapping("/courses")
	public ResponseEntity<List<Course>> getAllCourses(){
		List<Course> allCourses=courseService.getAllCourses();
		return new ResponseEntity<>(allCourses, HttpStatus.OK);
	}
	
	@PutMapping("/course")
	public ResponseEntity<String> updateCourse(@RequestBody Course course){   
		 String status=courseService.upsert(course);
		 return new ResponseEntity<>(status, HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/course/{course_id}")
	public ResponseEntity<String> deleteCourse(@PathVariable Integer course_id){
		 String status=courseService.deleteById(course_id);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}
	
	

}
