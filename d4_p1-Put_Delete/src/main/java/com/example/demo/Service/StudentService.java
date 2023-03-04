package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.Models.Student;
import com.example.demo.Repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository repository;
	public Optional<Student> getStudent(int id){
		return repository.findById(id);
	}
	public String updateDetails(Student stu) {
		repository.save(stu);
		return "updated";
	}
	public String deleteDetails(int id) {
		repository.deleteById(id);
		return "Id deleted";
	}
}