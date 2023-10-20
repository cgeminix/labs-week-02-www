package vn.edu.iuh.fit.labsweek02www.backend.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.labsweek02www.backend.entities.Employee;
import vn.edu.iuh.fit.labsweek02www.backend.services.EmployeeServices;

import java.util.List;
import java.util.Optional;

@Path("/Employees")
public class EmployeeResource {
    private EmployeeServices service = new EmployeeServices();
    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response getEmp(@PathParam("id") long id){
        Optional<Employee> emp = service.findById(id);
        if (emp.isPresent()){
            return  Response.ok(emp).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @Produces("application/json")
    public Response getAll(){
        List<Employee> list = service.getAll();
        return Response.ok(list).build();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response insert(Employee emp){
        service.insertEmp(emp);
        return Response.ok(emp).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") long id){
        if (service.deleteEmp(id))
            return Response.ok(id).build();
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
