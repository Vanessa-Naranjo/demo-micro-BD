package com.lvnr.demo.micro.bd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lvnr.demo.micro.bd.entity.UsuarioEntity;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {

	UsuarioEntity findByCodigoUsuario(Integer codigoUsuario);
}
