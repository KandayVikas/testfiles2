package com.example.learnjpaandhibernate.course.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class CourseCommandLineRunner implements CommandLineRunner{

	@Autowired
	CourseJpaRepository courseJpaRepository;
	@Override
	public void run(String... args) throws Exception {
		//courseJdbcRepository.insert();
		//courseJpaRepository.insert(new Course(1,"john",""));
		
	}

	
}
