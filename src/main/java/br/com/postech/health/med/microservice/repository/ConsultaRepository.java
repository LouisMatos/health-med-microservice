package br.com.postech.health.med.microservice.repository;

import br.com.postech.health.med.microservice.model.Consulta;
import br.com.postech.health.med.microservice.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
}
