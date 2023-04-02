package com.vikas.springdatajpa.controller;

import com.vikas.springdatajpa.entity.Course;
import com.vikas.springdatajpa.entity.CourseMaterial;
import com.vikas.springdatajpa.repository.CourseRepository;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@Transactional
public class CourseController {
//
//    @Autowired
//    private CourseRepository courseRepository;
//    @PostMapping("/savecourse")
//    public void saveCourse(){
//
//        CourseMaterial courseMaterial=CourseMaterial.builder()
//                .url("www.Dotnet.com")
//                .build();
//
//        Course course=Course.builder()
//                .title(".net")
//                .credit(4)
//                .courseMaterial(courseMaterial)
//                .build();
//
//
//        courseRepository.save(course);
//    }
//    @DeleteMapping("/deletecourse")
//    public void deleteCourse(){
//
//        CourseMaterial courseMaterial=CourseMaterial.builder()
//                .url("www.javatpoint.com")
//                .build();
//
//        Course course=Course.builder()
//                .title("Java")
//                .credit(5)
//                .courseMaterial(courseMaterial)
//                .build();
//
//
//        courseRepository.delete(course);
//    }
//    @GetMapping("/findcourses")
//    public List<Course> findCourses(){
//
//
//
//        List<Course> courses=courseRepository.findAll();
//
//        System.out.println("courses "+courses);
//        return courses;
//    }
}
