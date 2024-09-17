package com.waihon.learnjpaandhibernate.course.springdatajpa;

import com.waihon.learnjpaandhibernate.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {
}
