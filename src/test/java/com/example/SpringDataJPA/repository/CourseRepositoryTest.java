package com.example.SpringDataJPA.repository;

import com.example.SpringDataJPA.entity.Course;
import com.example.SpringDataJPA.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses(){
        List<Course> courses =
                courseRepository.findAll();
        System.out.println("courses = " + courses);
    }


    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher = Teacher.builder()

                .lastName("khalil")
                .firstName("khalil")
                .build();

        Course course = Course.builder()
                .title("java")
                .credit(6)
                .teacher(teacher)
                .build();

    courseRepository.save(course);
    }
}