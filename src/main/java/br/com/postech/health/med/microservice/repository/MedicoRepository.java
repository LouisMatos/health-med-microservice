package br.com.postech.health.med.microservice.repository;

import br.com.postech.health.med.microservice.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {

  Medico findByEmailAndSenha(String email, String senha);

  Medico findByCrmAndSenha(String crm, String senha);

  Medico findByCrm(String crm);
}
