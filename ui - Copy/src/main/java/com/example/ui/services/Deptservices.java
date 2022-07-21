package com.example.ui.services;

import com.example.ui.model.Department;
import com.example.ui.model.Student;
import com.example.ui.repositories.DeptRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Deptservices {
    @Autowired
    private DeptRepo deptRepo;

    public Department getdepartment(String dept_code){
        Optional<Department> op =deptRepo.findById(dept_code);
        Department department=null;
        if(op.isPresent()){
            department=op.get();
        }else{
            throw new RuntimeException("Department does not exist");

        }
        return department;
    }
}
