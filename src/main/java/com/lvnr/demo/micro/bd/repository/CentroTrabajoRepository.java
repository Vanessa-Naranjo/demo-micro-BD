package com.lvnr.demo.micro.bd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lvnr.demo.micro.bd.entity.CentroTrabajoEntity;

@Repository
public interface CentroTrabajoRepository extends JpaRepository<CentroTrabajoEntity, Integer> {

	CentroTrabajoEntity findByCodigoCentroTrabajo(Integer codigoCentroTrabajo);

}
