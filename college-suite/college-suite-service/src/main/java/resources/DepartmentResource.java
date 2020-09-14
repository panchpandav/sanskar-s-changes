package resources;


import com.google.inject.Inject;
import models.Department;
import services.DepartmentService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;

@Path("/department")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DepartmentResource {

    private final DepartmentService departmentService;

    @Inject
    public DepartmentResource(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Path("/{id}")
    @GET
    public Response getDepartment(@PathParam("id") UUID id){
        Department department=departmentService.getDepartment(id);
        return Response.ok().entity(department).build();
    }

    @Path("/department")
    @POST
    public Response createDepartment(Department department) {

        Department createdDepartment = departmentService.createDepartment(department);

        return Response.ok().entity(createdDepartment).build();
    }

    @Path("/{id}")
    @PUT
    public Response updateDepartment(@PathParam("id") UUID id, Department department) {

        Department updatedDepartment = departmentService.updateDepartment(id, department);
        return Response.ok().entity(updatedDepartment).build();
    }

    @GET
    @Path("/department/{collegeId}")
    public Response getAllDepartments(@PathParam("collegeId") UUID collegeId) {
        List<Department> departmentList = departmentService.getDepartments(collegeId);
        if (departmentList.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok().entity(departmentList).build();
    }
}



