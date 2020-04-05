package com.tutor.resource.resources;


import com.tutor.resource.model.Event;
import com.tutor.resource.service.event.EventService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.List;

@Path("/event")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EventResource {

    private EventService eventService;

    public EventResource(EventService eventService) {
        this.eventService = eventService;
    }

    @GET
    public Response fetchEvents() {

        List<Event> events = this.eventService.selectAllEvents();

        return Response
                .status(Response.Status.OK)
                .entity(events)
                .build();

    }

    @GET
    @Path("/{id}")
    public Response fetchEventById(@PathParam("id") int id) {

        Event event = this.eventService.selectEventById(id);

        return Response
                .status(Response.Status.OK)
                .entity(event)
                .build();
    }

    @POST
    public Response createEvent(Event event) {

        int created = this.eventService.insertEvent(
                event.getTitle(),
                event.getStart(),
                event.getEnd(),
                event.getLocation(),
                event.getContact(),
                event.getDetails(),
                event.getReoccurring()
        );

        return Response
                .status(Response.Status.CREATED)
                .entity(created == 1)
                .build();
    }

//    @PUT
//    public Response updateEvent(@QueryParam("title") String title,
//                                @QueryParam("start") Date start,
//                                @QueryParam("end") Date end,
//                                @QueryParam("location") String location,
//                                @QueryParam("contact") String contact,
//                                @QueryParam("details") String details,
//                                @QueryParam("reoccurring") String reoccurring,
//                                @QueryParam("id") int id) {
//
//        int updated = this.eventService.updateEvent(title, start, end, location, contact, details, reoccurring, id);
//
//        return Response
//                .status(Response.Status.OK)
//                .entity(updated == 1)
//                .build();
//    }

    @DELETE
    @Path("/{id}")
    public Response deleteEvent(@PathParam("id") int id) {

        int deleted = this.eventService.deleteEvent(id);

        return Response
                .status(Response.Status.OK)
                .entity(deleted == 1)
                .build();
    }
}
