package com.example.ui.services;

import com.example.ui.model.Student;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface StudentService {
    List<Student> getAllStudent();
   void SaveStudent(Student student);
   Student getStudentbyid(int id);
   void deletDatabyid(int id);
}
