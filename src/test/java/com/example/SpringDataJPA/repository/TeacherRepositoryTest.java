package com.example.SpringDataJPA.repository;

import com.example.SpringDataJPA.entity.Course;
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
    public void addTeacher() {

        Teacher uwe = Teacher.builder()
                .firstName("Uwe")
                .lastName("Kadelka")
                .build();

        Teacher alfred = Teacher.builder()
                .firstName("Alfred")
                .lastName("Meissner")
                .build();
        teacherRepository.saveAll(List.of(alfred, uwe));
    }

    @Test
    public void addTeacherWithCourses(){

        Course c = Course.builder()
                .credit(4)
                .title("c")
                .build();
        Course xml = Course.builder()
                .credit(4)
                .title("xml")
                .build();

        Teacher teacher = Teacher.builder()
                .lastName("kevin")
                .firstName("Schulz")
                .course(List.of(c,xml))
                .build();
        teacherRepository.save(teacher);
    }
}