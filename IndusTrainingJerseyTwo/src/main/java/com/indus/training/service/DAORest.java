package com.indus.training.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.indus.training.persist.exception.EmployeeDAOException;
import com.indus.training.persist.impl.EmployeeDAO;

@Path("/DAO")
public class DAORest {

	@GET
	@Path("{id}")
	public Response getUserDetails(@PathParam("id") int id) {
		EmployeeDAO DAoObj = new EmployeeDAO();
		String empDetails = null;
		try {
			empDetails = DAoObj.select(id);
		} catch (EmployeeDAOException e) {
			e.printStackTrace();
		}
		// String date = year + "/";

		return Response.status(200).entity("emplfhogyee details are : " + empDetails).build();

	}

}
