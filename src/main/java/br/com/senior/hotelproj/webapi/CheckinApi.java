package br.com.senior.hotelproj.webapi;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
	public Response consultar() {
		try {
			System.out.println(Configuracoes.regrasNegocio);
			return ok(super.listarTudo());
		} catch (Throwable ex) {
			return badRequest(ex);
		}
	}
	
	@GET
	@Path("/emaberto")
	@Produces(MediaType.APPLICATION_JSON)
	public Response consultarCheckinEmAberto() {
		try {
			return ok(listarEmAberto());
		} catch (Throwable ex) {
			return badRequest(ex);
		}
	}

//	@GET
//	@Path("/documento/{documento}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response consultarPorDocumento(@DefaultValue("") @PathParam("documento") String documento) {
//		try {
//			return ok(listarPorDocumento(documento));
//		} catch (Throwable ex) {
//			return badRequest(ex);
//		}
//	}

	@POST
	@Path("/{idHospede}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvar(@PathParam("idHospede") int idHospede, CheckinEntity checkin) {
		try {
			
			checkin.setIdHospede(idHospede);
			
			gravar(checkin);
			
			return ok();
		} catch (Throwable ex) {
			return badRequest(ex);
		}
	}

	@POST
	@Path("/documento/{documento}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarPorDocumento(@PathParam("documento") String documento, CheckinEntity checkin) {
		try {
			
			gravarPorDocumento(documento, checkin);
			
			return ok();
		} catch (Throwable ex) {
			return badRequest(ex);
		}
	}

	@PUT
	@Path("/{idHospede}/encerrar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response encerrar(@PathParam("idHospede") int idHospede) {
		try {
			
			encerrarCheckin(idHospede);
			
			return ok("Checkin encerrado com sucesso!");
		} catch (Throwable ex) {
			return badRequest(ex);
		}
	}

	@PUT
	@Path("/encerrar/{documento}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response encerrarPorDocumento(@PathParam("documento") String documento) {
		try {
			encerrarCheckin(documento);
			
			return ok("Checkin encerrado com sucesso!");
		} catch (Throwable ex) {
			return badRequest(ex);
		}
	}

//	@DELETE
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response deletar(HospedeEntity hospede) {
//		try {
//			
//			excluir(hospede);
//			
//			return ok("Registro excluído com sucesso!");
//		} catch (Throwable ex) {
//			return badRequest(ex);
//		}
//	}
}
