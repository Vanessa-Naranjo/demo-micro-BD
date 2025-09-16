package com.lvnr.demo.micro.bd.controller;

import java.util.List;

import com.lvnr.demo.micro.bd.dto.PersonaDto;
import com.lvnr.demo.micro.bd.service.PersonaService;

public class PersonaController {

	private PersonaService personaService;

	public List<PersonaDto> consultarPersonas(List<PersonaDto> personas) {
		personaService.consultarPersonas();
		return personas;
	}

	public PersonaDto consultarPersonaByDocumento(String tipoDocumento, String documento, PersonaDto personaDto) {
		personaService.consultarPersonaByDocumento(tipoDocumento, documento);
		return personaDto;
	}

	public void crearPersona(PersonaDto personaDto) {
		personaService.crearPersona(personaDto);
	}

	public PersonaDto actualizarPersona(String id, PersonaDto personaDto) {
		personaService.actualizarPersona(id, personaDto);
		return personaDto;
	}

	public void eliminarPersonaByDocumento(String tipoDocumento, String documento) {
		personaService.eliminarPersonaByDocumento(tipoDocumento, documento);
	}

}
