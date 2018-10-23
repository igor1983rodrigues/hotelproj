package br.com.senior.hotelproj.controller;

import java.util.HashMap;

import javax.ws.rs.core.Response;

public abstract class BaseApiController {

	protected Response ok() {
		return ok("Registro Salvo com sucesso!");
	}
	
	protected Response ok(String strMensagem) {
		HashMap<Object, Object> retornar = new HashMap<>();
		
		retornar.put("message", strMensagem);
		
		return Response.status(200)
				.entity(retornar)
				.build();		
	}
	
	protected <T extends Object> Response ok(T model) {
		return Response.status(200)
				.entity(model)
				.build();		
	}

	protected <T extends Throwable> Response badRequest(T ex) {
		return Response.status(200)
				.entity(ex)
				.build();		
	}
}
