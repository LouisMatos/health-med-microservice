package br.com.postech.health.med.microservice.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;


@Data
@JsonIgnoreProperties
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PacienteDTO {

  private long id;

  private String nome;

  private String email;

  private String senha;

  private String cpf;

}
