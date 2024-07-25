package br.com.postech.health.med.microservice.controller;

import br.com.postech.health.med.microservice.model.dto.MedicoAgendaDTO;
import br.com.postech.health.med.microservice.model.dto.TeleConsultaDTO;
import br.com.postech.health.med.microservice.service.TeleconsultaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(path = "/v1/api/teleconsulta")
public class TeleconsultaController {

  @Autowired
  private TeleconsultaService teleconsultaService;

  @GetMapping("/consulta/{id}")
  public ResponseEntity<TeleConsultaDTO> consultarTeleconsulta(@PathVariable Long id) {
    log.info("Iniciando a consulta da teleconsulta com o id: {} e geração do link", id);
    return ResponseEntity.ok().body(teleconsultaService.consultarTeleconsulta(id));
  }
}
