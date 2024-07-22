package br.com.postech.health.med.microservice.service;

import br.com.postech.health.med.microservice.exception.ConflictException;
import br.com.postech.health.med.microservice.exception.NotFoundException;
import br.com.postech.health.med.microservice.exception.UnauthorizedException;
import br.com.postech.health.med.microservice.model.Medico;
import br.com.postech.health.med.microservice.model.MedicoAgenda;
import br.com.postech.health.med.microservice.model.dto.MedicoAgendaDTO;
import br.com.postech.health.med.microservice.model.dto.MedicoAuthDTO;
import br.com.postech.health.med.microservice.model.dto.MedicoDTO;
import br.com.postech.health.med.microservice.presenter.MedicoPresenter;
import br.com.postech.health.med.microservice.repository.MedicoAgendaRepository;
import br.com.postech.health.med.microservice.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class MedicoAgendaService {

  @Autowired
  private MedicoAgendaRepository medicoAgendaRepository;

  @Autowired
  private MedicoAuthService medicoAuthService;


  public MedicoAgendaDTO novaAgendaMedico(MedicoAgendaDTO medicoAgendaDTO) {
    medicoAuthService.autenticarMedico(medicoAgendaDTO.getCrm(), medicoAgendaDTO.getTokenAcesso());

    // Verifica se já existe uma agenda para o médico no mesmo horário
    Optional<MedicoAgenda> agendaExistente = medicoAgendaRepository.findByCrmAndDataAgendaAndHoraAgenda(
        medicoAgendaDTO.getCrm(), medicoAgendaDTO.getDataAgenda(), medicoAgendaDTO.getHoraAgenda());

    if (agendaExistente.isPresent()) {
      throw new ConflictException("Já existe uma agenda para este médico no horário especificado.");
    }

    MedicoAgenda medicoAgenda = medicoAgendaRepository.save(MedicoPresenter.toMedicoAgenda(medicoAgendaDTO));

    return MedicoPresenter.toMedicoAgendaDTO(medicoAgenda);
  }

}
