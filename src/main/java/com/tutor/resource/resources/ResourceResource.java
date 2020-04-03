package com.tutor.resource.resources;


import com.tutor.resource.model.PartnerUniversity;
import com.tutor.resource.model.Resource;
import com.tutor.resource.service.resource.ResourceService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/resource")
@Produces(MediaType.APPLICATION_JSON)
@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_HTML})
public class ResourceResource {

    private ResourceService resourceService;

    public ResourceResource(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @GET
    public Response fetchResources() {

        List<Resource> resources = this.resourceService.selectAllResources();
        if (resources != null) {
            return Response
                    .status(Response.Status.OK)
                    .entity(resources)
                    .build();
        }
        throw new WebApplicationException(Response.Status.NOT_FOUND);
    }

    @GET
    @Path("/{id}")
    public Response fetchResourceById(@PathParam("id") int id) {

        Resource resource = this.resourceService.selectResourceById(id);
        if (resource != null) {
            return Response
                    .status(Response.Status.OK)
                    .entity(resource)
                    .build();
        }
        throw new WebApplicationException(Response.Status.NOT_FOUND);
    }
}
