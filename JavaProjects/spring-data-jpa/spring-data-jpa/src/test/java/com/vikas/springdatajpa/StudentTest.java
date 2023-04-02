package com.vikas.springdatajpa;

import com.vikas.springdatajpa.entity.Student;
import com.vikas.springdatajpa.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student=Student.builder().
                firstName("John")
                        .lastName("Abraham")
                                .emailId("johnabraham@gmail.com")
                                        .guardianName("Balu")
                                                .guardianEmail("balu@gmail.com")
                                                        .guardianMobile("99999")
                .build();
        studentRepository.save(student);
    }
}
