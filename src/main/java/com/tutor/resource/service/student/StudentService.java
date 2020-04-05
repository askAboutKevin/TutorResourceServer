package com.tutor.resource.service.student;

import com.tutor.resource.dal.dao.StudentDAO;
import com.tutor.resource.model.Student;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

public class StudentService {

    private StudentDAO studentDAO;

    public StudentService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public List<Student> selectAllStudents(String studentName, String tutor) {

        List<Student> students = this.studentDAO.selectStudentByName(tutor);

//        String nameRegex = studentName + "*";
//        System.out.println(nameRegex);
//        System.out.println(students.get(0));
//      Add helper function to send a student and name and see if it matches
        List<Student> filteredStudents = students.stream().filter(
            student -> student.getFirstName().matches(studentName) || student.getLastName().matches(studentName)
        ).collect(Collectors.toList());

        return filteredStudents;
    }

    public int insertStudent(String firstName, String lastName, int tutor_id, int school) {

        int insertedStudents = this.studentDAO.insertStudent(
                firstName,
                lastName,
                tutor_id,
                school
        );

        return insertedStudents;
    }

//    public Student selectStudentById(int id) {
//        Student student = this.studentDAO.selectStudentById(id);
//        return student;
//    }
//
//    public int updateStudent(String tutor_id, String name, int id) {
//        if(id < 1) {
//            throw new WebApplicationException(Response.Status.BAD_REQUEST);
//        }
//
//        int updatedStudents = this.studentDAO.updateStudent(tutor_id, name, id);
//        return updatedStudents;
//    }

    public int deleteStudent(int id) {
        if(id < 1) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        int deletedStudents = this.studentDAO.deleteStudent(id);
        return deletedStudents;
    }

}
