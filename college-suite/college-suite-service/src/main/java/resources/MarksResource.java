package resources;

import com.google.inject.Inject;
import models.Marks;
import services.MarksService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;


@Path("/marks")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MarksResource {

    private final MarksService marksService;

    @Inject
    public MarksResource(MarksService marksService) {
        this.marksService = marksService;
    }


    @GET
    @Path("/{id}")
    public Response getMarks(@PathParam("id") UUID id)
    {
        Marks marks = marksService.getMarks(id);
        if(marks == null)
        {
            return Response.status(Response.Status.NOT_FOUND).entity("Marks with this id does not exist").build();
        }
        return Response.ok().entity(marks).build();
    }


    @PUT
    @Path("/{id}")
    public Response updateMarks(@PathParam("id") UUID Id,Marks marks) {
        Marks updatedMarks  = marksService.updateMarks(Id,marks);
        if(updatedMarks==null){
            return Response.status(Response.Status.NOT_FOUND).entity("Wrong Id provided").build();
        }
        return Response.ok().entity(updatedMarks).build();
    }
    @POST
    public Response addMarks(Marks marks) {
        /*
          Adding marks logic
          marksService.addMarks(marks);--> calling  to addmarks() of Service.
         */
        Marks createMarks = marksService.addMarks(marks);
        if(createMarks == null)
        {
            return Response.status(Response.Status.NO_CONTENT).entity("Marks creation failed: Unable to fetch JSON Object.").build();
        }

        return Response.ok().entity(createMarks).build();

    }

}
