package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseService;

@RestController
public class MyController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/home")
	public String home() {
		return "this is home page";
	}
	
	//get the courses
	
	@GetMapping("/courses")
	public List<Course> getCourses()
	{
		
		return this.courseService.getCourses();
	}
	
    //single data receive
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		
		return this.courseService.getCourse(Long.parseLong(courseId));
	}
	
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		return this.courseService.addCourse(course);
		
	}
	
	//delete the data
	@DeleteMapping("/courses/{courseId}")
	public void deleteCourse(@PathVariable("courseId") int courseId) {
		
		this.courseService.deleteCourse(courseId);
		
	}
	
	//update data
	@PutMapping("/courses/{courseId}")
	public Course updateCourse(@RequestBody Course course,@PathVariable("courseId") int courseId)
	{
	    this.courseService.updateCourse(course,courseId);	
	    return course;
	}
	
}


