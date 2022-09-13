package com.ies.repository.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ies.repository.entity.Course;
import com.ies.repository.exception.BusinessException;
import com.ies.repository.exception.EntityNotFoundException;
import com.ies.repository.repository.CourseRepository;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	@Transactional
	public Course saveNewCourse(Course course) {
		
		if (existsByCourse(course.getCourse())) {
			throw new BusinessException("Curso já cadastrado");
		}
		return courseRepository.save(course);
	}
	
	public List<Course> listAllCourse() {
		List<Course> courseList = courseRepository.findAll();
		
		if ( courseList.isEmpty()) {
			throw new EntityNotFoundException("Não existe curso cadastrado.");
		}
		
		return courseList;
	}
	
	public Course findCourseById(Long id) {
		return  courseRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Curso não cadastrado."));
	}
	
	@Transactional
	public Boolean deleteByIdCourse(Long id) {
		Course course = findCourseById(id);
		boolean valid = course != null;
		
		if (!valid) {
			throw new EntityNotFoundException("Curso não cadastrado.");
		}
		
		courseRepository.deleteById(id);
		
		return valid;
	}
	
	@Transactional
	public Course updateCourse(Course course) {
		
		if (findCourseById(course.getIdCourse()) == null) {
			throw new EntityNotFoundException("Curso não cadastrado.");
		}
		return courseRepository.save(course);
	}
	
	public Boolean existsByCourse(String course) {
		return courseRepository.existsByCourse(course);
	}
	
}
