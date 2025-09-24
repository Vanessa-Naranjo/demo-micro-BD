package com.lvnr.demo.micro.bd.controller;

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

	@PostMapping("/crearusuariocuandoexista")
	public void crearUsuarioCuandoExistePersona(@RequestBody UsuarioDto usuarioDto) {
		usuarioService.crearUsuarioCuandoExistePersona(usuarioDto);
	}

}
