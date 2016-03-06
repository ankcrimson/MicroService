package com.resource;

import com.commands.CreateTokenCommand;
import com.commands.ListAllTokensCommand;
import com.dto.TokenRequestDTO;
import com.dto.TokenResponseDTO;
import com.services.DatabaseService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by asriv5 on 3/3/16.
 */
@Path("tokens")
public class TokenResource {

    @Inject
    DatabaseService service;

    @POST
    @Path("createToken")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createTokenAndForget(TokenRequestDTO request) {

        CreateTokenCommand command = new CreateTokenCommand(request,service);
        Future<String> commandFuture = command.queue();
        TokenResponseDTO responseDTO = new TokenResponseDTO();
        responseDTO.setCreation("Success");
        responseDTO.setMessage("Submitted");
        return Response.ok(responseDTO).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listTokens() {
        ListAllTokensCommand listAllTokensCommand = new ListAllTokensCommand(service);
        Future<List<TokenRequestDTO>> tokensFuture = listAllTokensCommand.queue();
        List<TokenRequestDTO> tokens =null;
        while(!tokensFuture.isDone())
            try{
                TimeUnit.SECONDS.sleep(1);
            }catch (InterruptedException ie) {
            }
        try {
            tokens = tokensFuture.get();
        }catch (InterruptedException|ExecutionException ie ) {}
        return Response.ok(tokens).build();
    }
}
