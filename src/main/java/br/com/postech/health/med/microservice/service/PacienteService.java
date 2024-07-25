package br.com.postech.health.med.microservice.service;

import br.com.postech.health.med.microservice.exception.NotFoundException;
import br.com.postech.health.med.microservice.model.Medico;
import br.com.postech.health.med.microservice.model.Paciente;
import br.com.postech.health.med.microservice.model.dto.ConsultaDTO;
import br.com.postech.health.med.microservice.model.dto.MedicoAuthDTO;
import br.com.postech.health.med.microservice.model.dto.PacienteAuthDTO;
import br.com.postech.health.med.microservice.model.dto.PacienteDTO;
import br.com.postech.health.med.microservice.presenter.MedicoPresenter;
import br.com.postech.health.med.microservice.presenter.PacientePresenter;
import br.com.postech.health.med.microservice.repository.MedicoRepository;
import br.com.postech.health.med.microservice.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class PacienteService {

  @Autowired
  private PacienteRepository pacienteRepository;

  @Autowired
  private MedicoRepository medicoRepository;


  @Autowired
  private PacienteAuthService pacienteAuthService;


  public PacienteDTO novoPaciente(PacienteDTO pacienteDTO) {
    Paciente paciente = pacienteRepository.save(PacientePresenter.toPaciente(pacienteDTO));

    return PacientePresenter.toPacienteDTO(paciente);
  }

  public PacienteAuthDTO autenticaPaciente(PacienteDTO pacienteDTO) {

    Paciente paciente =
        pacienteRepository.findByIdAndSenha(pacienteDTO.getId(), pacienteDTO.getSenha());

    if (paciente != null) {
      // Gera um novo token UUID
      String tokenAuth = UUID.randomUUID().toString();
      // Define a data de validade do token para 15 minutos a partir de agora
      LocalDateTime dataValidadeToken = LocalDateTime.now().plusMinutes(15);

      // Atualiza o objeto Medico com o novo token e data de validade
      paciente.setToken_auth(tokenAuth);
      paciente.setData_validade_token(dataValidadeToken);

      // Salva as alterações no repositório
      pacienteRepository.save(paciente);

      // Retorna o DTO atualizado
      return PacientePresenter.toPacienteAuthDTO(paciente);
    } else {
      throw new NotFoundException("Paciente não encontrado!");
    }
  }

  public ConsultaDTO agendarConsulta(ConsultaDTO consultaDTO) {

    pacienteAuthService.autenticarPaciente(consultaDTO.getPaciente_id(), consultaDTO.getToken_acesso());

    Medico medico = medicoRepository.findByCrm(consultaDTO.getCrm());
    if (medico == null) {
      throw new NotFoundException("Médico não encontrado!");
    }
    // Verifica se o paciente existe na base de dados através do ID
    Paciente paciente = pacienteRepository.findById(consultaDTO.getPaciente_id()).orElse(null);
    if (paciente == null) {
      throw new NotFoundException("Paciente não encontrado!");
    }




    return null;

  }
}
