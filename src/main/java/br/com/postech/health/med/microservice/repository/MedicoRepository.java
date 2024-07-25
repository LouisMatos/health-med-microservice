package br.com.postech.health.med.microservice.repository;

import br.com.postech.health.med.microservice.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {

  Medico findByEmailAndSenha(String email, String senha);

  Medico findByCrmAndSenha(String crm, String senha);

  Medico findByCrm(String crm);

  @Query("SELECT m FROM medicos m WHERE LOWER(m.especialidade) LIKE LOWER(CONCAT('%', :especialidade, '%'))")
  List<Medico> findByEspecialidadeContainingIgnoreCase(@Param("especialidade") String especialidade);

  List<Medico> findByEspecialidade(String especialidade);
}
