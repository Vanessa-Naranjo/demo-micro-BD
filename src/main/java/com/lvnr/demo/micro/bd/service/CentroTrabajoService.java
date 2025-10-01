package com.lvnr.demo.micro.bd.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvnr.demo.micro.bd.dto.CentroTrabajoDto;
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
		centroTrabajoEntity.setCodigo(centroTrabajoDto.getCodigo());
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
			CentroTrabajoDto centroTrabajoDto = new CentroTrabajoDto();
			centroTrabajoDto.setId(centroTrabajoEntity.getId());
			centroTrabajoDto.setCodigo(centroTrabajoEntity.getCodigo());
			centroTrabajoDto.setNombreCentro(centroTrabajoEntity.getNombreCentro());
			centroTrabajoDto.setDireccion(centroTrabajoEntity.getDireccion());
			centroTrabajoDto.setCodigoPostal(centroTrabajoEntity.getCodigoPostal());
			
			//centroTrabajoDto.setUsarios(new ArrayList<>());
			List<UsuarioDto> usuariosDto =new ArrayList<>();
			
			for (UsuarioEntity usuarioEntity : centroTrabajoEntity.getUsuarios()) {
				UsuarioDto usuarioDto = new UsuarioDto();
				usuarioDto.setCodigoUsuario(usuarioEntity.getCodigoUsuario());
				//centroTrabajoDto.getUsarios().add(usuarioDto);
				
				usuariosDto.add(usuarioDto);
			}
			centroTrabajoDto.setUsarios(usuariosDto);
			centrosdeTrabajoDto.add(centroTrabajoDto);
		}

		return centrosdeTrabajoDto;
	}

}
