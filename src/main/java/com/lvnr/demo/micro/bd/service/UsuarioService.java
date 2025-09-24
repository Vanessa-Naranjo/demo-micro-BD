package com.lvnr.demo.micro.bd.service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvnr.demo.micro.bd.dto.UsuarioDto;
import com.lvnr.demo.micro.bd.entity.CentroTrabajoEntity;
import com.lvnr.demo.micro.bd.entity.PersonaEntity;
import com.lvnr.demo.micro.bd.entity.UsuarioEntity;
import com.lvnr.demo.micro.bd.repository.PersonaRepository;
import com.lvnr.demo.micro.bd.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private PersonaRepository personaRepository;

	public void crearusuario(UsuarioDto usuarioDto) {
		UsuarioEntity usuarioEntity = new UsuarioEntity();
		usuarioEntity.setCodigoUsuario(usuarioDto.getCodigoUsuario());

		PersonaEntity personaEntity = new PersonaEntity();
		personaEntity.setNombres(usuarioDto.getPersonaDto().getNombres());
		personaEntity.setApellidos(usuarioDto.getPersonaDto().getApellidos());
		personaEntity.setTipoDocumento(usuarioDto.getPersonaDto().getTipoDocumento());
		personaEntity.setDocumento(usuarioDto.getPersonaDto().getDocumento());
		personaEntity.setFechaCreacion(LocalDate.now());
		personaEntity.setFechaModificacion(LocalDateTime.now());
		usuarioEntity.setPersonaEntity(personaEntity);

		CentroTrabajoEntity centroTrabajoEntity = new CentroTrabajoEntity();
		centroTrabajoEntity.setCodigo(usuarioDto.getCentroTrabajoDto().getCodigo());
		centroTrabajoEntity.setNombreCentro(usuarioDto.getCentroTrabajoDto().getNombreCentro());
		usuarioEntity.setCentroTrabajoEntity(centroTrabajoEntity);

		usuarioRepository.save(usuarioEntity);

	}

	public void crearUsuarioCuandoExistePersona(UsuarioDto usuarioDto) {
		UsuarioEntity usuarioEntity = new UsuarioEntity();
		usuarioEntity.setCodigoUsuario(usuarioDto.getCodigoUsuario());

		PersonaEntity personaEntity = personaRepository.findById(usuarioDto.getPersonaDto().getId()).get();
		usuarioEntity.setPersonaEntity(personaEntity);

		CentroTrabajoEntity centroTrabajoEntity = new CentroTrabajoEntity();
		centroTrabajoEntity.setCodigo(usuarioDto.getCentroTrabajoDto().getCodigo());
		centroTrabajoEntity.setNombreCentro(usuarioDto.getCentroTrabajoDto().getNombreCentro());
		usuarioEntity.setCentroTrabajoEntity(centroTrabajoEntity);

		usuarioRepository.save(usuarioEntity);
	}

}
