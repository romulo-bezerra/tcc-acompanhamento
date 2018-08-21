package br.edu.ifpb.ifpbacompanhamento.web;

import br.edu.ifpb.ifpbacompanhamento.service.DefesaService;
import org.springframework.http.HttpHeaders;
import br.edu.ifpb.ifpbacompanhamento.domain.Defesa;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ifpbacompanhamento/defesa")
public class DefesaController {

    private final DefesaService defesaService;

    public DefesaController(DefesaService defesaService) {
        this.defesaService = defesaService;
    }

    @PostMapping
    public ResponseEntity<Defesa> salvarDefesa(@RequestBody Defesa defesa) {
        return ResponseEntity.ok().body(defesaService.salvarDefesa(defesa));
    }

    @GetMapping("todas")
    public ResponseEntity<List<Defesa>> getTodas() {
        return ResponseEntity.ok().body(defesaService.listarTodas());
    }

    @GetMapping
    public ResponseEntity<Defesa> findDefesaById(@RequestParam("id") Long id) {
        Optional<Defesa> defesa = defesaService.buscarPorId(id);
        if (defesa.isPresent()) return ResponseEntity.ok().body(defesa.get());
        else {
            HttpHeaders headers = new HttpHeaders();
            headers.add("message", String.format("Defesa de id %d não existe", id));
            return ResponseEntity.notFound().headers(headers).build();
        }
    }

    @PutMapping
    public ResponseEntity<Defesa> atualizaDefesa (@RequestBody Defesa defesa) {
        return ResponseEntity.ok().body(defesaService.salvarDefesa(defesa));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteDefesa(@RequestParam("id") Long id) {
        Optional<Defesa> defesa = defesaService.buscarPorId(id);
        if (defesa.isPresent()) {
            defesaService.apagarDefesa(defesa.get());
            return ResponseEntity.ok().build();
        } else {
            HttpHeaders headers = new HttpHeaders();
            headers.add("message", String.format("Defesa de id %d não existe", id));
            return ResponseEntity.notFound().headers(headers).build();
        }
    }

}