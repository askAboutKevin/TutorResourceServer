package com.tutor.resource.dal.dao;

import com.tutor.resource.dal.mapper.DepartmentMapper;
import com.tutor.resource.model.Department;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import java.util.List;

public interface DepartmentDAO {

    @SqlQuery("SELECT id, name FROM Department")
    @RegisterRowMapper(DepartmentMapper.class)
    List<Department> selectAllDepartments();

    @SqlQuery("SELECT id, name FROM Department WHERE id = ?")
    @RegisterRowMapper(DepartmentMapper.class)
    Department selectDepartmentById(int id);

    @SqlUpdate("INSERT INTO Department(name) VALUES (?)")
    int insertDepartment(String name);

    @SqlUpdate("DELETE FROM Department WHERE id = ?")
    int deleteDepartment(int id);
}
