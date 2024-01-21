package com.example.demo.binding;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data                                // by lombok automatic generation of getter and setter
@Entity                              //to represent the persistance related component
@Table(name="COURSE_DETAILS")
public class Course {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer course_id;
	private String course_name;
	private String course_duration;
	private Double course_price;
	

}
