package com.waihon.learnjpaandhibernate.course.jpa;

import com.waihon.learnjpaandhibernate.course.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CourseJpaRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void insert(Course course) {
        entityManager.merge(course);
    }

    public Course findById(long courseId) {
        return entityManager.find(Course.class, courseId);
    }

    public void deleteById(long courseId) {
        Course course = findById(courseId);
        entityManager.remove(course);
    }

    public void seedData() {
        insert(new Course(1, "Learn AWS JPA Now!", "in28minutes"));
        insert(new Course(2, "Learn Azure JPA Now!", "in28minutes"));
        insert(new Course(3, "Learn DevOps JPA Now!", "in28minutes"));

        deleteById(2);

        System.out.println(findById(1));
        System.out.println(findById(3));
    }
}
