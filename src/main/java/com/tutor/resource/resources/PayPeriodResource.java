package com.tutor.resource.resources;

import com.tutor.resource.model.PayPeriod;
import com.tutor.resource.service.payPeriod.PayPeriodService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/pay")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PayPeriodResource {

    private PayPeriodService payPeriodService;

    public PayPeriodResource(PayPeriodService payPeriodService) {
        this.payPeriodService = payPeriodService;
    }

    @GET
    public Response fetchPayPeriods(@QueryParam("today") String today) {

        List<PayPeriod> payPeriods = this.payPeriodService.selectPayPeriodForToday(today);
        if (payPeriods != null) {
            return Response
                    .status(Response.Status.OK)
                    .entity(payPeriods)
                    .build();
        }
        throw new WebApplicationException(Response.Status.NOT_FOUND);
    }

    @POST
    public Response createPayPeriod(PayPeriod payPeriod) {

        int payPeriodCreated = this.payPeriodService.addPayPeriod(
                payPeriod.getSchool(),
                payPeriod.getStart(),
                payPeriod.getEnd(),
                payPeriod.getPayServeNo(),
                payPeriod.getComments()
        );

        if (payPeriodCreated == 1) {
            return Response
                    .status(Response.Status.CREATED)
                    .entity(true)
                    .build();
        } else if (payPeriodCreated == 0) {
            return Response
                    .status(Response.Status.OK)
                    .entity(false)
                    .build();
        }
        throw new WebApplicationException(Response.Status.NOT_MODIFIED);
    }

}
