package com.tutor.resource.resources;

import com.tutor.resource.model.PrivilegedUser;
import com.tutor.resource.model.Tutor;
import com.tutor.resource.service.tutor.TutorService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

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


        return Response
                .status(Response.Status.OK)
                .entity(tutors)
                .build();
    }

    @GET
    @Path("/{identifier}")
    public Response fetchTutorByIdentifier(@PathParam("identifier") String identifier, @QueryParam("email") boolean email, @QueryParam("id") boolean id) {

        Tutor tutor = null;

        // If the identifier matches an email search the tutors by email
        if(email) {
            tutor = this.tutorService.selectTutorByEmail(identifier);
        }

        // If the identifier matches a user id search the tutors by user id
        if(id) {
            tutor = this.tutorService.selectTutorById(identifier);
        }

        // If it matches neither then the response will be empty/null
        return Response
                .status(Response.Status.OK)
                .entity(tutor)
                .build();

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

        return Response
                .status(Response.Status.CREATED)
                .entity(tutorCreated == 1)
                .build();
    }

    @PUT
    public Response updateTutor(Tutor tutor) {

        int tutorUpdated = this.tutorService.updateTutorUsernamePassword(
                tutor.getPassword_hash(),
                tutor.getEmail(),
                tutor.getContact_number(),
                tutor.getId()
        );

        return Response
                .status(Response.Status.OK)
                .entity(tutorUpdated == 1)
                .build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteTutor(@PathParam("id") String id) {

        int tutorDeleted = this.tutorService.deleteTutor(id);

        return Response
                .status(Response.Status.OK)
                .entity(tutorDeleted == 1)
                .build();
    }
}
