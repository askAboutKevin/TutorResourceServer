package com.tutor.resource.resources;


import com.tutor.resource.model.School;
import com.tutor.resource.service.school.SchoolService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.List;


@Path("/school")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SchoolResource {

    private SchoolService schoolService;

    public SchoolResource(SchoolService schoolService) {
        super();
        this.schoolService = schoolService;
    }

    @GET
    public Response getSchools() {
        List<School> schools = this.schoolService.getAllSchools();

        return Response
                .status(Status.OK)
                .entity(schools)
                .build();
    }

    @GET
    @Path("/{id}")
    public Response getSchoolById(@PathParam("id") int id) {

        School school = this.schoolService.getSchoolById(id);

        return Response
                .status(Status.OK)
                .entity(school)
                .build();
    }

    @POST
    public Response newSchool(School school) {

        int newSchoolId = this.schoolService.addSchool(
                school.getName(),
                school.getStreetAddress(),
                school.getCity(),
                school.getState(),
                school.getZip_code(),
                school.getNces_number(),
                school.getSite_supervisor()
        );

        return Response
                .status(Status.CREATED)
                .entity(newSchoolId)
                .build();
    }

//    @PUT
//    @Path("/{id}")
//    public Response editSchool(School school, @PathParam("id") int id) {
//
//        int updateSchool = this.schoolService.updateSchool(
//                school.getName(),
//                school.getStreetAddress(),
//                school.getCity(),
//                school.getState(),
//                school.getZip_code(),
//                school.getNces_number(),
//                school.getLongitude(),
//                school.getLatitude(),
//                school.getSite_supervisor(),
//                id
//        );
//
//        return Response
//                .status(Status.ACCEPTED)
//                .entity(updateSchool)
//                .build();
//    }

    @DELETE
    @Path("/{id}")
    public Response deleteSchool(@PathParam("id") int id) {

        int deletedSchool = this.schoolService.deleteSchool(id);

        return Response
                .status(Status.OK)
                .entity(deletedSchool)
                .build();
    }
}

