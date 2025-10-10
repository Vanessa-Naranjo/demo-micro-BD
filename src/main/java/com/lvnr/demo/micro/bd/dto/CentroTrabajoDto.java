package com.lvnr.demo.micro.bd.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class CentroTrabajoDto {

	private Integer id;
	private Integer codigoCentroTrabajo;
	private String nombreCentro;
	private String direccion;
	private Integer codigoPostal;
	private List<UsuarioDto> usuarios;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCodigoCentroTrabajo() {
		return codigoCentroTrabajo;
	}

	public void setCodigoCentroTrabajo(Integer codigoCentroTrabajo) {
		this.codigoCentroTrabajo = codigoCentroTrabajo;
	}

	public String getNombreCentro() {
		return nombreCentro;
	}

	public void setNombreCentro(String nombreCentro) {
		this.nombreCentro = nombreCentro;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(Integer codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public List<UsuarioDto> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<UsuarioDto> usuarios) {
		this.usuarios = usuarios;
	}

}
