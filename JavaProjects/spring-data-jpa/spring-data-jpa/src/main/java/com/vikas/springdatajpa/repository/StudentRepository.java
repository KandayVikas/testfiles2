package com.vikas.springdatajpa.repository;


import com.vikas.springdatajpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    List<Student> findByFirstName(String firstName);
    List<Student> findByFirstNameContaining(String firstName);

    //JPQL
    @Query("select s.firstName from Student s where s.emailId =?1")
    String getFirstNameByEmailAddress(String emailId);

    //NativeQuery
    @Query(
            value = "select guardian_name from tbl_student where tbl_student.first_name =?1",
            nativeQuery = true
    )
    String getGuardianNameByFirstName(String firstName);

    //NamedQuery
    @Query(
            value = "select guardian_name from tbl_student where tbl_student.first_name =:firstName and tbl_student.last_name =:lastName ",
            nativeQuery = true
    )
    String getGuardianNameByFirstNameAndLastName(String firstName,String lastName);

    //for insert and update use modifying annotation
    @Modifying
    @Transactional
    @Query(
            value =" update tbl_student set tbl_student.first_name=:firstName  where tbl_student.email_address=:emailId",
            nativeQuery = true
    )
    void updateFirstNameByEmailId(String firstName,String emailId);


}
