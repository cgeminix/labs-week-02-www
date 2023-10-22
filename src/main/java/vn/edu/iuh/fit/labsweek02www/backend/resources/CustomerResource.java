package vn.edu.iuh.fit.labsweek02www.backend.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.labsweek02www.backend.entities.Customer;
import vn.edu.iuh.fit.labsweek02www.backend.services.CustomerService;

import java.util.List;

@Path("/Customers")
public class CustomerResource {
    private CustomerService service = new CustomerService();
    @POST
    @Consumes("application/json")
    public Response insert(Customer cust){
        service.insertCust(cust);
        return Response.ok(cust).build();
    }
    @GET
    @Produces("application/json")
    public Response getAll(){
        List<Customer> list = service.getAll();
        return Response.ok(list).build();
    }
    @GET
    @Consumes("application/json")
    @Produces("application/json")
    public Response delete(long id){
        service.deleteCust(id);
        return Response.ok(id).build();
    }
}
