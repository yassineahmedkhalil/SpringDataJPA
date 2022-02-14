package com.example.SpringDataJPA.repository;

import com.example.SpringDataJPA.entity.Course;
import com.example.SpringDataJPA.entity.CourseMaterial;
import com.example.SpringDataJPA.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;


    @Test
    public void putTeacher(){

        Course math = Course.builder()
                .credit(4)
                .title("Math")
                .build();

        Course science = Course.builder()
                .credit(6)
                .title("Science")
                .build();

        Course history = Course.builder()
                .credit(3)
                .title("history")
                .build();

        Course geography = Course.builder()
                .credit(10)
                .title("geography")
                .build();


        Teacher ahmed = Teacher.builder()
                .firstName("Ahmed")
                .lastName("Yassine")
                .courses(List.of(history,geography))
                .build();

        Teacher max = Teacher.builder()
                .firstName("Max")
                .lastName("Mustermann")
                .courses(List.of(math,science))
                .build();

        teacherRepository.saveAll(List.of(max,ahmed));
    }
}