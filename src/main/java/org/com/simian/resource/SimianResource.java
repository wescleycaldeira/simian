package org.com.simian.resource;

import org.com.simian.dto.SimianRequestDTO;
import org.com.simian.service.SimianService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/simian")
public class SimianResource {

    @Inject
    SimianService simianService;

    @POST
    @Path("/validate")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response validate(SimianRequestDTO dto){
        try {
            Boolean isSimian = simianService.isSimian(dto.getDna());

            if(isSimian){
                return Response.ok().build();
            }else{
                return Response.status(Response.Status.FORBIDDEN).build();
            }

        } catch (Exception e) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage())
                    .build();
        }


    }

}
