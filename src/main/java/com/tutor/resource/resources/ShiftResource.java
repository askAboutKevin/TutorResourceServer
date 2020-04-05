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

//    @GET
//    public Response fetchShiftsInPayPeriod(@QueryParam("user") String user, @QueryParam("start") String start, @QueryParam("end") String end ) {
//
//        List<Shift> shifts = this.shiftService.getAllShiftsInPayPeriod(
//                start,
//                end,
//                user
//        );
//
//        return Response
//                .status(Response.Status.OK)
//                .entity(shifts)
//                .build();
//    }

    @POST
    public Response addShift(Shift shift) {

        int shiftAdded = this.shiftService.addShift(
                shift.getUser(),
                shift.getTime_in(),
                shift.getTime_out(),
                shift.getLunch_out(),
                shift.getLunch_in()
        );

        return Response
                .status(Response.Status.CREATED)
                .entity(shiftAdded == 1)
                .build();
    }

//    @PUT
//    @Path("/log/{id}")
//    public Response logShift(@PathParam("id") int id) {
//
//        List<Integer> list = new ArrayList<>();
//        list.add(id);
//
//        int shiftLogged = this.shiftService.updateShift(list);
//
//        return Response
//                .status(Response.Status.OK)
//                .entity(shiftLogged == 1)
//                .build();
//    }

}

