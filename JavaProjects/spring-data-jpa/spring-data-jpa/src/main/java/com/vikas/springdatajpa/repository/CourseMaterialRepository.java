package com.vikas.springdatajpa.repository;

import com.vikas.springdatajpa.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial,Long> {

    List<CourseMaterial> findAll();
}
