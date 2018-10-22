package br.com.senior.hotelproj.webapi;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.senior.hotelproj.model.entity.Hospede;

@Path("hospede")
public class ApiHospede {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Hospede> consulta() {
		List<Hospede> retorno = new ArrayList<>();
		retorno.add(new Hospede());
		
		return retorno;
	}
}
