package br.com.senior.hotelproj.webapi;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.senior.hotelproj.controller.CheckinController;
import br.com.senior.hotelproj.model.entity.CheckinEntity;
import br.com.senior.hotelproj.sistema.Configuracoes;

@Path("checkin")
public class CheckinApi extends CheckinController {

	public CheckinApi() throws Throwable {
		super();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<CheckinEntity> consultar() {
		System.out.println(Configuracoes.regrasNegocio);
		
		return super.listarTudo();
	}
	
}
