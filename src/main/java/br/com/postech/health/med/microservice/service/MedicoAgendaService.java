package br.com.postech.health.med.microservice.service;

import br.com.postech.health.med.microservice.exception.ConflictException;
import br.com.postech.health.med.microservice.exception.NotFoundException;
import br.com.postech.health.med.microservice.model.MedicoAgenda;
import br.com.postech.health.med.microservice.model.dto.MedicoAgendaDTO;
import br.com.postech.health.med.microservice.presenter.MedicoPresenter;
import br.com.postech.health.med.microservice.repository.MedicoAgendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

  public MedicoAgendaDTO atualizarAgendaMedico(Long id, String crm, MedicoAgendaDTO medicoAgendaDTO) {
    medicoAuthService.autenticarMedico(crm, medicoAgendaDTO.getTokenAcesso());

    Optional<MedicoAgenda> medicoAgenda = medicoAgendaRepository.findByIdAndCrm(id, crm);

    if (medicoAgenda.isEmpty()) {
      throw new NotFoundException("Agenda não encontrada.");
    }

    MedicoAgenda agenda = medicoAgenda.get();

    agenda.setDataAgenda(medicoAgendaDTO.getDataAgenda());
    agenda.setHoraAgenda(medicoAgendaDTO.getHoraAgenda());
    agenda.setDisponivel(medicoAgendaDTO.getDisponivel());

    return MedicoPresenter.toMedicoAgendaDTO(medicoAgendaRepository.save(agenda));
  }

  public MedicoAgendaDTO atualizarAgendaMedicoInter(Long id, String crm, MedicoAgendaDTO medicoAgendaDTO) {

    Optional<MedicoAgenda> medicoAgenda = medicoAgendaRepository.findByIdAndCrm(id, crm);

    if (medicoAgenda.isEmpty()) {
      throw new NotFoundException("Agenda não encontrada.");
    }

    MedicoAgenda agenda = medicoAgenda.get();

    agenda.setDataAgenda(medicoAgendaDTO.getDataAgenda());
    agenda.setHoraAgenda(medicoAgendaDTO.getHoraAgenda());
    agenda.setDisponivel(medicoAgendaDTO.getDisponivel());

    return MedicoPresenter.toMedicoAgendaDTO(medicoAgendaRepository.save(agenda));
  }

  public MedicoAgenda buscarAgendaPorCrmDataHora(String crm, String dataAgenda, String horaAgenda) {
    Optional<MedicoAgenda> agenda = medicoAgendaRepository.findByCrmAndDataAgendaAndHoraAgenda(crm, dataAgenda, horaAgenda);
    if (agenda.isPresent()) {
      return agenda.get();
    } else {
      throw new NotFoundException("Agenda não encontrada para o médico com CRM " + crm + " na data " + dataAgenda + " e hora " + horaAgenda);
    }
  }



}
