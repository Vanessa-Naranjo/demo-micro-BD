package com.lvnr.demo.micro.bd.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "USUARIOS")
public class UsuarioEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(unique = true)
	private Integer codigoUsuario;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "PERSONA_ID", referencedColumnName = "ID")
	private PersonaEntity personaEntity;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "CENTRO_ID", referencedColumnName = "ID")
	private CentroTrabajoEntity centroTrabajoEntity;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(Integer codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public PersonaEntity getPersonaEntity() {
		return personaEntity;
	}

	public void setPersonaEntity(PersonaEntity personaEntity) {
		this.personaEntity = personaEntity;
	}

	public CentroTrabajoEntity getCentroTrabajoEntity() {
		return centroTrabajoEntity;
	}

	public void setCentroTrabajoEntity(CentroTrabajoEntity centroTrabajoEntity) {
		this.centroTrabajoEntity = centroTrabajoEntity;
	}

}
