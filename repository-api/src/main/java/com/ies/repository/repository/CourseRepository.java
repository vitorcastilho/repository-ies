package com.ies.repository.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ies.repository.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

	Boolean existsByCourse(String course);

}
