package com.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;
import java.util.HashMap;


/**
 * Created by ankcrimson on 3/2/16.
 */
@Path("/about")
public class About {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response about() {
        Map<String,String> aboutResponse = new HashMap<>();
        aboutResponse.put("name","MicroService");
        aboutResponse.put("version","v1");
        return Response.ok(aboutResponse).build();
    }

}
