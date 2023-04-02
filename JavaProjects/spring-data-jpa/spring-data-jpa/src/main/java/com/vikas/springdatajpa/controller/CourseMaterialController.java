package com.vikas.springdatajpa.controller;

import com.vikas.springdatajpa.entity.CourseMaterial;
import com.vikas.springdatajpa.repository.CourseMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@Transactional
public class CourseMaterialController {
//    @Autowired
//    private CourseMaterialRepository courseMaterialRepository;
//
//    @GetMapping("/getcoursematerials")
//    public List<CourseMaterial> getCourseMaterials(){
//        return courseMaterialRepository.findAll();
//    }
}
