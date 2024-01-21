package com.example.demo.service;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.binding.Course;
import com.example.demo.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {
    
	
	@Autowired
	private CourseRepository courseRepo;
	
	
	
	@Override
	public String upsert(Course course) {
		// TODO Auto-generated method stub
		courseRepo.save(course);  //update new course list if course pass by it's id/id not pass it will insert the course
		return "success";
	}

	@Override
	public Course getById(Integer course_id) {
		// TODO Auto-generated method stub
		
		Optional<Course> findById=courseRepo.findById(course_id);
	    if(findById.isPresent()) {
	    	return findById.get();
	    }
	    
		return null;
	}

	@Override
	public List<Course> getAllCourses() {
		// TODO Auto-generated method stub
		return courseRepo.findAll();
	}

	@Override
	public String deleteById(Integer course_id) {
		// TODO Auto-generated method stub
		if(courseRepo.existsById(course_id)) {
			courseRepo.deleteById(course_id);
			return "Deleted successfully...";
		}
		else {
			return "Sorry no record found...";
		}
		//return null;
	}

}
