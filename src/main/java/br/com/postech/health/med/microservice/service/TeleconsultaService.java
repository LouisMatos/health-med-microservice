package br.com.postech.health.med.microservice.service;

import br.com.postech.health.med.microservice.exception.NotFoundException;
import br.com.postech.health.med.microservice.model.Consulta;
import br.com.postech.health.med.microservice.model.dto.TeleConsultaDTO;
import br.com.postech.health.med.microservice.presenter.TeleConsultaPresenter;
import br.com.postech.health.med.microservice.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TeleconsultaService {

  @Autowired
  private ConsultaRepository consultaRepository;


  public TeleConsultaDTO consultarTeleconsulta(Long id) {
    Consulta consulta = consultaRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("Consulta não encontrada!"));

    consulta.setLinkConsulta(gerarLinkConsulta());

    return TeleConsultaPresenter.toTeleconsultaDTO(consulta);
  }

  private String gerarLinkConsulta() {
    // Generate a fake link for a virtual meeting
    return "https://fake-meeting.com/" + UUID.randomUUID().toString();
  }
}
