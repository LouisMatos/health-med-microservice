package br.com.postech.health.med.microservice.service;

import br.com.postech.health.med.microservice.model.Medico;
import br.com.postech.health.med.microservice.model.dto.MedicoDTO;
import br.com.postech.health.med.microservice.presenter.MedicoPresenter;
import br.com.postech.health.med.microservice.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicoService {

  @Autowired
  private MedicoRepository medicoRepository;


  public MedicoDTO autenticaMedico(MedicoDTO medicoDTO) {

    Medico medico = medicoRepository.findByCrmAndSenha(medicoDTO.getCrm(), medicoDTO.getSenha());


    return MedicoPresenter.toMedicoDTO(medico);
  }

  public MedicoDTO novoMedico(MedicoDTO medicoDTO) {

    Medico medico = medicoRepository.save(MedicoPresenter.toMedico(medicoDTO));

    return MedicoPresenter.toMedicoDTO(medico);

  }
}
