package com.wofitu.Springboot.tutorial.service;


import com.wofitu.Springboot.tutorial.entity.Department;
import com.wofitu.Springboot.tutorial.error.DepartmentNotFoundException;
import com.wofitu.Springboot.tutorial.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements  DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }


    @Override
    public Department getDepartmentById(Long id) throws DepartmentNotFoundException {
        Optional<Department> department =
                departmentRepository.findById(id);
        if (!department.isPresent()) {
            throw new DepartmentNotFoundException("Departnment Not Avilable ");
        }

        return department.get();
}

    @Override
    public void deleteDepartmentById(Long id) {
        departmentRepository.deleteById(id);
    }


    @Override
    public Department updateDepartmentById(Long id, Department department) {
        Department departmentRepositoryDB =departmentRepository.findById(id).get();
        if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())){
            departmentRepositoryDB.setDepartmentName(department.getDepartmentName());
        }
        if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())){
            departmentRepositoryDB.setDepartmentCode(department.getDepartmentCode());
        }
        if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())){
            departmentRepositoryDB.setDepartmentAddress(department.getDepartmentAddress());
        }
        return  departmentRepository.save(departmentRepositoryDB);

    }

    @Override
    public Department findDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentName(departmentName);
    }

    @Override
    public Department findByDepartmentNameIgnoreCase(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }


}
