package com.example.Student.Service;

import com.example.Student.Entity.Student;
import com.example.Student.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    public final StudentRepository repo;

    public StudentService(StudentRepository repo){
        this.repo=repo;
    }

    public List<Student>getAllStudent(){
        return repo.findAll();
    }
    public void saveStudent(Student student){
         repo.save(student);
    }

    public Student getStudentById(Long id){
        return repo.findById(id)
                .orElseThrow(() ->new RuntimeException("Student Not Found"));
    }

    public void deleteStudent(Long id){
        repo.deleteById(id);
    }
}
