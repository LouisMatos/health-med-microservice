package br.com.postech.health.med.microservice.controller.paciente;


import br.com.postech.health.med.microservice.model.dto.*;
import br.com.postech.health.med.microservice.service.MedicoService;
import br.com.postech.health.med.microservice.service.PacienteService;
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
@RequestMapping(path = "/v1/api/pacientes")
public class PacienteController {

  @Autowired
  private PacienteService pacienteService;

  @PostMapping("/novo")
  public ResponseEntity<PacienteDTO> novoMedico(@Valid @RequestBody PacienteDTO pacienteDTO) {
    log.info("Iniciando o cadastro do novo paciente!");
    return ResponseEntity.ok().body(pacienteService.novoPaciente(pacienteDTO));
  }

  @PostMapping
  public ResponseEntity<PacienteAuthDTO> autenticaPaciente(@Valid @RequestBody PacienteDTO pacienteDTO) {
    log.info("Iniciando a autenticação do paciente!");
    return ResponseEntity.ok().body(pacienteService.autenticaPaciente(pacienteDTO));
  }


}
