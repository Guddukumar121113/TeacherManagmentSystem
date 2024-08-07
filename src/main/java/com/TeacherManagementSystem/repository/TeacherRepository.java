package com.TeacherManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TeacherManagementSystem.entity.Teacher;
@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

}
