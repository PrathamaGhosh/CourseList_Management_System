package com.example.demo.service;

import java.util.List;

import com.example.demo.binding.Course;

public interface CourseService {
   
	public String upsert(Course course);
	public Course getById(Integer course_id);
	public List<Course> getAllCourses();
	public String deleteById(Integer course_id);
	
}
