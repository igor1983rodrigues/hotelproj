package br.com.senior.hotelproj.webapi;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.senior.hotelproj.model.entity.Checkin;

@Path("checkin")
public class ApiCheckin {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Checkin[] consulta() {
		return new Checkin[] {new Checkin()};
	}
	
}
