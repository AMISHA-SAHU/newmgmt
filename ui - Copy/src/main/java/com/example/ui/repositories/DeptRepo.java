package com.example.ui.repositories;

import com.example.ui.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeptRepo extends JpaRepository<Department,String> {
}
