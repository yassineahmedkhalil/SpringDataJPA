package com.example.SpringDataJPA.repository;

import com.example.SpringDataJPA.entity.Course;
import com.example.SpringDataJPA.entity.CourseMaterial;
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

    @Test
    public void saveCourseWithMaterial(){
        Course course1 =Course.builder()
                .credit(1)
                .title("ss")
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.udemy.com")
                .build();

        Course course = Course.builder()
                .title("soap")
                .credit(2)
                .courseMaterial(courseMaterial)
                .build();

        courseRepository.save(course);
    }
}