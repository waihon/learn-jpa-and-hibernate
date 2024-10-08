package com.waihon.learnjpaandhibernate.course.jdbc;

import com.waihon.learnjpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {

    private JdbcTemplate springJdbcTemplate;

    private static String INSERT_QUERY =
            """
            insert into course (id, name, author)
            values (?, ?, ?);
            """;

    private static String DELETE_QUERY =
            """
            delete from course
            where id = ?;
            """;

    private static String SELECT_QUERY =
            """
            select * from course
            where id = ?;
            """;

    @Autowired
    public CourseJdbcRepository(JdbcTemplate springJdbcTemplate) {
        this.springJdbcTemplate = springJdbcTemplate;
    }

    public void insert(Course course) {
        springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }

    public void deleteById(long courseId) {
        springJdbcTemplate.update(DELETE_QUERY, courseId);
    }

    public Course findById(long courseId) {
        // ResultSet -> Bean => Row Mapper =>
        return springJdbcTemplate.queryForObject(SELECT_QUERY,
                new BeanPropertyRowMapper<>(Course.class), courseId);
    }

    public void seedData() {
        insert(new Course(1, "Learn AWS JDBC Now!", "in28minutes"));
        insert(new Course(2, "Learn Azure JDBC Now!", "in28minutes"));
        insert(new Course(3, "Learn DevOps JDBC Now!", "in28minutes"));

        deleteById(2);

        System.out.println(findById(1));
        System.out.println(findById(3));
    }
}
