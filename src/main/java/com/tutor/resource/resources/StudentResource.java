package com.tutor.resource.resources;

import com.tutor.resource.service.student.StudentService;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/student")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StudentResource {

    private StudentService studentService;

    public StudentResource(StudentService studentService) {
        this.studentService = studentService;
    }
}
