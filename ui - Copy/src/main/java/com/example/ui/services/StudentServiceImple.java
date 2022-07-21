package com.example.ui.services;

import com.example.ui.model.Student;
import com.example.ui.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImple implements StudentService{
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public List<Student> getAllStudent() {
       return studentRepository.findAll();

    }

    @Override
    public void SaveStudent(Student student) {
      this.studentRepository.save(student);


    }

    @Override
    public Student getStudentbyid(int id) {
       Optional<Student> op =studentRepository.findById(id);
       Student student=null;
       if(op.isPresent()){
           student=op.get();
       }else{
           throw new RuntimeException("Student with ROLL NO"+id+"NOT FOUND");

       }
       return student;

    }

    @Override
    public void deletDatabyid(int id) {
        this.studentRepository.deleteById(id);
    }

}
