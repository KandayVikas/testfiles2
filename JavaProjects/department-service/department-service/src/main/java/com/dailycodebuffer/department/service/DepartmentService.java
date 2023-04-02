package com.dailycodebuffer.department.service;

import com.dailycodebuffer.department.entity.Department;
import com.dailycodebuffer.department.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;


    public Department saveDepartment(Department department){
        log.info("Inside saveDepartment method of DepartmentService");
        return departmentRepository.save(department);
    }

    public Department findByDepartmentId(Long id) {
        return departmentRepository.findByDepartmentId(id);
    }

}
