package com.TeacherManagementSystem.service;

import java.util.List;

import com.TeacherManagementSystem.entity.Teacher;

public interface TeacherService {

	public List<Teacher> getAllTeachers();
	
	public Teacher saveTeacher(Teacher teacher);
	
	public Teacher getById(int id);
	
	public void deleteById(int id);
}
