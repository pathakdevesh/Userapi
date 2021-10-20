package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.springrest.springrest.entities.Course;

@Service
public class CourseServiceimpl implements CourseService {

	
	List<Course> list;
	
	public CourseServiceimpl() {
		
		list=new ArrayList<>();
		list.add(new Course(145,"Java Core Course","this course contains basics of java"));
		list.add(new Course(4343,"spring boot","creating api using springboot"));
		
	}
	
	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public Course getCourse(long courseId) {
		
		Course c=null;
		for(Course course:list)
		{
			if(course.getId()==courseId)
			{
				c=course;
				break;
			}
		}
		
		
		return c;
	}

	@Override
	public Course addCourse(Course course) {
		
		list.add(course);
		return course;
	}

	@Override
	public void deleteCourse(int cid) {
		// TODO Auto-generated method stub
		list=list.stream().filter(course->{
			if(course.getId()!=cid) {
				return true;
			}
			else {
				return false;
			}
		}).collect(Collectors.toList());
	}

	@Override
	public void updateCourse(Course course,int courseId) {
		// TODO Auto-generated method stub
		list.stream().map(b->{
			if(b.getId()==courseId)
			{
				b.setTitle(course.getTitle());
				b.setDescription(course.getDescription());
			}
			return b;
		}).collect(Collectors.toList());
	}

}
