package com.tutor.resource.service.department;

import com.tutor.resource.dal.dao.DepartmentDAO;
import com.tutor.resource.model.Department;

import java.util.List;

public class DepartmentService {

    private DepartmentDAO departmentDAO;

    public DepartmentService(DepartmentDAO departmentDAO) {
        this.departmentDAO = departmentDAO;
    }

    public List<Department> getAllDepartments() {
        List<Department> departments = this.departmentDAO.selectAllDepartments();

        return departments;
    }

    public Department getDepartmentById(int id) {
        Department department = this.departmentDAO.selectDepartmentById(id);

        return department;
    }

    public int addDepartment(String name) {

        int departmentAdded = this.departmentDAO.insertDepartment(name);

        return departmentAdded;
    }

    public int deleteDepartment(int id) {

        int deletedDepartments = this.departmentDAO.deleteDepartment(id);

        return deletedDepartments;
    }

}
