package br.com.postech.health.med.microservice.controller.medico;

import br.com.postech.health.med.microservice.model.dto.ConsultaDTO;
import br.com.postech.health.med.microservice.model.dto.MedicoAuthDTO;
import br.com.postech.health.med.microservice.model.dto.MedicoDTO;
import br.com.postech.health.med.microservice.service.MedicoService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

  @GetMapping("/especialidade")
  public ResponseEntity<List<MedicoDTO>> buscarMedicoPorEspecialidade(
      @RequestParam(name = "especialidade") String especialidade) {
    log.info("Iniciando a busca do médico com a especialidade: {}", especialidade);
    return ResponseEntity.ok().body(medicoService.buscarMedicoPorEspecialidade(especialidade));
  }

  @PutMapping("/{aceitaRecusa}")
    public ResponseEntity<ConsultaDTO> aceitaRecusaAgenda(@PathVariable String aceitaRecusa, @RequestParam(name = "agenda_id") Long agenda_id) {
        log.info("Iniciando a atualização da agenda do médico!");
        return ResponseEntity.ok().body(medicoService.aceitaRecusaAgenda(agenda_id, aceitaRecusa));
    }
}
