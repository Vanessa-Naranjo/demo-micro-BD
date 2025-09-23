package com.lvnr.demo.micro.bd.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lvnr.demo.micro.bd.dto.ClienteDto;
import com.lvnr.demo.micro.bd.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	private ClienteService clienteService;

	public ClienteController(ClienteService clienteService) {
		super();
		this.clienteService = clienteService;
	}

	@PostMapping
	public void crearCliente(@RequestBody ClienteDto clienteDto) {
		clienteService.crearClientes(clienteDto);
	}
	
	@PostMapping ("/crearclientecuandoexista")
	public void crearClienteCuandoExistePersona(@RequestBody ClienteDto clienteDto) {
		clienteService.crearClienteCuandoExistePersona(clienteDto);
	}

}
