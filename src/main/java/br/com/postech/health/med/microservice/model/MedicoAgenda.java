package br.com.postech.health.med.microservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "medicos_agendas")
public class MedicoAgenda {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_medico_agenda")
  private Long id;

  private String crm;

  private String dataAgenda;

  private String horaAgenda;

  private Boolean disponivel;



}
