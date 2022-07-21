package com.example.ui.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Department {
    @Id
    @GeneratedValue
    private String Dept_code;
    private String Dept_name;
    private String HOD;

   @OneToMany(mappedBy = "department")
   List<Student> students=new ArrayList<>();

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getDept_code() {
        return Dept_code;
    }

    public void setDept_code(String dept_code) {
        Dept_code = dept_code;
    }

    public String getDept_name() {
        return Dept_name;
    }

    public void setDept_name(String dept_name) {
        Dept_name = dept_name;
    }

    public String getHOD() {
        return HOD;
    }

    public void setHOD(String HOD) {
        this.HOD = HOD;
    }
}
