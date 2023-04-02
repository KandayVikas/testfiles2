package com.dailycodebuffer.user.repository;

import com.dailycodebuffer.user.entity.EndUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<EndUser,Long> {
    EndUser findByUserId(Long id);
}
