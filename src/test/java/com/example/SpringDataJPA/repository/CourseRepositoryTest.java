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
    public void addCourse(){

        CourseMaterial google = CourseMaterial.builder()
                .url("www.google.com")
                .build();

        Course html = Course.builder()
                .credit(4)
                .title("html")
                .courseMaterial(google)
                .build();

        Course ajax = Course.builder()
                .credit(3)
                .courseMaterial(google)
                .title("ajax")
                .build();
        courseRepository.saveAll(List.of(html,ajax));
    }

    @Test
    public void addCourseWithTeacherAndMaterialId(){

        Teacher teacher = Teacher.builder()
                .firstName("Ahmed")
                .lastName("Yassine")
                .build();

        Course course = Course.builder()
                .title("Json")
                .credit(3)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }
}