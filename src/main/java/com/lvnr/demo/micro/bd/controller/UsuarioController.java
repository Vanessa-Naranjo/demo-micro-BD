package com.lvnr.demo.micro.bd.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lvnr.demo.micro.bd.service.UsuarioService;

@RestController
@RequestMapping ("/usuarios")
public class UsuarioController {
	
	private UsuarioService usuarioService;

}
