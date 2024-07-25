package br.com.postech.health.med.microservice.service;

import br.com.postech.health.med.microservice.exception.NotFoundException;
import br.com.postech.health.med.microservice.model.Medico;
import br.com.postech.health.med.microservice.model.dto.MedicoAuthDTO;
import br.com.postech.health.med.microservice.model.dto.MedicoDTO;
import br.com.postech.health.med.microservice.presenter.MedicoPresenter;
import br.com.postech.health.med.microservice.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class MedicoService {

  @Autowired
  private MedicoRepository medicoRepository;


  public MedicoAuthDTO autenticaMedico(MedicoDTO medicoDTO) {

    Medico medico = medicoRepository.findByCrmAndSenha(medicoDTO.getCrm(), medicoDTO.getSenha());

    if (medico != null) {
      // Gera um novo token UUID
      String tokenAuth = UUID.randomUUID().toString();
      // Define a data de validade do token para 15 minutos a partir de agora
      LocalDateTime dataValidadeToken = LocalDateTime.now().plusMinutes(15);

      // Atualiza o objeto Medico com o novo token e data de validade
      medico.setToken_auth(tokenAuth);
      medico.setData_validade_token(dataValidadeToken);

      // Salva as alterações no repositório
      medicoRepository.save(medico);

      // Retorna o DTO atualizado
      return MedicoPresenter.toMedicoAuthDTO(medico);
    } else {
      throw new NotFoundException("Médico não encontrado!");
    }

  }

  public MedicoDTO novoMedico(MedicoDTO medicoDTO) {

    Medico medico = medicoRepository.save(MedicoPresenter.toMedico(medicoDTO));

    return MedicoPresenter.toMedicoDTO(medico);

  }

  public List<MedicoDTO> buscarMedicoPorEspecialidade(String especialidade) {

    List<Medico> medicos = medicoRepository.findByEspecialidadeContainingIgnoreCase(especialidade);

    if (medicos.isEmpty()) {
      throw new NotFoundException("Médico não encontrado!");
    }

    return MedicoPresenter.toMedicoDTOList(medicos);

  }
}
