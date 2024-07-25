package br.com.postech.health.med.microservice.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonIgnoreProperties
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConsultaDTO {

  private Long id;

  private String token_acesso;

  private Long paciente_id;

  private String crm;

  private String data_agendamento;

  private String hora_agendamento;

  private String status;

  //Medico
  private Long agenda_id;

}
