package br.com.postech.health.med.microservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "medicos")
public class Medico implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_medico")
  private Long id;

  private String nome;

  private String crm;

  private String email;

  private String senha;

  private String especialidade;

  @Override
  public String toString() {
    return "Medico [id=" + id + ", nome=" + nome + ", crm=" + crm + ", email=" + email + ", senha=" + senha + ", especialidade=" + especialidade + "]";
  }

}
