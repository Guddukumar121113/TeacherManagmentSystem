package com.TeacherManagementSystem.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TeacherManagementSystem.entity.Teacher;
import com.TeacherManagementSystem.service.TeacherService;

@Service
public class Serviceimpl implements TeacherService{

	@Autowired
	com.TeacherManagementSystem.repository.TeacherRepository TeacherRepository;
	
	@Override
	public List<Teacher> getAllTeachers() {
		// TODO Auto-generated method stub
		
		
		 
		List<Teacher>list=TeacherRepository.findAll();
		
		return list;
	}

	@Override
	public Teacher saveTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		return TeacherRepository.save(teacher);
	}

	@Override
	public Teacher getById(int id) {
		// TODO Auto-generated method stub
		return TeacherRepository.findById(id).get();
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
		TeacherRepository.deleteById(id);
	}

}
