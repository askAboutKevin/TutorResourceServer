package com.tutor.resource.resources;

import com.tutor.resource.model.Department;
import com.tutor.resource.service.department.DepartmentService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.List;

@Path("/department")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DepartmentResource {

    private DepartmentService departmentService;

    public DepartmentResource(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GET
    public Response fetchDepartments() {

        List<Department> departmentList = this.departmentService.getAllDepartments();
        if(departmentList != null) {
            return Response
                    .status(Response.Status.OK)
                    .entity(departmentList)
                    .build();
        }
        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @GET
    @Path("/{id}")
    public Response fetchDepartmentById(@PathParam("id") int id) {

        Department department = this.departmentService.getDepartmentById(id);
        if(department != null) {
            return Response
                    .status(Status.OK)
                    .entity(department)
                    .build();
        }
        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @POST
    public Response createDepartment(@QueryParam("name") String departmentName ) {

        int created = this.departmentService.addDepartment(departmentName);

        if(created == 1) {
            return Response
                    .status(Status.OK)
                    .entity(true)
                    .build();
        }
        else if(created == 0) {
            return Response
                    .status(Status.OK)
                    .entity(false)
                    .build();
        }
        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @DELETE
    public Response deleteDepartment(@QueryParam("id") int departmentId ) {

        int deleted = this.departmentService.deleteDepartment(departmentId);

        if(deleted == 1) {
            return Response
                    .status(Status.OK)
                    .entity(true)
                    .build();
        }
        else if(deleted == 0) {
            return Response
                    .status(Status.OK)
                    .entity(false)
                    .build();
        }
        throw new WebApplicationException(Status.NOT_FOUND);
    }
}
