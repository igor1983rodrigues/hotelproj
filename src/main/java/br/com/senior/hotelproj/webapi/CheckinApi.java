package br.com.senior.hotelproj.webapi;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.senior.hotelproj.model.entity.CheckinEntity;

@Path("checkin")
public class CheckinApi {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public CheckinEntity[] consulta() {
		return new CheckinEntity[] {new CheckinEntity()};
	}
	
}
