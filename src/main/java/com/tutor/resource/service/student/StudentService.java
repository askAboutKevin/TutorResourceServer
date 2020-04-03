package com.tutor.resource.service.student;

import com.tutor.resource.dal.dao.StudentDAO;
import com.tutor.resource.dal.mapper.StudentMapper;
import com.tutor.resource.model.Student;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;

public class StudentService {

    private StudentDAO studentDAO;

    public StudentService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public List<Student> selectAllStudents() {

        List<Student> students = this.studentDAO.selectAllStudents();
        return students;
    }

    public Student selectStudentById(int id) {
        Student student = this.studentDAO.selectStudentById(id);
        return student;
    }

    public int insertStudent(String tutor_id, int school, String name) {

        int insertedStudents = this.studentDAO.insertStudent(
                tutor_id,
                school,
                name
        );
        return insertedStudents;
    }

    public int updateStudent(String tutor_id, String name, int id) {
        if(id < 1) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }

        int updatedStudents = this.studentDAO.updateStudent(tutor_id, name, id);
        return updatedStudents;
    }

    public int deleteStudent(int id) {
        if(id < 1) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        int deletedStudents = this.studentDAO.deleteStudent(id);
        return deletedStudents;
    }

}
