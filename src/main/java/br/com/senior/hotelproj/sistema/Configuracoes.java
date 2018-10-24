package br.com.senior.hotelproj.sistema;

import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.senior.hotelproj.model.entity.RegrasEntity;

public class Configuracoes {
	public static RegrasEntity regrasNegocio;
	static {
		try {
			InputStream streamValor = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("/resources/regras.json");
			ObjectMapper objectMapper = new ObjectMapper();
			regrasNegocio = objectMapper.readValue(streamValor, RegrasEntity.class);
		} catch (IOException e) {
			regrasNegocio = new RegrasEntity();
			e.printStackTrace();
		}
	}
}
