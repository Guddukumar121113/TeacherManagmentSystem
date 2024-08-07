package com.TeacherManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.TeacherManagementSystem.entity.Teacher;
import com.TeacherManagementSystem.service.TeacherService;

@Controller
public class controller {

	@Autowired
	private TeacherService service;
	
	@GetMapping("/home")
	public String home(){
		return "home";
	}
	
	@GetMapping("/Teachers")
	public String getAllTeachers(Model model) {
				
		model.addAttribute("Teachers", service.getAllTeachers());
		
		return "Teachers";
		
	}
	
	@GetMapping("Teachers/new")
	public String createTeacherFome(Model model) {
		
		Teacher teachers=new Teacher ();
		
		model.addAttribute("Teachers", teachers);
		
		return "create-teachers";
	}
	
	@PostMapping("/Teachers")
	public String saveTeacher(@ModelAttribute("Teacher") Teacher Teacher) {
		
		service.saveTeacher(Teacher);
		
		return "redirect:/Teachers";
		
	}
	
	@GetMapping("/Teachers/edit/{id}")
	public String editTeacherFome(@PathVariable int id,Model model) {
		
		model.addAttribute("Teacher", service.getById(id));
		
		return "edit_Teacher";		
	}
	
	
	@PostMapping("/Teachers/edit/{id}")
	public String updateTeacher(@PathVariable int id, @ModelAttribute("Teacher") Teacher teacher) {
	    // Fetch the existing teacher by ID
	    Teacher existingTeacher = service.getById(id);

	    // Update the existing teacher's details with the provided details
	    existingTeacher.setFirstName(teacher.getFirstName());
	    existingTeacher.setLastName(teacher.getLastName());
	    existingTeacher.setEmail(teacher.getEmail());

	    // Save the updated teacher back to the database
	    service.saveTeacher(existingTeacher);

	    // Redirect to the list of teachers
	    return "redirect:/Teachers";
	}
	
	@GetMapping("/Teachers/{id}")
	public String deleteById(@PathVariable int id)
	{
		
		service.deleteById(id);
		return "redirect:/Teachers";
	}

	}
	
