package com.wofitu.Springboot.tutorial.service;

import com.wofitu.Springboot.tutorial.entity.Department;
import com.wofitu.Springboot.tutorial.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
   public Department saveDepartment(Department department);
   public List<Department> getAllDepartment();

  public Department getDepartmentById(Long id) throws DepartmentNotFoundException;

  public  void deleteDepartmentById(Long id);

   public Department updateDepartmentById(Long id, Department department);

   public Department findDepartmentByName(String departmentName);
   public  Department findByDepartmentNameIgnoreCase(String departmentName);
}
