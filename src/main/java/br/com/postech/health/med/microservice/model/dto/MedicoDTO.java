package br.com.postech.health.med.microservice.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class MedicoDTO {

  public long id;

  private String nome;

  private String crm;

  private String email;

  private String senha;

  private String especialidade;
}
