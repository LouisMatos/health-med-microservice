package br.com.postech.health.med.microservice.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonIgnoreProperties
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PacienteAuthDTO {

  @JsonProperty("token_acesso")
  private String token;

  @JsonProperty("data_validade_token")
  private LocalDateTime dataValidadeToken;
}
