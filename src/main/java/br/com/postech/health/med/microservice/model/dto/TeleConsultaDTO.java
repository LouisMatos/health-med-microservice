package br.com.postech.health.med.microservice.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonIgnoreProperties
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TeleConsultaDTO {

  private Long id_consulta;

  private String crm;

  private String link_consulta;
}
