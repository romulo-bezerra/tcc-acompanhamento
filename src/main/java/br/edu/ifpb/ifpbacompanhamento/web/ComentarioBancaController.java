package br.edu.ifpb.ifpbacompanhamento.web;

import br.edu.ifpb.ifpbacompanhamento.domain.ComentarioBanca;
import br.edu.ifpb.ifpbacompanhamento.service.ComentarioBancaService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ifpbacompanhamento/comentariobanca")
public class ComentarioBancaController {

    private final ComentarioBancaService comentarioBancaService;

    public ComentarioBancaController(ComentarioBancaService comentarioBancaService) {
        this.comentarioBancaService = comentarioBancaService;
    }

    @PostMapping
    public ResponseEntity<ComentarioBanca> salvarComentarioBanca(@RequestBody ComentarioBanca comentarioBanca) {
        return ResponseEntity.ok().body(comentarioBancaService.salvarComentarioBanca(comentarioBanca));
    }

    @GetMapping("todos")
    public ResponseEntity<List<ComentarioBanca>> getTodos() {
        return ResponseEntity.ok().body(comentarioBancaService.listarTodos());
    }

    @GetMapping
    public ResponseEntity<ComentarioBanca> findComentarioBancaById(@RequestParam("id") Long id) {
        Optional<ComentarioBanca> comentarioBanca = comentarioBancaService.buscarPorId(id);
        if (comentarioBanca.isPresent()) return ResponseEntity.ok().body(comentarioBanca.get());
        else {
            HttpHeaders headers = new HttpHeaders();
            headers.add("message", String.format("ComentarioBanca de id %d não existe", id));
            return ResponseEntity.notFound().headers(headers).build();
        }
    }

    @PutMapping
    public ResponseEntity<ComentarioBanca> atualizaComentarioBanca (@RequestBody ComentarioBanca comentarioBanca) {
        return ResponseEntity.ok().body(comentarioBancaService.salvarComentarioBanca(comentarioBanca));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteComentarioBanca(@RequestParam("id") Long id) {
        Optional<ComentarioBanca> comentarioBanca = comentarioBancaService.buscarPorId(id);
        if (comentarioBanca.isPresent()) {
            comentarioBancaService.apagarComentarioBanca(comentarioBanca.get());
            return ResponseEntity.ok().build();
        } else {
            HttpHeaders headers = new HttpHeaders();
            headers.add("message", String.format("ComentarioBanca de id %d não existe", id));
            return ResponseEntity.notFound().headers(headers).build();
        }
    }

}
