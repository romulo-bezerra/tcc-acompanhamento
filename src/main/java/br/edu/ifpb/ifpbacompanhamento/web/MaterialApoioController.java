package br.edu.ifpb.ifpbacompanhamento.web;

import br.edu.ifpb.ifpbacompanhamento.domain.MaterialApoio;
import br.edu.ifpb.ifpbacompanhamento.service.MaterialApoioService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ifpbacompanhamento/materialapoio")
public class MaterialApoioController {

    private final MaterialApoioService materialApoioService;

    public MaterialApoioController(MaterialApoioService materialApoioService) {
        this.materialApoioService = materialApoioService;
    }

    @PostMapping
    public ResponseEntity<MaterialApoio> salvarMaterialApoio(@RequestBody MaterialApoio materialApoio) {
        return ResponseEntity.ok().body(materialApoioService.salvarMaterialApoio(materialApoio));
    }

    @GetMapping("todos")
    public ResponseEntity<List<MaterialApoio>> getTodos() {
        return ResponseEntity.ok().body(materialApoioService.listarTodos());
    }

    @GetMapping
    public ResponseEntity<MaterialApoio> findMaterialApoioById(@RequestParam("id") Long id) {
        Optional<MaterialApoio> materialApoio = materialApoioService.buscarPorId(id);
        if (materialApoio.isPresent()) return ResponseEntity.ok().body(materialApoio.get());
        else {
            HttpHeaders headers = new HttpHeaders();
            headers.add("message", String.format("MaterialApoio de id %d não existe", id));
            return ResponseEntity.notFound().headers(headers).build();
        }
    }

    @PutMapping
    public ResponseEntity<MaterialApoio> atualizaMaterialApoio (@RequestBody MaterialApoio materialApoio) {
        return ResponseEntity.ok().body(materialApoioService.salvarMaterialApoio(materialApoio));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteMaterialApoio(@RequestParam("id") Long id) {
        Optional<MaterialApoio> materialApoio = materialApoioService.buscarPorId(id);
        if (materialApoio.isPresent()) {
            materialApoioService.apagarMaterialApoio(materialApoio.get());
            return ResponseEntity.ok().build();
        } else {
            HttpHeaders headers = new HttpHeaders();
            headers.add("message", String.format("MaterialApoio de id %d não existe", id));
            return ResponseEntity.notFound().headers(headers).build();
        }
    }

}
