package br.com.senior.hotelproj.webapi;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.senior.hotelproj.model.entity.HospedeEntity;

@Path("hospede")
public class HospedeApi {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<HospedeEntity> consulta() {
		List<HospedeEntity> retorno = new ArrayList<>();
		retorno.add(new HospedeEntity());
		
		return retorno;
	}
}
