package com.tutor.resource.resources;

import com.tutor.resource.model.Student;
import com.tutor.resource.service.student.StudentService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/student")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StudentResource {

    private StudentService studentService;

    public StudentResource(StudentService studentService) {
        this.studentService = studentService;
    }

    // Search For Student By Name And Tutor Id
    @GET
    public Response fetchStudent(@QueryParam("name") String studentName, @QueryParam("tutor") String tutor) {

        List<Student> students = this.studentService.selectAllStudents(studentName, tutor);

        return Response
                .status(Response.Status.OK)
                .entity(students)
                .build();

    }

    // No Response To User Needed
    @POST
    public Response addStudent(Student student) {

        int studentAdded = this.studentService.insertStudent(student.getFirstName(), student.getLastName(), student.getTutorDailyTrackerId(), student.getSchool());

        return Response
                .status(Response.Status.OK)
                .entity(studentAdded == 1)
                .build();

    }
}
