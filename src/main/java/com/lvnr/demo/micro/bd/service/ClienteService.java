package com.lvnr.demo.micro.bd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvnr.demo.micro.bd.dto.ClienteDto;
import com.lvnr.demo.micro.bd.entity.ClienteEntity;
import com.lvnr.demo.micro.bd.entity.PersonaEntity;
import com.lvnr.demo.micro.bd.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public void crearClientes(ClienteDto clienteDto) {
		ClienteEntity clienteEntity = new ClienteEntity();
		clienteEntity.setEmail(clienteDto.getEmail());
		clienteEntity.setCelular(clienteDto.getCelular());
		PersonaEntity personaEntity = new PersonaEntity();
		personaEntity.setNombres(clienteDto.getPersonaDto().getNombres());
		personaEntity.setApellidos(clienteDto.getPersonaDto().getApellidos());
		clienteEntity.setPersonaEntity(personaEntity);
		
		
		clienteRepository.save(clienteEntity);

	}

}
