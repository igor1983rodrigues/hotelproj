package br.com.senior.hotelproj.webapi;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.senior.hotelproj.controller.HospedeController;
import br.com.senior.hotelproj.model.entity.HospedeEntity;

@Path("hospede")
public class HospedeApi extends HospedeController {

	public HospedeApi() throws Throwable {
		super();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response consultar() {
		try {
			return ok(listarTudo());
		} catch (Exception ex) {
			return badRequest(ex);
		}
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response consultarPorChave(@PathParam("id") int id) {
		try {
			return ok(getPorChave(id));
		} catch (Throwable ex) {
			return badRequest(ex);
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvar(HospedeEntity hospede) {
		try {
			
			gravar(hospede);
			
			return ok();
		} catch (Throwable ex) {
			return badRequest(ex);
		}
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response alterar(@PathParam("id") int id, HospedeEntity hospede) {
		try {
			hospede.setIdHospede(id);
			atualizar(hospede);
			
			return ok();
		} catch (Throwable ex) {
			return badRequest(ex);
		}
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletar(HospedeEntity hospede) {
		try {
			
			excluir(hospede);
			
			return ok("Registro excluído com sucesso!");
		} catch (Throwable ex) {
			return badRequest(ex);
		}
	}
}
