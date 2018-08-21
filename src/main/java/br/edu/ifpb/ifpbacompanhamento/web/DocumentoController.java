package br.edu.ifpb.ifpbacompanhamento.web;

import br.edu.ifpb.ifpbacompanhamento.domain.Documento;
import br.edu.ifpb.ifpbacompanhamento.service.DocumentoService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ifpbacompanhamento/documento")
public class DocumentoController {

    private final DocumentoService documentoService;

    public DocumentoController(DocumentoService documentoService) {
        this.documentoService = documentoService;
    }

    @PostMapping
    public ResponseEntity<Documento> salvarDocumento(@RequestBody Documento documento) {
        return ResponseEntity.ok().body(documentoService.salvarDocumento(documento));
    }

    @GetMapping("todos")
    public ResponseEntity<List<Documento>> getTodos() {
        return ResponseEntity.ok().body(documentoService.listarTodos());
    }

    @GetMapping
    public ResponseEntity<Documento> findDocumentoById(@RequestParam("id") Long id) {
        Optional<Documento> documento = documentoService.buscarPorId(id);
        if (documento.isPresent()) return ResponseEntity.ok().body(documento.get());
        else {
            HttpHeaders headers = new HttpHeaders();
            headers.add("message", String.format("Documento de id %d não existe", id));
            return ResponseEntity.notFound().headers(headers).build();
        }
    }

    @PutMapping
    public ResponseEntity<Documento> atualizaDocumento (@RequestBody Documento documento) {
        return ResponseEntity.ok().body(documentoService.salvarDocumento(documento));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteDocumento(@RequestParam("id") Long id) {
        Optional<Documento> documento = documentoService.buscarPorId(id);
        if (documento.isPresent()) {
            documentoService.apagarDocumento(documento.get());
            return ResponseEntity.ok().build();
        } else {
            HttpHeaders headers = new HttpHeaders();
            headers.add("message", String.format("Documento de id %d não existe", id));
            return ResponseEntity.notFound().headers(headers).build();
        }
    }

}
