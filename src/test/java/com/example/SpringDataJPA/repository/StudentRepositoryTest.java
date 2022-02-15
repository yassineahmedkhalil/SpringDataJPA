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
    public void createStudent(){

        Guardian guardian = Guardian.builder()
                .mobile("012334568")
                .email("guardian@gmail.com")
                .name("guardian 1")
                .build();

        Student ahmed = Student.builder()
                .emailId("Ahmed@gmail.com")
                .firstName("Ahmed")
                .lastName("yassine")
                .guardian(guardian)
                .build();

        Student amin = Student.builder()
                .emailId("Amin@gmail.com")
                .firstName("Amin")
                .guardian(guardian)
                .lastName("zouari")
                .build();
        studentRepository.saveAll(List.of(ahmed,amin));
    }
    
    @Test
    public void printAllStudents(){
    
        List<Student> students = studentRepository.findAll();
        for(Student s : students)
        {
            System.out.println("---------------------------------------------------------");
            System.out.println(s);
        }
    }

    @Test
    public void printAllStudentsByLastName(){

        List<Student> students = studentRepository.getStudentByLastName("yassine");
        for(Student s : students)
        {
            System.out.println("---------------------------------------------------------");
            System.out.println(s);
        }
    }

    @Test
    public void printAllStudentsByLastNameAndEmail(){

        List<Student> students = studentRepository.getStudentByLastNameAndEmailId("yassine", "mail@gmail.com");
        for(Student s : students)
        {
            System.out.println("---------------------------------------------------------");
            System.out.println(s);
        }
    }

    @Test
    public void printAllStudentsByLastNameContaining(){

        List<Student> students = studentRepository.getStudentByLastNameContaining("ine");
        for(Student s : students)
        {
            System.out.println("---------------------------------------------------------");
            System.out.println(s);
        }
    }

    @Test
    public void getStudentByEmailId(){

       Student student = studentRepository.getStudentByEmailId("ahmed@gmail.com");
       System.out.println("student = " + student);

    }

    @Test
    public void getStudentFirstNameByEmailId(){

        String firstName = studentRepository.getStudentFirstNameByEmailId("ahmed@gmail.com");
        System.out.println("firstName = " + firstName);
    }
}