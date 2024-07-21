package br.com.postech.health.med.microservice.presenter;

import br.com.postech.health.med.microservice.model.Medico;
import br.com.postech.health.med.microservice.model.dto.MedicoDTO;
import br.com.postech.health.med.microservice.utils.DataMaskingUtil;

public class MedicoPresenter {

  public static Medico toMedico(MedicoDTO medicoDTO) {
    Medico medico = new Medico();

    medico.setId(medicoDTO.getId());
    medico.setNome(medicoDTO.getNome());
    medico.setCrm(medicoDTO.getCrm());
    medico.setEmail(medicoDTO.getEmail());
    medico.setSenha( medicoDTO.getSenha());
    medico.setEspecialidade(medicoDTO.getEspecialidade());

    return medico;
  }

  public static MedicoDTO toMedicoDTO(Medico medico) {
    MedicoDTO medicoDTO = new MedicoDTO();

    medicoDTO.setId(medico.getId());
    medicoDTO.setNome(medico.getNome());
    medicoDTO.setCrm(medico.getCrm());
    medicoDTO.setEmail(medico.getEmail());
    medicoDTO.setSenha(DataMaskingUtil.maskSensitiveData( medico.getSenha(), 1, 1));
    medicoDTO.setEspecialidade(medico.getEspecialidade());

    return medicoDTO;
  }
}
