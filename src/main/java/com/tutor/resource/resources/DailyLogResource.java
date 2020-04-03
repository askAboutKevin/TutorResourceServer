package com.tutor.resource.resources;

import com.tutor.resource.model.DailyLog;
import com.tutor.resource.service.dailyLog.DailyLogService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/log")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DailyLogResource {

    private DailyLogService dailyLogService;

    public DailyLogResource(DailyLogService dailyLogService) {
        this.dailyLogService = dailyLogService;
    }


    @GET
    @Path("/{id}")
    public Response fetchDailyLogsBydUser(@PathParam("id") String id) {

        List<DailyLog> logs = this.dailyLogService.getDailyLogsByTutor(id);

        if (logs != null) {
            return Response
                    .status(Response.Status.OK)
                    .entity(logs)
                    .build();
        }
        throw new WebApplicationException(Response.Status.NOT_FOUND);
    }

    @POST
    public Response postDailyLog(DailyLog dailyLog) {

        int created = this.dailyLogService.createDailyLog(
                dailyLog.getTutorId(),
                dailyLog.getTutorName(),
                dailyLog.getDateOfTutoring(),
                dailyLog.getTimeInSchool(),
                dailyLog.getNumOfIndividualStudentsTutored(),
                dailyLog.getNumOfStudentGroupsTutored(),
                dailyLog.getTuteeFirstName(),
                dailyLog.getTuteeLastName(),
                dailyLog.getTuteeId(),
                dailyLog.getTimeSpentOneOnOne(),
                dailyLog.getTimeSpentSmallGroup(),
                dailyLog.getSessionMaterial()
        );

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

    @DELETE
    @Path("/{id}")
    public Response deleteDailyLog(@PathParam("id") int id) {

        int created = this.dailyLogService.deleteDailyLog(id);

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
}
