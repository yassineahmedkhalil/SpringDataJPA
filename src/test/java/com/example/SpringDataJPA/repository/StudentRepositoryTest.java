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

    @Test
    public void printStudentByFirstname(){
        List<Student> students = studentRepository.findByFirstName("Ahmed");
        System.out.println(students);
    }

    @Test
    public void printStudentByCharacter(){
        List<Student> students = studentRepository.findByFirstNameContaining("as");
        for(Student s : students){
            System.out.println(s);
        }
    }

    @Test
    public void printStudentBasedOnGuardienName(){
        List<Student> students =studentRepository.findByGuardianName("guardian");
        for(Student s : students){
            System.out.println(s);
        }
    }

    @Test
    public void printStudentByFirstNameAndLastName(){
        Student student = studentRepository.findByFirstNameAndLastName("ahmed", "yassine");
        System.out.println(student);
    }

    @Test
    public void printgetStundentByEmailaddress(){
        Student student = studentRepository.getStudentByEmailaddress("ahmed@gmaill.com");
        System.out.println("student = " + student);
    }

    @Test
    public void printgetStundentFirstNameByEmailaddress(){
        String stundetnFirstName = studentRepository.getStudentFirstNameByEmailaddress("ahmed@gmaill.com");
        System.out.println("stundetnFirstName = " + stundetnFirstName);
    }

    @Test
    public void printgetStudentByEmailAddressNative(){

        Student student =
                studentRepository.getStudentByEmailAddressNative("ahmed@gmaill.com");
        System.out.println("student = " + student);
    }

    @Test
    public void getStudentByEmailAddressNativeNamedParam(){
        Student student =
                studentRepository.getStudentByEmailAddressNativeNamedParam("ahmed@gmaill.com");
        System.out.println("student = " + student);
    }

    @Test
    public void updateStudentNameByEmailId(){

        studentRepository.updateStudentNameByEmailId("khalil","ahmed@gmaill.com");
    }
}