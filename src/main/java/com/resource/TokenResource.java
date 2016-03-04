package com.resource;

import com.commands.CreateTokenCommand;
import com.dto.TokenRequestDTO;
import com.dto.TokenResponseDTO;
import com.google.inject.Inject;
import com.services.DatabaseService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.concurrent.Future;

/**
 * Created by asriv5 on 3/3/16.
 */
@Path("tokens")
public class TokenResource {

    @Inject()
    private DatabaseService service;

    @POST
    @Path("createToken")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createToken(TokenRequestDTO request) {
        System.out.println("DatabaseService: "+this.service);
        CreateTokenCommand command = new CreateTokenCommand(request);
        Future<String> commandFuture = command.queue();
        TokenResponseDTO responseDTO = new TokenResponseDTO();
        responseDTO.setCreation("Success");
        responseDTO.setMessage("Submitted");
        return Response.ok(responseDTO).build();
    }
}
