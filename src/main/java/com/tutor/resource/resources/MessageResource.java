package com.tutor.resource.resources;


import com.tutor.resource.model.Message;
import com.tutor.resource.service.message.MessageService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/message")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessageResource {

    private MessageService messageService;

    public MessageResource(MessageService messageService) {
        this.messageService = messageService;
    }

    @GET
    public Response fetchMessages(@QueryParam("senderId") String senderId, @QueryParam("receiverId") String receiverId) {

        List<Message> messages = this.messageService.selectAllMessagesToSenderFromReceiver(senderId, receiverId);
        if (messages != null) {
            return Response
                    .status(Response.Status.OK)
                    .entity(messages)
                    .build();
        }
        throw new WebApplicationException(Response.Status.NOT_FOUND);
    }

    @POST
    public Response sendMessage(Message message) {

        int messageSent = this.messageService.insertMessage(message.getSenderId(), message.getReceiverId(), message.getText());

        if (messageSent == 1) {
            return Response
                    .status(Response.Status.OK)
                    .entity(true)
                    .build();
        } else if (messageSent == 0) {
            return Response
                    .status(Response.Status.OK)
                    .entity(false)
                    .build();
        }
        throw new WebApplicationException(Response.Status.NOT_FOUND);
    }

    @DELETE
    public Response deleteEvent(@QueryParam("id") String id) {

        int deletedMessage = this.messageService.deleteMessage(id);

        if (deletedMessage == 1) {
            return Response
                    .status(Response.Status.OK)
                    .entity(true)
                    .build();
        } else if (deletedMessage == 0) {
            return Response
                    .status(Response.Status.OK)
                    .entity(false)
                    .build();
        }
        throw new WebApplicationException(Response.Status.NOT_FOUND);
    }
}
