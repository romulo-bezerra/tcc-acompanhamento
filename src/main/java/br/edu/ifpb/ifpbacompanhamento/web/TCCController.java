package br.edu.ifpb.ifpbacompanhamento.web;

import br.edu.ifpb.ifpbacompanhamento.domain.TCC;
import br.edu.ifpb.ifpbacompanhamento.service.TCCService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ifpbacompanhamento/tcc")
public class TCCController {

    private final TCCService tccService;

    public TCCController(TCCService tccService) {
        this.tccService = tccService;
    }

    @PostMapping
    public ResponseEntity<TCC> salvarTCC(@RequestBody TCC tcc) {
        return ResponseEntity.ok().body(tccService.salvarTCC(tcc));
    }

    @GetMapping("todos")
    public ResponseEntity<List<TCC>> getTodos() {
        return ResponseEntity.ok().body(tccService.listarTodos());
    }

    @GetMapping
    public ResponseEntity<TCC> findTCCById(@RequestParam("id") Long id) {
        Optional<TCC> tcc = tccService.buscarPorId(id);
        if (tcc.isPresent()) return ResponseEntity.ok().body(tcc.get());
        else {
            HttpHeaders headers = new HttpHeaders();
            headers.add("message", String.format("TCC de id %d não existe", id));
            return ResponseEntity.notFound().headers(headers).build();
        }
    }

    @PutMapping
    public ResponseEntity<TCC> atualizaTCC (@RequestBody TCC tcc) {
        return ResponseEntity.ok().body(tccService.salvarTCC(tcc));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteTCC(@RequestParam("id") Long id) {
        Optional<TCC> tcc = tccService.buscarPorId(id);
        if (tcc.isPresent()) {
            tccService.apagarTCC(tcc.get());
            return ResponseEntity.ok().build();
        } else {
            HttpHeaders headers = new HttpHeaders();
            headers.add("message", String.format("TCC de id %d não existe", id));
            return ResponseEntity.notFound().headers(headers).build();
        }
    }

}
