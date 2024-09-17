package com.waihon.learnjpaandhibernate.course;

import com.waihon.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import com.waihon.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class CourseCommandLineRunner implements CommandLineRunner {
    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1, "Learn AWS Spring Data JPA Now!", "in28minutes"));
        repository.save(new Course(2, "Learn Azure Spring Data JPA Now!", "in28minutes"));
        repository.save(new Course(3, "Learn DevOps Spring Data JPA Now!", "in28minutes"));

        repository.deleteById(2l);

        System.out.println(repository.findById(1l));
        System.out.println(repository.findById(3l));
    }
}
