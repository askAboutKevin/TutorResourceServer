package com.tutor.resource.resources;

import com.tutor.resource.model.PrivilegedUser;
import com.tutor.resource.model.Tutor;
import com.tutor.resource.service.tutor.TutorService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/tutor")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TutorResource {

    private TutorService tutorService;

    public TutorResource(TutorService tutorService) {
        this.tutorService = tutorService;
    }

    @GET
    public Response fetchTutors() {

        List<Tutor> tutors = this.tutorService.selectAllTutors();

        if (tutors != null) {
            return Response
                    .status(Response.Status.OK)
                    .entity(tutors)
                    .build();
        }
        throw new WebApplicationException(Response.Status.NOT_FOUND);
    }

    @GET
    @Path("/{identifier}")
    public Response fetchTutorByIdentifier(@PathParam("identifier") String identifier) {

        Tutor tutor;

        tutor = this.tutorService.selectTutorById(identifier);

        if (tutor != null) {
            return Response
                    .status(Response.Status.OK)
                    .entity(tutor)
                    .build();
        }

        tutor = this.tutorService.selectTutorByEmail(identifier);


        if (tutor != null) {
            return Response
                    .status(Response.Status.OK)
                    .entity(tutor)
                    .build();
        }
        throw new WebApplicationException(Response.Status.NOT_FOUND);
    }

    @POST
    public Response createTutor(Tutor tutor) {

        int tutorCreated = this.tutorService.insertTutor(
                tutor.getTopic(),
                tutor.getFirst_name(),
                tutor.getLast_name(),
                tutor.getSchool(),
                tutor.getUniversity(),
                tutor.getSupervisor(),
                tutor.getDepartment(),
                tutor.getPassword_hash(),
                tutor.getEmail(),
                tutor.getContact_number()
        );

        if (tutorCreated == 1) {
            return Response
                    .status(Response.Status.CREATED)
                    .entity(true)
                    .build();
        } else if (tutorCreated == 0) {
            return Response
                    .status(Response.Status.NOT_MODIFIED)
                    .entity(false)
                    .build();
        }
        throw new WebApplicationException(Response.Status.NOT_FOUND);
    }

    @PUT
    @Path("/{id}")
    public Response updateTutor(Tutor tutor, @PathParam("id") String id) {

        int tutorUpdated = this.tutorService.updateTutorUsernamePassword(
                tutor.getPassword_hash(),
                tutor.getEmail(),
                tutor.getContact_number(),
                tutor.getId()
        );

        if (tutorUpdated == 1) {
            return Response
                    .status(Response.Status.CREATED)
                    .entity(true)
                    .build();
        } else if (tutorUpdated == 0) {
            return Response
                    .status(Response.Status.NOT_MODIFIED)
                    .entity(false)
                    .build();
        }
        throw new WebApplicationException(Response.Status.NOT_FOUND);
    }

    @DELETE
    @Path("/{id}")
    public Response deleteTutor(@PathParam("id") String id) {

        int tutorDeleted = this.tutorService.deleteTutor(id);

        if (tutorDeleted == 1) {
            return Response
                    .status(Response.Status.CREATED)
                    .entity(true)
                    .build();
        } else if (tutorDeleted == 0) {
            return Response
                    .status(Response.Status.NOT_MODIFIED)
                    .entity(false)
                    .build();
        }
        throw new WebApplicationException(Response.Status.NOT_FOUND);
    }
}
