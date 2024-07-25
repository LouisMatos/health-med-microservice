package br.com.postech.health.med.microservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "consultas")
public class Consulta implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_consulta")
  private Long id;

  private Long paciente_id;

  private String crm;

  private String data_agendamento;

  private String hora_agendamento;

  private String status;

  private String linkConsulta;

}
