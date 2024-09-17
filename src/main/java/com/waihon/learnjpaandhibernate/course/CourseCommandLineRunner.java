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
        repository.save(new Course(4, "Full Stack React and Java Spring Boot", "luv2code"));

        repository.deleteById(2l);

        System.out.println(repository.findById(1l));
        System.out.println(repository.findById(3l));

        System.out.println(repository.findAll());
        System.out.println(repository.count());

        System.out.println(repository.findByAuthor("in28minutes"));
        System.out.println(repository.findByAuthor(""));
        System.out.println(repository.findByAuthor("luv2code"));

        System.out.println(repository.findByName("Learn DevOps Spring Data JPA Now!"));
        System.out.println(repository.findByName("Full Stack"));
    }
}
