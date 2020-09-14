package resources;

import com.google.inject.Inject;
import services.TeacherService;
import models.Teacher;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;
import java.util.UUID;

@Path("/teacher")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TeacherResource {

    private final TeacherService teacherService;

    @Inject
    public TeacherResource(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @POST
    public Response createTeacher(Teacher teacher)
    {
    	Teacher createdTeacher = teacherService.createTeacher(teacher);
    	return Response.ok().entity(createdTeacher).build();
    }
    
    @GET
    @Path("/{id}")
    public Response getTeacher(@PathParam("id") UUID id)
    {
        Teacher teachers = teacherService.getTeacher(id);
        return Response.ok().entity(teachers).build();
    }

    @GET
    @Path("/teachersByDepartment/{id}")
    public Response teachersByID(@PathParam("id") UUID departmentId){
        List<Teacher> teacherList = teacherService.getTeachersByDepartment(departmentId);
        if (teacherList.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok().entity(teacherList).build();
    }
    
    @PUT
    @Path("/{id}")
    public Response updateTeacher(@PathParam("id") UUID teacherId, Teacher teacher)
    {
        Teacher updateTeacher = teacherService.updateTeacher(teacherId, teacher);
        return Response.ok().entity(updateTeacher).build();
    }
}
