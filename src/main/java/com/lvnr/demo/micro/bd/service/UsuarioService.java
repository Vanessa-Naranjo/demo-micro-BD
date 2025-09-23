package com.lvnr.demo.micro.bd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvnr.demo.micro.bd.dto.UsuarioDto;
import com.lvnr.demo.micro.bd.entity.CentroTrabajoEntity;
import com.lvnr.demo.micro.bd.entity.PersonaEntity;
import com.lvnr.demo.micro.bd.entity.UsuarioEntity;
import com.lvnr.demo.micro.bd.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public void crearusuario(UsuarioDto usuarioDto) {
		UsuarioEntity usuarioEntity = new UsuarioEntity();
		usuarioEntity.setCodigoUsuario(usuarioDto.getCodigoUsuario());

		PersonaEntity personaEntity = new PersonaEntity();
		personaEntity.setNombres(usuarioDto.getPersonaDto().getNombres());
		personaEntity.setApellidos(usuarioDto.getPersonaDto().getApellidos());
		usuarioEntity.setPersonaEntity(personaEntity);

		CentroTrabajoEntity centroTrabajoEntity = new CentroTrabajoEntity();
		centroTrabajoEntity.setCodigo(usuarioDto.getCentroTrabajoDto().getCodigo());
		centroTrabajoEntity.setNombreCentro(usuarioDto.getCentroTrabajoDto().getNombreCentro());
		usuarioEntity.setCentroTrabajoEntity(centroTrabajoEntity);

		usuarioRepository.save(usuarioEntity);

	}

}
