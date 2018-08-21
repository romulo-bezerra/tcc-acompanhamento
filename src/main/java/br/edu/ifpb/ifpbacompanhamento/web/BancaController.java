package br.edu.ifpb.ifpbacompanhamento.web;


import br.edu.ifpb.ifpbacompanhamento.domain.Banca;
import br.edu.ifpb.ifpbacompanhamento.service.BancaService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ifpbacompanhamento/banca")
public class BancaController {

    private final BancaService bancaService;

    public BancaController(BancaService bancaService) {
        this.bancaService = bancaService;
    }

    @PostMapping
    public ResponseEntity<Banca> salvarBanca(@RequestBody Banca banca) {
        return ResponseEntity.ok().body(bancaService.salvarBanca(banca));
    }

    @GetMapping("todas")
    public ResponseEntity<List<Banca>> getTodas() {
        return ResponseEntity.ok().body(bancaService.listarTodas());
    }

    @GetMapping
    public ResponseEntity<Banca> findBancaById(@RequestParam("id") Long id) {
        Optional<Banca> banca = bancaService.buscarPorId(id);
        if (banca.isPresent()) return ResponseEntity.ok().body(banca.get());
        else {
            HttpHeaders headers = new HttpHeaders();
            headers.add("message", String.format("Banca de id %d não existe", id));
            return ResponseEntity.notFound().headers(headers).build();
        }
    }

    @PutMapping
    public ResponseEntity<Banca> atualizaBanca (@RequestBody Banca banca) {
        return ResponseEntity.ok().body(bancaService.salvarBanca(banca));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteBanca(@RequestParam("id") Long id) {
        Optional<Banca> banca = bancaService.buscarPorId(id);
        if (banca.isPresent()) {
            bancaService.apagarBanca(banca.get());
            return ResponseEntity.ok().build();
        } else {
            HttpHeaders headers = new HttpHeaders();
            headers.add("message", String.format("Banca de id %d não existe", id));
            return ResponseEntity.notFound().headers(headers).build();
        }
    }

}
