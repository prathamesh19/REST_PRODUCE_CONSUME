package com.prathamesh.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.prathamesh.entity.Customer;
import com.prathamesh.other.CustomerUtil;

@Path("/customers")
public class CustomerController {

	CustomerUtil cUtil=new CustomerUtil();
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)//convert list<country> java object to json country obj
	@Consumes(MediaType.APPLICATION_JSON)//convert list<country> java object to json country obj
	public Customer addCustomer(Customer customer){
		return cUtil.addCustomer(customer);
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)//convert list<country> java object to json country obj
	public Customer updateCustomer(Customer customer){
		return cUtil.updateCustomer(customer);
	}
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)//convert list<country> java object to json country obj
    @Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Customer getCustomer(@PathParam("id") int id){
		return  cUtil.getCustomer(id);
	}
	
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)//convert list<country> java object to json country obj
    @Consumes(MediaType.APPLICATION_JSON)
	public List<Customer> getAllCustomers(){
		return cUtil.getAllCustomers();
	}
	
	
	@DELETE
    @Produces(MediaType.APPLICATION_JSON)//convert list<country> java object to json country obj
    @Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Customer deleteCustomer(@PathParam("id") int id){
		return cUtil.deleteCustomer(id);
	}
	
	
}
