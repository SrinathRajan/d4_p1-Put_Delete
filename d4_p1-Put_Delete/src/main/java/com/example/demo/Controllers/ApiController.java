package com.example.demo.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.Student;
import com.example.demo.Repository.StudentRepository;
import com.example.demo.Service.StudentService;

@RestController
public class ApiController {
	@Autowired
	StudentRepository serviceRepository;
	@Autowired
	StudentService service;
	@GetMapping("/getValues")
	List<Student> getList(){
		return serviceRepository.findAll();
	}
	@PostMapping("/post")
	public Student create(@RequestBody Student stu) {
		return serviceRepository.save(stu);
	}
	@GetMapping("/getvalues/{id}")
	public Optional<Student> getbyid(@PathVariable int id){
		return service.getStudent(id);
	}
	@PutMapping("/student")
	public String update(@RequestBody Student stu) {
		return service.updateDetails(stu);
	}
	@DeleteMapping("/student")
	public String delet(@RequestParam int id) {
		return service.deleteDetails(id);
	}
}