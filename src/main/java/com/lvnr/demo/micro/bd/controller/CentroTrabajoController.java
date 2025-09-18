package com.lvnr.demo.micro.bd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lvnr.demo.micro.bd.dto.CentroTrabajoDto;
import com.lvnr.demo.micro.bd.service.CentroTrabajoService;

@RestController
public class CentroTrabajoController {

	@Autowired
	private CentroTrabajoService centroTrabajoService;
	
	@PostMapping ("/crearCentroTrabajo")
	public CentroTrabajoDto crearCentroTrabajo(@RequestBody CentroTrabajoDto centroTrabajoDto) {
		return centroTrabajoService.crearCentroTrabajo(centroTrabajoDto);
	}
}
