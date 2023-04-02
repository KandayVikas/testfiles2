package com.dailycodebuffer.user.service;

import com.dailycodebuffer.user.VO.Department;
import com.dailycodebuffer.user.VO.RestTemplateVO;
import com.dailycodebuffer.user.entity.EndUser;
import com.dailycodebuffer.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public EndUser saveUser(EndUser user) {
        return userRepository.save(user);
    }


    public RestTemplateVO getUserWithDepartment(Long userId) {
        RestTemplateVO restTemplateVO=new RestTemplateVO();
        EndUser user=userRepository.findByUserId(userId);
        Department department=restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(), Department.class);
        //we can also use this uri in above line but by using service-registry we are eliminating use of hostnames and port numbers so we are using service name
        // "http://localhost:9001/departments/"+user.getDepartmentId()
        restTemplateVO.setUser(user);
        restTemplateVO.setDepartment(department);
        return restTemplateVO;

    }
}
