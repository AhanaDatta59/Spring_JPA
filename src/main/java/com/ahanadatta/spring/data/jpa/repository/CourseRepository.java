package com.ahanadatta.spring.data.jpa.repository;

import com.ahanadatta.spring.data.jpa.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {

}
