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
import com.lvnr.demo.micro.bd.repository.PersonaRepository;
import com.lvnr.demo.micro.bd.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private PersonaRepository personaRepository;
	@Autowired
	private CentroTrabajoRepository centroTrabajoRepository;

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

		CentroTrabajoEntity centroTrabajoEntity = this.centroTrabajoRepository
				.findById(usuarioDto.getCentroTrabajoDto().getId()).get();
		usuarioEntity.setCentroTrabajoEntity(centroTrabajoEntity);

		usuarioRepository.save(usuarioEntity);
	}

	public void crearUsuariov2(UsuarioDto usuarioDto, Integer centroTrabajoId) {
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

		CentroTrabajoEntity centroTrabajoEntity = this.centroTrabajoRepository.findById(centroTrabajoId).get();
		usuarioEntity.setCentroTrabajoEntity(centroTrabajoEntity);

		usuarioRepository.save(usuarioEntity);
	}

	public List<UsuarioDto> consultarUsuarios() {
		List<UsuarioDto> usuariosDto = new ArrayList<>();

		List<UsuarioEntity> usuariosEntity = usuarioRepository.findAll();

		for (UsuarioEntity usuarioEntity : usuariosEntity) {
			UsuarioDto usuarioDto = new UsuarioDto();
			usuarioDto.setCodigoUsuario(usuarioEntity.getCodigoUsuario());
			// centroTrabajoDto.getUsuarios().add(usuarioDto);

			PersonaDto personaDto = new PersonaDto();
			personaDto.setId(usuarioEntity.getPersonaEntity().getId());
			personaDto.setTipoDocumento(usuarioEntity.getPersonaEntity().getTipoDocumento());
			personaDto.setDocumento(usuarioEntity.getPersonaEntity().getDocumento());
			personaDto.setNombres(usuarioEntity.getPersonaEntity().getNombres());
			personaDto.setApellidos(usuarioEntity.getPersonaEntity().getApellidos());
			usuarioDto.setPersonaDto(personaDto);

			CentroTrabajoDto centroTrabajoDto = new CentroTrabajoDto();
			centroTrabajoDto.setId(usuarioEntity.getCentroTrabajoEntity().getId());
			centroTrabajoDto.setCodigo(usuarioEntity.getCentroTrabajoEntity().getCodigo());
			centroTrabajoDto.setNombreCentro(usuarioEntity.getCentroTrabajoEntity().getNombreCentro());
			centroTrabajoDto.setDireccion(usuarioEntity.getCentroTrabajoEntity().getDireccion());
			centroTrabajoDto.setCodigoPostal(usuarioEntity.getCentroTrabajoEntity().getCodigoPostal());
			usuarioDto.setCentroTrabajoDto(centroTrabajoDto);

			usuariosDto.add(usuarioDto);
		}

		return usuariosDto;
	}

	public UsuarioDto consultarUsuarioPorId(Integer Id) {

		List<UsuarioDto> usuariosDto = new ArrayList<>();

		List<UsuarioEntity> usuariosEntity = usuarioRepository.findAll();

		for (UsuarioEntity usuarioEntity : usuariosEntity) {
			usuarioEntity=this.usuarioRepository.findById(Id).get();			
			
				UsuarioDto usuarioDto = new UsuarioDto();
				usuarioDto.setCodigoUsuario(usuarioEntity.getCodigoUsuario());

				PersonaDto personaDto = new PersonaDto();
				personaDto.setId(usuarioEntity.getPersonaEntity().getId());
				personaDto.setTipoDocumento(usuarioEntity.getPersonaEntity().getTipoDocumento());
				personaDto.setDocumento(usuarioEntity.getPersonaEntity().getDocumento());
				personaDto.setNombres(usuarioEntity.getPersonaEntity().getNombres());
				personaDto.setApellidos(usuarioEntity.getPersonaEntity().getApellidos());
				usuarioDto.setPersonaDto(personaDto);

				CentroTrabajoDto centroTrabajoDto = new CentroTrabajoDto();
				centroTrabajoDto.setId(usuarioEntity.getCentroTrabajoEntity().getId());
				centroTrabajoDto.setCodigo(usuarioEntity.getCentroTrabajoEntity().getCodigo());
				centroTrabajoDto.setNombreCentro(usuarioEntity.getCentroTrabajoEntity().getNombreCentro());
				centroTrabajoDto.setDireccion(usuarioEntity.getCentroTrabajoEntity().getDireccion());
				centroTrabajoDto.setCodigoPostal(usuarioEntity.getCentroTrabajoEntity().getCodigoPostal());
				usuarioDto.setCentroTrabajoDto(centroTrabajoDto);

				usuariosDto.add(usuarioDto);
				return usuarioDto;
			}
		return null;
	}
}