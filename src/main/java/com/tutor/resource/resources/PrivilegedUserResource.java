package com.tutor.resource.resources;

import com.tutor.resource.model.PrivilegedUser;
import com.tutor.resource.service.privilegedUser.PrivilegedUserService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/privileged")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PrivilegedUserResource {

    private PrivilegedUserService privilegedUserService;

    public PrivilegedUserResource(PrivilegedUserService privilegedUserService) {
        this.privilegedUserService = privilegedUserService;
    }

    @GET
    public Response fetchPrivilegedUsers() {

        List<PrivilegedUser> privilegedUsers = this.privilegedUserService.selectAllPrivilegedUsers();

        if (privilegedUsers != null) {
            return Response
                    .status(Response.Status.OK)
                    .entity(privilegedUsers)
                    .build();
        }
        throw new WebApplicationException(Response.Status.NOT_FOUND);
    }

    @GET
    @Path("/{id}")
    public Response fetchPrivilegedUserById(@PathParam("id") String id) {

        PrivilegedUser privilegedUser = this.privilegedUserService.selectPrivilegedUserById(id);

        if (privilegedUser != null) {
            return Response
                    .status(Response.Status.OK)
                    .entity(privilegedUser)
                    .build();
        }
        throw new WebApplicationException(Response.Status.NOT_FOUND);
    }
}

