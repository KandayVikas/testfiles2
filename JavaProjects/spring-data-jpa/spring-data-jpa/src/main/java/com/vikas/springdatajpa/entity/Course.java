package com.vikas.springdatajpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.Cascade;


import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
//@ToString(exclude = "courseMaterial")
public class Course {

    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName= "course_sequence",
            allocationSize = 1,
            initialValue = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    private Long courseId;
    private String title;
    private Integer credit;
   //@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY, optional = false
//    )
//    @JoinColumn(
//            name = "course_material_id",
//            referencedColumnName = "courseMaterialId"
//    )
//    @JsonIgnoreProperties(value = {"courseMaterial","hibernateLazyInitializer"})
   @OneToOne
    private CourseMaterial courseMaterial;
}
