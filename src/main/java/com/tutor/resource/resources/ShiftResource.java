package com.tutor.resource.resources;

import com.tutor.resource.model.Shift;
import com.tutor.resource.service.shift.ShiftService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/shift")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ShiftResource {

    private ShiftService shiftService;

    public ShiftResource(ShiftService shiftService) {
        this.shiftService = shiftService;
    }

    @GET
    @Path("/{id}")
    public Response fetchShiftsForUser(@PathParam("id") String id) {

        List<Shift> shifts = this.shiftService.getAllShiftsForUser(id);

        return Response
                .status(Response.Status.OK)
                .entity(shifts)
                .build();
    }

    @GET
    public Response fetchShiftsInPayPeriod(@QueryParam("user") String user, @QueryParam("start") String start, @QueryParam("end") String end ) {

        List<Shift> shifts = this.shiftService.getAllShiftsInPayPeriod(
                start,
                end,
                user
        );

        return Response
                .status(Response.Status.OK)
                .entity(shifts)
                .build();
    }

    @POST
    public Response addShift(Shift shift) {

        int shiftAdded = this.shiftService.addShift(
                shift.getUser(),
                shift.getTime_in(),
                shift.getTime_out(),
                shift.getLunch_out(),
                shift.getLunch_in()
        );

        if (shiftAdded == 1) {
            return Response
                    .status(Response.Status.OK)
                    .entity(true)
                    .build();
        } else if (shiftAdded == 0) {
            return Response
                    .status(Response.Status.OK)
                    .entity(false)
                    .build();
        }
        throw new WebApplicationException(Response.Status.NOT_FOUND);
    }

    @PUT
    @Path("/{id}")
    public Response logShift(@PathParam("id") int id) {

        List<Integer> list = new ArrayList<>();
        list.add(id);

        int shiftLogged = this.shiftService.updateShift(list);

        if (shiftLogged == 1) {
            return Response
                    .status(Response.Status.OK)
                    .entity(true)
                    .build();
        } else if (shiftLogged == 0) {
            return Response
                    .status(Response.Status.OK)
                    .entity(false)
                    .build();
        }
        throw new WebApplicationException(Response.Status.NOT_FOUND);
    }

}

