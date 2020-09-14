package resources;

import com.google.inject.Inject;
import services.SubjectService;
import models.Subject;
import java.util.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;

import javax.ws.rs.PathParam;


@Path("/subject")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class SubjectResource {


    private final SubjectService subjectService;

    @Inject
    public SubjectResource(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GET
    @Path("/{id}")
    public Response getSubject(@PathParam("id") UUID id)
    {
        Subject subject = subjectService.getSubject(id);
        return Response.ok().entity(subject).build();

    }


    @Path("/subject")
    @POST
    public Response createSubject(Subject subject) {
        Subject createdSubject = subjectService.createSubject(subject);
        return Response.ok().entity(createdSubject).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateSubject(@PathParam("id") UUID subjectId,Subject subject)
    {
        Subject updatedSubject = subjectService.updateSubject(subjectId,subject);
        return Response.ok().entity(updatedSubject).build();
    }

}




