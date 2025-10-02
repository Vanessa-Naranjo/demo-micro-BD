package com.lvnr.demo.micro.bd.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvnr.demo.micro.bd.dto.PersonaDto;
import com.lvnr.demo.micro.bd.entity.PersonaEntity;
import com.lvnr.demo.micro.bd.repository.PersonaRepository;

@Service
public class PersonaService {

	private List<PersonaDto> personas;
	@Autowired
	private PersonaRepository personaRepository;

	public List<PersonaDto> consultarPersonas() {
		return personas;
	}

	public PersonaDto consultarPersonaByDocumento(String tipoDocumento, String documento) {
		for (PersonaDto personaDto : personas) {
			if (personaDto.getTipoDocumento().equals(tipoDocumento) && personaDto.getDocumento().equals(documento)) {
				return personaDto;
			}
		}
		return null;
	}

	public PersonaDto crearPersona(PersonaDto personaDto) {
		PersonaEntity personaEntity = new PersonaEntity();
		personaEntity.setTipoDocumento(personaDto.getTipoDocumento());
		personaEntity.setDocumento(personaDto.getDocumento());
		personaEntity.setNombres(personaDto.getNombres());
		personaEntity.setApellidos(personaDto.getApellidos());
		personaEntity.setFechaCreacion(LocalDate.now());
		personaEntity.setFechaModificacion(LocalDateTime.now());

		this.personaRepository.save(personaEntity);

		personaDto.setId(personaEntity.getId());
		return personaDto;
	}

	public PersonaDto actualizarPersona(String id, PersonaDto personaDto) {
		PersonaEntity personaEntity = new PersonaEntity();
		personaEntity.setTipoDocumento(personaDto.getTipoDocumento());
		personaEntity.setDocumento(personaDto.getDocumento());
		personaEntity.setNombres(personaDto.getNombres());
		personaEntity.setApellidos(personaDto.getApellidos());
		personas.add(personaDto);
		return personaDto;
	}

	public String eliminarPersonaByDocumento(String tipoDocumento, String documento) {
		PersonaDto personaDto = this.consultarPersonaByDocumento(tipoDocumento, documento);
		if (personaDto == null) {
			return "La persona existe" + documento;
		} else {
			this.personas.remove(personaDto);
		}
		return "Se ha eliminado la Persona";
	}

}
