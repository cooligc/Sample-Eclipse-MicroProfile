package com.skc.labs;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.awt.print.Book;

@Path("employees")
@RequestScoped
public class EmployeeResource {

    @Inject
    private EmpoloyeeRepository empoloyeeRepository;


    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployee(@PathParam("id") String id) {
        return Response.ok(empoloyeeRepository.get(id)).build();
    }

    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateEmployee(@PathParam("id") String id, Employee employee) {
        return Response.ok(empoloyeeRepository.update(id, employee)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllEmployee() {
        return Response.ok(empoloyeeRepository.getAll()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createEmployee(Employee employee) {
        Employee employee1 = empoloyeeRepository.create(employee);
        return Response.created(
                UriBuilder.fromResource(this.getClass())
                        .path(employee1.getId()+"").build())
                .entity(employee1)
                .build();
    }

}
