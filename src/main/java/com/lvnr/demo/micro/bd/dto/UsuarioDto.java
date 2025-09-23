package com.lvnr.demo.micro.bd.dto;

public class UsuarioDto {

	private PersonaDto personaDto;
	private CentroTrabajoDto centroTrabajoDto;
	private Integer codigoUsuario;

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

	public Integer getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(Integer codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

}
