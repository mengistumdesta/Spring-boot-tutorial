package com.wofitu.Springboot.tutorial.controller;

import com.wofitu.Springboot.tutorial.entity.Department;
import com.wofitu.Springboot.tutorial.error.DepartmentNotFoundException;
import com.wofitu.Springboot.tutorial.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    private final Logger  LOGGER = LoggerFactory.getLogger(DepartmentController.class);
    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("LoInside save department of Department Controller class");
       return  departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> getAllDepartment(){
        LOGGER.info("LoInside get all department of Department Controller class");
        return  departmentService.getAllDepartment();
    }

    @GetMapping("/departments/{id}")
    public Department getDepartmentById(@PathVariable("id") Long id) throws DepartmentNotFoundException {
        return departmentService.getDepartmentById(id);
    }

    @DeleteMapping("/departments/{id}")
    public String  deleteDepartmentId(@PathVariable("id") Long id){
       departmentService.deleteDepartmentById(id);
       return "Department deleted Successfully";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartmentId(@PathVariable("id") Long id, @RequestBody Department department){

       return departmentService.updateDepartmentById(id,department);
    }

    @GetMapping("/departments/name/{name}")
    public Department findDepartmentByName(@PathVariable("name") String departmentName){
        return departmentService.findByDepartmentNameIgnoreCase(departmentName);

    }

}
