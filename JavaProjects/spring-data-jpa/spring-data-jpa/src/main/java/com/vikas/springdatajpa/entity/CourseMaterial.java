package com.vikas.springdatajpa.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class CourseMaterial {
@Id
@SequenceGenerator(
        name = "course_material_sequence",
        initialValue = 50,
        allocationSize = 1
)
@GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "course_material_sequence"
)
    private Long courseMaterialId;
    private String url;
   // @OneToOne(mappedBy = "courseMaterial",fetch = FetchType.LAZY)// optional = false)
   // @JsonIgnoreProperties(value = {"course","hibernateLazyInitializer"})
   // private Course course;
}


