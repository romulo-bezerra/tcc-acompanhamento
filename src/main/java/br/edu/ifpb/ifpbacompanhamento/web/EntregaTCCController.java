package br.edu.ifpb.ifpbacompanhamento.web;

import br.edu.ifpb.ifpbacompanhamento.domain.EntregaTCC;
import br.edu.ifpb.ifpbacompanhamento.service.EntregaTCCService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ifpbacompanhamento/entregatcc")
public class EntregaTCCController {

    private final EntregaTCCService entregaTCCService;

    public EntregaTCCController(EntregaTCCService entregaTCCService) {
        this.entregaTCCService = entregaTCCService;
    }

    @PostMapping
    public ResponseEntity<EntregaTCC> salvarEntregaTCC(@RequestBody EntregaTCC entregaTCC) {
        return ResponseEntity.ok().body(entregaTCCService.salvarEntregaTCC(entregaTCC));
    }

    @GetMapping("todas")
    public ResponseEntity<List<EntregaTCC>> getTodas() {
        return ResponseEntity.ok().body(entregaTCCService.listarTodas());
    }

    @GetMapping
    public ResponseEntity<EntregaTCC> findEntregaTCCById(@RequestParam("id") Long id) {
        Optional<EntregaTCC> entregaTCC = entregaTCCService.buscarPorId(id);
        if (entregaTCC.isPresent()) return ResponseEntity.ok().body(entregaTCC.get());
        else {
            HttpHeaders headers = new HttpHeaders();
            headers.add("message", String.format("EntregaTCC de id %d não existe", id));
            return ResponseEntity.notFound().headers(headers).build();
        }
    }

    @PutMapping
    public ResponseEntity<EntregaTCC> atualizaEntregaTCC (@RequestBody EntregaTCC entregaTCC) {
        return ResponseEntity.ok().body(entregaTCCService.salvarEntregaTCC(entregaTCC));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteEntregaTCC(@RequestParam("id") Long id) {
        Optional<EntregaTCC> entregaTCC = entregaTCCService.buscarPorId(id);
        if (entregaTCC.isPresent()) {
            entregaTCCService.apagarEntregaTCC(entregaTCC.get());
            return ResponseEntity.ok().build();
        } else {
            HttpHeaders headers = new HttpHeaders();
            headers.add("message", String.format("EntregaTCC de id %d não existe", id));
            return ResponseEntity.notFound().headers(headers).build();
        }
    }

}
