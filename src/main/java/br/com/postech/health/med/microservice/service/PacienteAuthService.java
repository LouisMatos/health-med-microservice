package br.com.postech.health.med.microservice.service;

import br.com.postech.health.med.microservice.exception.NotFoundException;
import br.com.postech.health.med.microservice.exception.UnauthorizedException;
import br.com.postech.health.med.microservice.model.Medico;
import br.com.postech.health.med.microservice.model.Paciente;
import br.com.postech.health.med.microservice.repository.MedicoRepository;
import br.com.postech.health.med.microservice.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PacienteAuthService {

  @Autowired
  private PacienteRepository pacienteRepository;

  public Paciente autenticarPaciente(Long id, String tokenAcesso) {
    Paciente paciente = pacienteRepository.findById(id).orElseThrow(() -> new NotFoundException("Paciente não encontrado."));

    if (paciente.getToken_auth() == null || !paciente.getToken_auth().equals(tokenAcesso)) {
      throw new UnauthorizedException("Token inválido ou não corresponde ao paciente.");
    }

    if (paciente.getData_validade_token().isBefore(LocalDateTime.now())) {
      throw new UnauthorizedException("Token expirado.");
    }

    return paciente;
  }
}
