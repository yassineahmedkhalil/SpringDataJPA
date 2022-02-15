package com.example.SpringDataJPA.repository;

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
    public void addCourseMaterial(){

        CourseMaterial springBoot =  CourseMaterial.builder()
                .url("www.SpringBoot.com")
                .build();


        CourseMaterial jpa =  CourseMaterial.builder()
                .url("www.jpa.com")
                .build();
        courseMaterialRepository.saveAll(List.of(springBoot,jpa));
    }
}