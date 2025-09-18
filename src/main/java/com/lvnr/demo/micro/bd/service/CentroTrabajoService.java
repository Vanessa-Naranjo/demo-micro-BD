package com.lvnr.demo.micro.bd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvnr.demo.micro.bd.dto.CentroTrabajoDto;
import com.lvnr.demo.micro.bd.entity.CentroTrabajoEntity;
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

}
