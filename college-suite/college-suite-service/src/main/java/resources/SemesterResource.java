package resources;

import com.google.inject.Inject;
import models.Semester;
import services.SemesterService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;


@Path("/semester")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SemesterResource {

    private final SemesterService semesterService;

    @Inject
    public SemesterResource(SemesterService semesterService) {
        this.semesterService = semesterService;
    }


    @POST
    public Response createSemester(Semester semester){
        Semester createdSemester=semesterService.createSemester(semester);
        return Response.ok().entity(createdSemester).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateSemester(@PathParam("id") UUID Id,Semester semester) 
    {
         Semester updatedSemester=semesterService.updateSemester(Id,semester);
         return Response.ok().entity(updatedSemester).build();
        
    }

    @GET
    @Path("/{id}")
    public Response getSemester(@PathParam("id") UUID Id)
    {
        Semester semesters = semesterService.getSemester(Id);
        return Response.ok().entity(semesters).build();

    }

}
