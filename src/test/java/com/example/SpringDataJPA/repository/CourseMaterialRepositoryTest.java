package com.example.SpringDataJPA.repository;

import com.example.SpringDataJPA.entity.Course;
import com.example.SpringDataJPA.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void SaveCourseMaterial(){

        Course course = Course.builder()
                .title("title")
                .credit(1)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.google.com")
                .course(course)
                .build();

        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void printAllSourceMaterials(){
        List<CourseMaterial> courseMaterials =
                courseMaterialRepository.findAll();

        System.out.println("courseMaterials = " + courseMaterials);
    }
}