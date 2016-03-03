package com.resource;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import java.util.Map;
import java.util.HashMap;


/**
 * Created by ankcrimson on 3/2/16.
 */
@Path("/about")
@ApplicationPath("test")
public class About {

    @GET
    @Produces("application/json")
    public Response about() {
        Map<String,Object> aboutResponse = new HashMap<>();
        aboutResponse.put("name","MicroService");
        aboutResponse.put("version","v1");
        GenericEntity<Map<String , Object>> entity = new GenericEntity<Map<String,Object>>(aboutResponse){};
        return Response.ok(entity).build();
    }

}
