package br.com.postech.health.med.microservice.presenter;

import br.com.postech.health.med.microservice.model.Consulta;
import br.com.postech.health.med.microservice.model.dto.ConsultaDTO;

public class ConsultaPresenter {

  public static Consulta toConsulta(ConsultaDTO consultaDTO) {
    Consulta consulta = new Consulta();

    consulta.setId(consultaDTO.getId());
    consulta.setCrm(consultaDTO.getCrm());
    consulta.setData_agendamento(consultaDTO.getData_agendamento());
    consulta.setHora_agendamento(consultaDTO.getHora_agendamento());
    consulta.setPaciente_id(consultaDTO.getPaciente_id());
    consulta.setStatus(consultaDTO.getStatus());

    return consulta;
  }


  public static ConsultaDTO toConsultaDTO(Consulta consulta) {
    ConsultaDTO consultaDTO = new ConsultaDTO();

    consultaDTO.setId(consulta.getId());
    consultaDTO.setCrm(consulta.getCrm());
    consultaDTO.setData_agendamento(consulta.getData_agendamento());
    consultaDTO.setHora_agendamento(consulta.getHora_agendamento());
    consultaDTO.setPaciente_id(consulta.getPaciente_id());
    consultaDTO.setStatus(consulta.getStatus());


    return consultaDTO;
  }
}
