package br.com.postech.health.med.microservice.presenter;

import br.com.postech.health.med.microservice.model.Consulta;
import br.com.postech.health.med.microservice.model.dto.TeleConsultaDTO;

public class TeleConsultaPresenter {

  public static TeleConsultaDTO toTeleconsultaDTO(Consulta consulta) {
    // Map Consulta to TeleConsultaDTO
    TeleConsultaDTO teleConsultaDTO = new TeleConsultaDTO();
    // Assuming you have getters and setters in TeleConsultaDTO
    teleConsultaDTO.setId_consulta(consulta.getId());
    teleConsultaDTO.setCrm(consulta.getCrm());
    teleConsultaDTO.setLink_consulta(consulta.getLinkConsulta());
    return teleConsultaDTO;

  }
}
