package br.com.postech.health.med.microservice.repository;

import br.com.postech.health.med.microservice.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
  Paciente findByIdAndSenha(Long id, String senha);
}
