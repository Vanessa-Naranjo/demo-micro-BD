package com.lvnr.demo.micro.bd.entity;

import com.lvnr.demo.micro.bd.dto.CentroTrabajoDto;
import com.lvnr.demo.micro.bd.dto.PersonaDto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "USUARIO")
public class UsuarioEntity {

	
	//private PersonaDto personaDto;
	//private CentroTrabajoDto centroTrabajoDto;
	@Id
	private String codigoUsuario;

	/*public PersonaDto getPersonaDto() {
		return personaDto;
	}

	public void setPersonaDto(PersonaDto personaDto) {
		this.personaDto = personaDto;
	}

	public CentroTrabajoDto getCentroTrabajoDto() {
		return centroTrabajoDto;
	}

	public void setCentroTrabajoDto(CentroTrabajoDto centroTrabajoDto) {
		this.centroTrabajoDto = centroTrabajoDto;
	}*/

	public String getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}
}
