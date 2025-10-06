package com.lvnr.demo.micro.bd.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lvnr.demo.micro.bd.dto.UsuarioDto;
import com.lvnr.demo.micro.bd.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	private UsuarioService usuarioService;

	public UsuarioController(UsuarioService usuarioService) {
		super();
		this.usuarioService = usuarioService;
	}

	@PostMapping
	public void crearUsuario(@RequestBody UsuarioDto usuarioDto) {
		usuarioService.crearusuario(usuarioDto);
	}

	@PostMapping("/centro-trabajo/{centroTrabajoId}")
	public void crearUsuariov2(@RequestBody UsuarioDto usuarioDto, @PathVariable Integer centroTrabajoId) {
		usuarioService.crearUsuariov2(usuarioDto, centroTrabajoId);
	}

	@GetMapping
	public List<UsuarioDto> consultarUsuarios() {
		return usuarioService.consultarUsuarios();
	}
	@GetMapping("/consultarUsuarioID/{Id}")
	public UsuarioDto consultarUsuarioPorId(@PathVariable Integer Id) {
		return usuarioService.consultarUsuarioPorId(Id);
		
	}

}
