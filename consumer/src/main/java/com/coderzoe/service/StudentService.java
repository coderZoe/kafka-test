package com.coderzoe.service;

import com.coderzoe.entity.Student;
import com.coderzoe.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author coderZoe
 * @date 2022/3/23 19:59
 */
@Service
public class StudentService {
    private StudentRepository studentRepository;

    public void save(Iterable<Student> students){
        studentRepository.saveAll(students);
    }

    public List<Student> getByNameLike(String name){
        return studentRepository.findByNameLike(name);
    }

    public List<Student> getByNameContains(String name){
        return studentRepository.findByNameContains(name);
    }
    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
}
