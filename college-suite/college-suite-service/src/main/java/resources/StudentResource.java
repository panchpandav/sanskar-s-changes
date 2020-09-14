package resources;

import com.google.inject.Inject;
import models.Student;
import services.StudentService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.UUID;

@Path("/students")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StudentResource {

    private final StudentService studentService;

    @Inject
    public StudentResource(StudentService studentService) {
        this.studentService = studentService;
    }

    @POST
    public Response createStudent(Student student) {
        Student newStudent = studentService.createStudent(student);
        return Response.ok().entity(newStudent).build();
    }

    @GET
    @Path("/studentsByDepartment/{departmentId}") // List all Students for Each Department.
    public Response getAllStudents(@PathParam("departmentId") UUID departmentId) {
        List<Student> studentList = studentService.getStudentsByDepartment(departmentId);
        if (studentList.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok().entity(studentList).build();
    }

    @GET
    @Path("/{id}")
    public Response getStudent(@PathParam("id") UUID id)
    {
        Student student = studentService.getStudent(id);
        return Response.ok().entity(student).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateStudent( @PathParam("id") UUID studentId, Student student ) {
        Student studentUpdated = studentService.updateStudentById(studentId, student);
        return Response.ok().entity(studentUpdated).build();
        }
}
