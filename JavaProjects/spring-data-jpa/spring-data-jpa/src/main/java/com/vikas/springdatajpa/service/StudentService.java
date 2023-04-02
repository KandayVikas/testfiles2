package com.vikas.springdatajpa.service;

import com.vikas.springdatajpa.entity.Guardian;
import com.vikas.springdatajpa.entity.Student;
import com.vikas.springdatajpa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;


    public void saveStudent(){
        Guardian guardian= Guardian.builder()
                .name("don")
                        .mobile("100")
                                .email("don@gmail.com")
                .build();


        Student student=Student.builder().
                firstName("Kitty")
                .lastName("Abraham")
                .emailId("kittybraham@gmail.com")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }
}
