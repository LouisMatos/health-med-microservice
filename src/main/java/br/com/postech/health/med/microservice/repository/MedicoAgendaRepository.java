package br.com.postech.health.med.microservice.repository;

import br.com.postech.health.med.microservice.model.Medico;
import br.com.postech.health.med.microservice.model.MedicoAgenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface MedicoAgendaRepository extends JpaRepository<MedicoAgenda, Long> {

  Optional<MedicoAgenda> findByCrmAndDataAgendaAndHoraAgenda(String crm, String dataAgenda, String horaAgenda);
}
