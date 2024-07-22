package br.com.postech.health.med.microservice.controller.medico;

import br.com.postech.health.med.microservice.model.dto.MedicoAgendaDTO;
import br.com.postech.health.med.microservice.model.dto.MedicoDTO;
import br.com.postech.health.med.microservice.service.MedicoAgendaService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(path = "/v1/api/medicos/agendas")
public class MedicoAgendaController {

  @Autowired
  private MedicoAgendaService medicoAgendaService;

  @PostMapping("/nova")
  public ResponseEntity<MedicoAgendaDTO> novaAgenda(@Valid @RequestBody MedicoAgendaDTO medicoAgendaDTO) {
    log.info("Iniciando o cadastro de nova agenda do médico!'");
    return ResponseEntity.ok().body(medicoAgendaService.novaAgendaMedico(medicoAgendaDTO));
  }


}
