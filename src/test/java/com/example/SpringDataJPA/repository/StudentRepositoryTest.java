package com.example.SpringDataJPA.repository;

import com.example.SpringDataJPA.entity.Guardian;
import com.example.SpringDataJPA.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){

        Guardian guardian = Guardian.builder()
                .name("guardian")
                .email("guardian1@gmail.com")
                .mobile("123456789")
                .build();

        Student student = Student.builder()
                .emailId("ahmed1@gmaill.com")
                .firstName("Ahmed")
                .lastName("yassine")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudents(){
        List<Student> students = studentRepository.findAll();

        System.out.println("Student List" + students);
    }

}