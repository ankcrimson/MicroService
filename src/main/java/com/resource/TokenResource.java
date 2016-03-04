package com.resource;

import com.models.TokenRequestDTO;
import com.models.TokenResponseDTO;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by asriv5 on 3/3/16.
 */
@Path("tokens")
public class TokenResource {


    @POST
    @Path("createToken")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createToken(TokenRequestDTO request) {

        TokenResponseDTO responseDTO = new TokenResponseDTO();
        responseDTO.setCreation("Success");
        responseDTO.setMessage("Submitted");
        return Response.ok(responseDTO).build();
    }
}
