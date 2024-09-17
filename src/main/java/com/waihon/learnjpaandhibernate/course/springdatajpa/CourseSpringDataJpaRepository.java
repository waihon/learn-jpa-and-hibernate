package com.waihon.learnjpaandhibernate.course.springdatajpa;

import com.waihon.learnjpaandhibernate.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {

    public List<Course> findByName(String name);

    public List<Course> findByAuthor(String author);
}
