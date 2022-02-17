package com.example.SpringDataJPA.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "course")
@Builder
public class CourseMaterial {

    @Id
    @SequenceGenerator(
            sequenceName = "course_material_sequence",
            name = "course_material_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_material_sequence"
    )
    private Long courseMaterialId;
    private String url;

    @OneToOne(

            // usecase to understand Cascade
            //if we try to add a Coursematerial with a course we will have this exception
            // (transient instance must be saved before current operation) so we can fix it with the Cascade Parameter
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "course_id",
            referencedColumnName = "courseId"
    )
    private Course course;
}