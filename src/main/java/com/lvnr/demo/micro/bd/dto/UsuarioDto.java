package com.lvnr.demo.micro.bd.dto;

public class UsuarioDto {

	private PersonaDto personaDto;
	private CentroTrabajoDto centroTrabajoDto;
	private String codigoUsuario;

	public PersonaDto getPersonaDto() {
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
	}

	public String getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

}
