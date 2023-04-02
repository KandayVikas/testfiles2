package com.vikas.springdatajpa.repository;

import com.vikas.springdatajpa.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface CourseRepository extends JpaRepository<Course,Long> {
    List<Course> findAll();
}
