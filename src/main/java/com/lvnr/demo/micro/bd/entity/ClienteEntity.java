package com.lvnr.demo.micro.bd.entity;

import com.lvnr.demo.micro.bd.dto.PersonaDto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CLIENTE")
public class ClienteEntity {

	
	//private PersonaDto personaDto;
	@Id
	private String email;
	private String celular;

	/*public PersonaDto getPersonaDto() {
		return personaDto;
	}

	public void setPersonaDto(PersonaDto personaDto) {
		this.personaDto = personaDto;
	}*/

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

}
