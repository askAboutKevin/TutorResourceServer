package com.tutor.resource.resources;

import com.tutor.resource.model.PartnerUniversity;
import com.tutor.resource.service.partnerUniversity.PartnerUniversityService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/university")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PartnerUniversityResource {

    private PartnerUniversityService partnerUniversityService;

    public PartnerUniversityResource(PartnerUniversityService partnerUniversityService) {
        this.partnerUniversityService = partnerUniversityService;
    }

    @GET
    public Response fetchPartnerUniversities() {

        List<PartnerUniversity> partnerUniversities = this.partnerUniversityService.selectAllPartnerUniversities();
        if (partnerUniversities != null) {
            return Response
                    .status(Response.Status.OK)
                    .entity(partnerUniversities)
                    .build();
        }
        throw new WebApplicationException(Response.Status.NOT_FOUND);
    }

    @GET
    @Path("/{id}")
    public Response fetchPartnerUniversityById(@PathParam("id") int id) {

        PartnerUniversity partnerUniversity = this.partnerUniversityService.selectPartnerUniversityById(id);
        if (partnerUniversity != null) {
            return Response
                    .status(Response.Status.OK)
                    .entity(partnerUniversity)
                    .build();
        }
        throw new WebApplicationException(Response.Status.NOT_FOUND);
    }

    @POST
    public Response addPartnerUniversity(PartnerUniversity partnerUniversity) {

        int partnerUniversityCreated = this.partnerUniversityService.insertPartnerUniversity(
                partnerUniversity.getName(),
                partnerUniversity.getStreet_address(),
                partnerUniversity.getCity(),
                partnerUniversity.getState(),
                partnerUniversity.getZip_code()
        );

        if (partnerUniversityCreated == 1) {
            return Response
                    .status(Response.Status.CREATED)
                    .entity(true)
                    .build();
        } else if (partnerUniversityCreated == 0) {
            return Response
                    .status(Response.Status.OK)
                    .entity(false)
                    .build();
        }
        throw new WebApplicationException(Response.Status.NOT_FOUND);
    }

    @PUT
    @Path("/{id}")
    public Response updatePartnerUniversity(PartnerUniversity partnerUniversity, @QueryParam("id") int id) {

        int partnerUniversityUpdated = this.partnerUniversityService.updatePartnerUniversity(
                partnerUniversity.getName(),
                partnerUniversity.getStreet_address(),
                partnerUniversity.getCity(),
                partnerUniversity.getState(),
                partnerUniversity.getZip_code(),
                id
        );

        if (partnerUniversityUpdated == 1) {
            return Response
                    .status(Response.Status.ACCEPTED)
                    .entity(true)
                    .build();
        } else if (partnerUniversityUpdated == 0) {
            return Response
                    .status(Response.Status.OK)
                    .entity(false)
                    .build();
        }
        throw new WebApplicationException(Response.Status.NOT_FOUND);
    }


    @DELETE
    public Response deletePartnerUniversity(@QueryParam("id") int id) {

        int deletedPartnerUniversity = this.partnerUniversityService.deletePartnerUniversity(id);

        if (deletedPartnerUniversity == 1) {
            return Response
                    .status(Response.Status.ACCEPTED)
                    .entity(true)
                    .build();
        } else if (deletedPartnerUniversity == 0) {
            return Response
                    .status(Response.Status.OK)
                    .entity(false)
                    .build();
        }
        throw new WebApplicationException(Response.Status.NOT_FOUND);
    }
}