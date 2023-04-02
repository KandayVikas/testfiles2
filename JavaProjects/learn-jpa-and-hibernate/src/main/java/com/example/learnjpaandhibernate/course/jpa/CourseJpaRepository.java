package com.example.learnjpaandhibernate.course.jpa;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJpaRepository {

	@Autowired
	private EntityManager entityManager;
	
//	private static String INSERT_QUERY=
//			"""
//			insert into course (id,name,author) 
//			values (1,'aws','hj');	
////					""";	
//	public void insert() {
//		jdbcTemplate.update(
//				"
//				insert into course (id,name,author) 
//				values (1445,'aws','hj')");
//	}
	
	public void insert() {
		entityManager.merge(null);
	}
	
	
}
