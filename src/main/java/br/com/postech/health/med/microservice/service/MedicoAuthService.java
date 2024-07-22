package br.com.postech.health.med.microservice.service;

import br.com.postech.health.med.microservice.exception.NotFoundException;
import br.com.postech.health.med.microservice.exception.UnauthorizedException;
import br.com.postech.health.med.microservice.model.Medico;
import br.com.postech.health.med.microservice.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MedicoAuthService {

  @Autowired
  private MedicoRepository medicoRepository;

  public Medico autenticarMedico(String crm, String tokenAcesso) {
    Medico medico = medicoRepository.findByCrm(crm);

    if (medico == null) {
      throw new NotFoundException("Médico não encontrado.");
    }

    if (medico.getToken_auth() == null || !medico.getToken_auth().equals(tokenAcesso)) {
      throw new UnauthorizedException("Token inválido ou não corresponde ao médico.");
    }

    if (medico.getData_validade_token().isBefore(LocalDateTime.now())) {
      throw new UnauthorizedException("Token expirado.");
    }

    return medico;
  }
}
