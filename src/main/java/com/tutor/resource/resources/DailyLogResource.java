package com.tutor.resource.resources;

import com.tutor.resource.model.DailyLog;
import com.tutor.resource.service.dailyLog.DailyLogService;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/daily-log")
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

        return Response
                .status(Response.Status.OK)
                .entity(logs)
                .build();
    }

    @POST
    @RolesAllowed({"TUTOR"})
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

        return Response
                .status(Response.Status.CREATED)
                .entity(created == 1)
                .build();
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed({"ADMINISTRATOR", "TUTOR"})
    public Response deleteDailyLog(@PathParam("id") int id) {

        int deleted = this.dailyLogService.deleteDailyLog(id);

        return Response
                .status(Response.Status.CREATED)
                .entity(deleted == 1)
                .build();
    }
}
