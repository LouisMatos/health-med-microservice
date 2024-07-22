package br.com.postech.health.med.microservice.controller.medico;

import br.com.postech.health.med.microservice.model.dto.MedicoAuthDTO;
import br.com.postech.health.med.microservice.model.dto.MedicoDTO;
import br.com.postech.health.med.microservice.service.MedicoService;
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
@RequestMapping(path = "/v1/api/medicos")
public class MedicoController {

  @Autowired
  private MedicoService medicoService;

  @PostMapping
  public ResponseEntity<MedicoAuthDTO> autenticaMedico(@Valid @RequestBody MedicoDTO medicoDTO) {
    log.info("Iniciando a autenticação do médico!");
    return ResponseEntity.ok().body(medicoService.autenticaMedico(medicoDTO));
  }

  @PostMapping("/novo")
  public ResponseEntity<MedicoDTO> novoMedico(@Valid @RequestBody MedicoDTO medicoDTO) {
    log.info("Iniciando o cadastro do novo médico!");
    return ResponseEntity.ok().body(medicoService.novoMedico(medicoDTO));
  }
}
