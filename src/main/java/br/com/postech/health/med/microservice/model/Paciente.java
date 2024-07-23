package br.com.postech.health.med.microservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "pacientes")
public class Paciente {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_paciente")
  private Long id;

  private String nome;

  private String email;

  private String senha;

  private String cpf;

  private String token_auth;

  private LocalDateTime data_validade_token;


}
