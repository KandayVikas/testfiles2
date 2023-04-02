package com.vikas.springdatajpa.controller;

import com.vikas.springdatajpa.entity.Course;
import com.vikas.springdatajpa.entity.Teacher;
import com.vikas.springdatajpa.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TeacherController {

    @Autowired
    private TeacherRepository teacherRepository;
@PostMapping("/saveteacher")
public Teacher saveTeacher(){

    Course course= Course.builder()
            .title(".net")
            .credit(4)
            .build();
     List<Course> courseList=new ArrayList<>();
     courseList.add(course);
      Teacher teacher= Teacher.builder()
         .firstName("Cam")
         .lastName("Green")
         .courses(courseList)
         .build();
   return teacherRepository.save(teacher);

}

}
