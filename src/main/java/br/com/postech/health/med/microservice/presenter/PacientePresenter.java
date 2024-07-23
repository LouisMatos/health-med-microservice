package br.com.postech.health.med.microservice.presenter;

import br.com.postech.health.med.microservice.model.Paciente;
import br.com.postech.health.med.microservice.model.dto.PacienteAuthDTO;
import br.com.postech.health.med.microservice.model.dto.PacienteDTO;

public class PacientePresenter {

  public static Paciente toPaciente(PacienteDTO pacienteDTO) {
    Paciente paciente = new Paciente();
    paciente.setId(pacienteDTO.getId());
    paciente.setNome(pacienteDTO.getNome());
    paciente.setEmail(pacienteDTO.getEmail());
    paciente.setSenha(pacienteDTO.getSenha());
    paciente.setCpf(pacienteDTO.getCpf());
    return paciente;
  }

  public static PacienteDTO toPacienteDTO(Paciente paciente) {
    PacienteDTO pacienteDTO = new PacienteDTO();
    pacienteDTO.setId(paciente.getId());
    pacienteDTO.setNome(paciente.getNome());
    pacienteDTO.setEmail(paciente.getEmail());
    pacienteDTO.setSenha(paciente.getSenha());
    pacienteDTO.setCpf(paciente.getCpf());
    return pacienteDTO;
  }

  public static PacienteAuthDTO toPacienteAuthDTO(Paciente paciente) {
    PacienteAuthDTO pacienteAuthDTO = new PacienteAuthDTO();
    pacienteAuthDTO.setToken(paciente.getToken_auth());
    pacienteAuthDTO.setDataValidadeToken(paciente.getData_validade_token());
    return pacienteAuthDTO;
  }
}
