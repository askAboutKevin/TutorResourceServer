package com.tutor.resource.resources;

import com.tutor.resource.model.PrivilegedUser;
import com.tutor.resource.service.privilegedUser.PrivilegedUserService;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/privileged-users")
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

        return Response
                .status(Response.Status.OK)
                .entity(privilegedUsers)
                .build();
    }

    @GET
    @Path("/{id}")
    public Response fetchPrivilegedUserById(@PathParam("id") String id) {

        PrivilegedUser privilegedUser = this.privilegedUserService.selectPrivilegedUserById(id);

        return Response
                .status(Response.Status.OK)
                .entity(privilegedUser)
                .build();
    }

//    @DELETE
//    @Path("/{id}")
//    public Response deletePrivilegedUser(@PathParam("id") String id) {
//        int privilegedUserDeleted = this.privilegedUserService.deletePrivilegedUser(id);
//
//        return Response
//                .status(Response.Status.OK)
//                .entity(privilegedUserDeleted == 1)
//                .build();
//    }
}

