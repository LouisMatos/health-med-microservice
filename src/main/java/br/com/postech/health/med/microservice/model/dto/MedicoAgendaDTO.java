package br.com.postech.health.med.microservice.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MedicoAgendaDTO {

  @JsonProperty("token_acesso")
  private String tokenAcesso;

  private String crm;

  @JsonProperty("data_agenda")
  private String dataAgenda;

  @JsonProperty("hora_agenda")
  private String horaAgenda;

  private Boolean disponivel;

}
