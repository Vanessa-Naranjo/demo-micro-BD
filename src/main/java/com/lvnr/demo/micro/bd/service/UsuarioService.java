package com.lvnr.demo.micro.bd.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvnr.demo.micro.bd.dto.CentroTrabajoDto;
import com.lvnr.demo.micro.bd.dto.PersonaDto;
import com.lvnr.demo.micro.bd.dto.UsuarioDto;
import com.lvnr.demo.micro.bd.entity.CentroTrabajoEntity;
import com.lvnr.demo.micro.bd.entity.PersonaEntity;
import com.lvnr.demo.micro.bd.entity.UsuarioEntity;
import com.lvnr.demo.micro.bd.repository.CentroTrabajoRepository;
import com.lvnr.demo.micro.bd.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private CentroTrabajoRepository centroTrabajoRepository;

	public void crearusuario(UsuarioDto usuarioDto) {
		UsuarioEntity usuarioEntity = new UsuarioEntity();
		usuarioEntity.setCodigoUsuario(usuarioDto.getCodigoUsuario());

		PersonaEntity personaEntity = mapperCrearUsuario(usuarioDto);
		usuarioEntity.setPersonaEntity(personaEntity);

		CentroTrabajoEntity centroTrabajoEntity = this.centroTrabajoRepository
				.findById(usuarioDto.getCentroTrabajoDto().getId()).get();
		usuarioEntity.setCentroTrabajoEntity(centroTrabajoEntity);

		usuarioRepository.save(usuarioEntity);
	}

	public void crearUsuariov2(UsuarioDto usuarioDto, Integer centroTrabajoId) {
		UsuarioEntity usuarioEntity = new UsuarioEntity();
		usuarioEntity.setCodigoUsuario(usuarioDto.getCodigoUsuario());

		PersonaEntity personaEntity = mapperCrearUsuario(usuarioDto);
		usuarioEntity.setPersonaEntity(personaEntity);

		CentroTrabajoEntity centroTrabajoEntity = this.centroTrabajoRepository.findById(centroTrabajoId).get();
		usuarioEntity.setCentroTrabajoEntity(centroTrabajoEntity);

		usuarioRepository.save(usuarioEntity);
	}

	private PersonaEntity mapperCrearUsuario(UsuarioDto usuarioDto) {
		PersonaEntity personaEntity = new PersonaEntity();
		personaEntity.setNombres(usuarioDto.getPersonaDto().getNombres());
		personaEntity.setApellidos(usuarioDto.getPersonaDto().getApellidos());
		personaEntity.setTipoDocumento(usuarioDto.getPersonaDto().getTipoDocumento());
		personaEntity.setDocumento(usuarioDto.getPersonaDto().getDocumento());
		personaEntity.setFechaCreacion(LocalDate.now());
		personaEntity.setFechaModificacion(LocalDateTime.now());
		return personaEntity;
	}

	public List<UsuarioDto> consultarUsuarios() {
		List<UsuarioDto> usuariosDto = new ArrayList<>();

		List<UsuarioEntity> usuariosEntity = usuarioRepository.findAll();

		for (UsuarioEntity usuarioEntity : usuariosEntity) {
			UsuarioDto usuarioDto = new UsuarioDto();
			usuarioDto.setCodigoUsuario(usuarioEntity.getCodigoUsuario());

			PersonaDto personaDto = mapperPersona(usuarioEntity);
			usuarioDto.setPersonaDto(personaDto);

			CentroTrabajoDto centroTrabajoDto = mapperCentroTrabajo(usuarioEntity);
			usuarioDto.setCentroTrabajoDto(centroTrabajoDto);

			usuariosDto.add(usuarioDto);
		}

		return usuariosDto;
	}

	public UsuarioDto consultarUsuarioPorId(Integer Id) {

		UsuarioEntity usuarioEntity = this.usuarioRepository.findById(Id).get();

		UsuarioDto usuarioDto = new UsuarioDto();
		usuarioDto.setCodigoUsuario(usuarioEntity.getCodigoUsuario());

		usuarioDto.setPersonaDto(mapperPersona(usuarioEntity));

		usuarioDto.setCentroTrabajoDto(mapperCentroTrabajo(usuarioEntity));

		return usuarioDto;

	}

	public String eliminarUsuarioPorId(Integer id) {
		this.usuarioRepository.deleteById(id);
		return "Se ha eliminado el usario con ID : " + id;

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

	private CentroTrabajoDto mapperCentroTrabajo(UsuarioEntity usuarioEntity) {
		CentroTrabajoDto centroTrabajoDto = new CentroTrabajoDto();
		centroTrabajoDto.setId(usuarioEntity.getCentroTrabajoEntity().getId());
		centroTrabajoDto.setCodigoCentroTrabajo(usuarioEntity.getCentroTrabajoEntity().getCodigoCentroTrabajo());
		centroTrabajoDto.setNombreCentro(usuarioEntity.getCentroTrabajoEntity().getNombreCentro());
		centroTrabajoDto.setDireccion(usuarioEntity.getCentroTrabajoEntity().getDireccion());
		centroTrabajoDto.setCodigoPostal(usuarioEntity.getCentroTrabajoEntity().getCodigoPostal());
		return centroTrabajoDto;
	}

	public UsuarioDto consultarUsuarioPorCodigoUsuario(Integer codigoUsuario) {

		UsuarioEntity usuarioEntity = this.usuarioRepository.findByCodigoUsuario(codigoUsuario);

		UsuarioDto usuarioDto = new UsuarioDto();
		usuarioDto.setCodigoUsuario(usuarioEntity.getCodigoUsuario());

		usuarioDto.setPersonaDto(mapperPersona(usuarioEntity));

		usuarioDto.setCentroTrabajoDto(mapperCentroTrabajo(usuarioEntity));

		return usuarioDto;

	}
}