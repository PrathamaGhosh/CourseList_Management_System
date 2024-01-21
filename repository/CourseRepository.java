package com.example.demo.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Repository;

import com.example.demo.binding.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course,Serializable> {

}
