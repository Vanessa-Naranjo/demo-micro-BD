package com.lvnr.demo.micro.bd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lvnr.demo.micro.bd.dto.CentroTrabajoDto;
import com.lvnr.demo.micro.bd.service.CentroTrabajoService;

@RestController
@RequestMapping("/centrotrabajo")
public class CentroTrabajoController {

	@Autowired
	private CentroTrabajoService centroTrabajoService;

	@PostMapping("/crearCentroTrabajo")
	public CentroTrabajoDto crearCentroTrabajo(@RequestBody CentroTrabajoDto centroTrabajoDto) {
		return centroTrabajoService.crearCentroTrabajo(centroTrabajoDto);
	}

	@GetMapping
	public List<CentroTrabajoDto> consultarCentrosTrabajo() {
		return centroTrabajoService.consultarCentrosTrabajo();
	}

	@GetMapping("/consultarcentrotrabajoporcodigo/{codigoCentroTrabajo}")
	public CentroTrabajoDto consultarCentroTrabajoCodigo(@PathVariable Integer codigoCentroTrabajo) {
		return centroTrabajoService.consultarCentroTrabajoCodigo(codigoCentroTrabajo);
	}

	@DeleteMapping("/{codigoCentroTrabajo}")
	public String eliminarCentroTrabajo(@PathVariable Integer codigoCentroTrabajo) {
		return centroTrabajoService.eliminarCentroTrabajo(codigoCentroTrabajo);
	}

}
