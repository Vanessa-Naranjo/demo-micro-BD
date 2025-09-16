package com.lvnr.demo.micro.bd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lvnr.demo.micro.bd.dto.PersonaDto;
import com.lvnr.demo.micro.bd.service.PersonaService;

@RestController
public class PersonaController {

	@Autowired
	private PersonaService personaService;

	@GetMapping
	public List<PersonaDto> consultarPersonas() {
		return personaService.consultarPersonas();

	}

	@GetMapping("/consultarpordocumento")
	public PersonaDto consultarPersonaByDocumento(@RequestParam String tipoDocumento, @RequestParam String documento) {
		return personaService.consultarPersonaByDocumento(tipoDocumento, documento);

	}

	@PostMapping
	public PersonaDto crearPersona(@RequestBody PersonaDto personaDto) {
		return personaService.crearPersona(personaDto);
	}

	@PutMapping("/{id}")
	public PersonaDto actualizarPersona(@PathVariable String id, @RequestBody PersonaDto personaDto) {
		return personaService.actualizarPersona(id, personaDto);

	}

	@DeleteMapping("/{tipoDcumento}/{documento}")
	public void eliminarPersonaByDocumento(@PathVariable String tipoDocumento, @PathVariable String documento) {
		personaService.eliminarPersonaByDocumento(tipoDocumento, documento);
	}

}
