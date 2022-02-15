package com.example.SpringDataJPA.repository;

import com.example.SpringDataJPA.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    List<Student>getStudentByFirstName(String firstName);
    List<Student>getStudentByLastName(String lastName);
    List<Student>getStudentByLastNameAndEmailId(String lastName, String email);
    List<Student>getStudentByLastNameContaining(String name);

    @Query("select s from Student s where s.emailId = ?1")
    Student getStudentByEmailId(String emailId);

    @Query("select s.firstName from Student s where s.emailId = ?1")
    String getStudentFirstNameByEmailId(String emailId);


}
