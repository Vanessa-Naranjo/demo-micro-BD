package com.lvnr.demo.micro.bd.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvnr.demo.micro.bd.dto.CentroTrabajoDto;
import com.lvnr.demo.micro.bd.dto.PersonaDto;
import com.lvnr.demo.micro.bd.dto.UsuarioDto;
import com.lvnr.demo.micro.bd.entity.CentroTrabajoEntity;
import com.lvnr.demo.micro.bd.entity.UsuarioEntity;
import com.lvnr.demo.micro.bd.repository.CentroTrabajoRepository;

@Service
public class CentroTrabajoService {

	@Autowired
	private CentroTrabajoRepository centroTrabajoRepository;

	public CentroTrabajoDto crearCentroTrabajo(CentroTrabajoDto centroTrabajoDto) {
		CentroTrabajoEntity centroTrabajoEntity = new CentroTrabajoEntity();
		centroTrabajoEntity.setCodigoCentroTrabajo(centroTrabajoDto.getCodigoCentroTrabajo());
		centroTrabajoEntity.setNombreCentro(centroTrabajoDto.getNombreCentro());
		centroTrabajoEntity.setDireccion(centroTrabajoDto.getDireccion());
		centroTrabajoEntity.setCodigoPostal(centroTrabajoDto.getCodigoPostal());
		this.centroTrabajoRepository.save(centroTrabajoEntity);
		centroTrabajoDto.setId(centroTrabajoEntity.getId());
		return centroTrabajoDto;
	}

	public List<CentroTrabajoDto> consultarCentrosTrabajo() {

		List<CentroTrabajoDto> centrosdeTrabajoDto = new ArrayList<CentroTrabajoDto>();

		List<CentroTrabajoEntity> centrosdeTrabajoEntity = centroTrabajoRepository.findAll();

		for (CentroTrabajoEntity centroTrabajoEntity : centrosdeTrabajoEntity) {
			CentroTrabajoDto centroTrabajoDto = mapperCentroTrabajo(centroTrabajoEntity);

			List<UsuarioDto> usuariosDto = mapperUsuarios(centroTrabajoEntity);

			centroTrabajoDto.setUsuarios(usuariosDto);
			centrosdeTrabajoDto.add(centroTrabajoDto);
		}

		return centrosdeTrabajoDto;
	}

	public CentroTrabajoDto consultarCentroTrabajoCodigo(Integer codigoCentroTrabajo) {

		CentroTrabajoEntity centroTrabajoEntity = this.centroTrabajoRepository
				.findByCodigoCentroTrabajo(codigoCentroTrabajo);

		CentroTrabajoDto centroTrabajoDto = mapperCentroTrabajo(centroTrabajoEntity);

		List<UsuarioDto> usuariosDto = mapperUsuarios(centroTrabajoEntity);
		centroTrabajoDto.setUsuarios(usuariosDto);

		return centroTrabajoDto;

	}

	public String eliminarCentroTrabajo(Integer codigoCentroTrabajo) {
		CentroTrabajoEntity centroTrabajoEntity = this.centroTrabajoRepository
				.findByCodigoCentroTrabajo(codigoCentroTrabajo);

		if (centroTrabajoEntity != null) {
			this.centroTrabajoRepository.delete(centroTrabajoEntity);
			return "Se ha eliminado el centro de trabajo: " + codigoCentroTrabajo;

		}

		return "El codigo no existe " + codigoCentroTrabajo;

	}

	private PersonaDto mapperPersona(UsuarioEntity usuarioEntity) {
		PersonaDto personaDto = new PersonaDto();
		personaDto.setId(usuarioEntity.getPersonaEntity().getId());
		personaDto.setTipoDocumento(usuarioEntity.getPersonaEntity().getTipoDocumento());
		personaDto.setDocumento(usuarioEntity.getPersonaEntity().getDocumento());
		personaDto.setNombres(usuarioEntity.getPersonaEntity().getNombres());
		personaDto.setApellidos(usuarioEntity.getPersonaEntity().getApellidos());
		return personaDto;
	}

	private CentroTrabajoDto mapperCentroTrabajo(CentroTrabajoEntity centroTrabajoEntity) {
		CentroTrabajoDto centroTrabajoDto = new CentroTrabajoDto();
		centroTrabajoDto.setId(centroTrabajoEntity.getId());
		centroTrabajoDto.setCodigoCentroTrabajo(centroTrabajoEntity.getCodigoCentroTrabajo());
		centroTrabajoDto.setNombreCentro(centroTrabajoEntity.getNombreCentro());
		centroTrabajoDto.setDireccion(centroTrabajoEntity.getDireccion());
		centroTrabajoDto.setCodigoPostal(centroTrabajoEntity.getCodigoPostal());
		return centroTrabajoDto;
	}

	private List<UsuarioDto> mapperUsuarios(CentroTrabajoEntity centroTrabajoEntity) {
		List<UsuarioDto> usuariosDto = new ArrayList<>();

		for (UsuarioEntity usuarioEntity : centroTrabajoEntity.getUsuarios()) {
			UsuarioDto usuarioDto = new UsuarioDto();
			usuarioDto.setCodigoUsuario(usuarioEntity.getCodigoUsuario());

			PersonaDto personaDto = mapperPersona(usuarioEntity);
			usuarioDto.setPersonaDto(personaDto);

			usuariosDto.add(usuarioDto);

		}
		return usuariosDto;
	}
}
