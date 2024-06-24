package com.example.SoaEvBackend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<StudentEntity,Long> {
    Optional<StudentEntity> findByRegNo(String regNo);
}
