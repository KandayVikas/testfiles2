package com.vikas.springdatajpa.controller;


import com.vikas.springdatajpa.entity.Course;
import com.vikas.springdatajpa.entity.Guardian;
import com.vikas.springdatajpa.entity.Student;
import com.vikas.springdatajpa.repository.StudentRepository;
import com.vikas.springdatajpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
//    @Autowired
//    private StudentService studentService;

    @Autowired
    private StudentRepository studentRepository;


    @GetMapping("/savestudent")
    public void saveStudent(){
//        Guardian guardian= Guardian.builder()
//                .name("don")
//                .mobile("100")
//                .email("don@gmail.com")
//                .build();


        Course student=Course.builder()
                .title("C")
                .credit(5)
                .build();
        //studentRepository.save(student);
    }

    @GetMapping("/getallstudents")
    public List<Student> getStudents(){

        List<Student> studentList=new ArrayList<Student>();
                studentRepository.findAll().forEach(student -> studentList.add(student));
        System.out.println("studentlist "+studentList);
        return studentList;
    }

    @GetMapping("/findbyfirstname/{firstName}")
    public List<Student> findByFirstName(@PathVariable String firstName){

        List<Student> studentList=studentRepository.findByFirstName(firstName);
//        studentRepository.findByFirstName(firstName);
//        System.out.println("studentlist "+studentList);
        return studentList;
    }

    @GetMapping("/findbyfirstnamecontianing/{firstName}")
    public List<Student> findbyfirstnamecontianing(@PathVariable String firstName){

        List<Student> studentList=studentRepository.findByFirstNameContaining(firstName);
//        studentRepository.findByFirstName(firstName);
//        System.out.println("studentlist "+studentList);
        return studentList;
    }

    @GetMapping("/getFirstNameByEmailAddress/{emailId}")
    public String getFirstNameByEmailAddress(@PathVariable String emailId){

        return studentRepository.getFirstNameByEmailAddress(emailId);

    }

    @GetMapping("/getGuardianNameByFirstName/{firstName}")
    public String getGuardianNameByFirstName(@PathVariable String firstName){

        return studentRepository.getGuardianNameByFirstName(firstName);

    }

    @GetMapping("/getGuardianNameByFirstNameAndLastName/{firstName}/{lastName}")
    public String getGuardianNameByFirstNameAndLastName(@PathVariable String firstName, @PathVariable String lastName){

        return studentRepository.getGuardianNameByFirstNameAndLastName(firstName,lastName);

    }

    @GetMapping("/updateFirstNameByEmailId/{firstName}/{emailId}")
    public void updateFirstNameByEmailId(@PathVariable String firstName, @PathVariable String emailId){

        studentRepository.updateFirstNameByEmailId(firstName,emailId);

    }
}
