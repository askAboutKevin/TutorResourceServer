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
        if(events != null) {
            return Response
                    .status(Response.Status.OK)
                    .entity(events)
                    .build();
        }
        throw new WebApplicationException(Response.Status.NOT_FOUND);
    }

    @GET
    @Path("/{id}")
    public Response fetchEventById(@PathParam("id") int id) {

        Event event = this.eventService.selectEventById(id);
        if(event != null) {
            return Response
                    .status(Response.Status.OK)
                    .entity(event)
                    .build();
        }
        throw new WebApplicationException(Response.Status.NOT_FOUND);
    }

    @POST
    public Response createDepartment(@QueryParam("title") String title,
                                     @QueryParam("start") Date start,
                                     @QueryParam("end") Date end,
                                     @QueryParam("location") String location,
                                     @QueryParam("contact") String contact,
                                     @QueryParam("details") String details,
                                     @QueryParam("reoccurring") String reoccurring) {

        int created = this.eventService.insertEvent(title, start, end, location, contact, details, reoccurring);

        if(created == 1) {
            return Response
                    .status(Response.Status.OK)
                    .entity(true)
                    .build();
        }
        else if(created == 0) {
            return Response
                    .status(Response.Status.OK)
                    .entity(false)
                    .build();
        }
        throw new WebApplicationException(Response.Status.NOT_FOUND);
    }

    @PUT
    public Response updateEvent(@QueryParam("title") String title,
                                @QueryParam("start") Date start,
                                @QueryParam("end") Date end,
                                @QueryParam("location") String location,
                                @QueryParam("contact") String contact,
                                @QueryParam("details") String details,
                                @QueryParam("reoccurring") String reoccurring,
                                @QueryParam("id") int id) {

        int updated = this.eventService.updateEvent(title, start, end, location, contact, details, reoccurring, id);

        if(updated == 1) {
            return Response
                    .status(Response.Status.OK)
                    .entity(true)
                    .build();
        }
        else if(updated == 0) {
            return Response
                    .status(Response.Status.OK)
                    .entity(false)
                    .build();
        }
        throw new WebApplicationException(Response.Status.NOT_FOUND);
    }

    @DELETE
    public Response deleteEvent(@QueryParam("id") int id) {

        int deleted = this.eventService.deleteEvent(id);

        if(deleted == 1) {
            return Response
                    .status(Response.Status.OK)
                    .entity(true)
                    .build();
        }
        else if(deleted == 0) {
            return Response
                    .status(Response.Status.OK)
                    .entity(false)
                    .build();
        }
        throw new WebApplicationException(Response.Status.NOT_FOUND);
    }
}
