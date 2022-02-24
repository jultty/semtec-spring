package com.semtec.api;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/termo")
public class TermoController {

    private final TermoRepository repository;

    TermoController(TermoRepository repository) {
        this.repository = repository;
    }

    // aggregate root
    @GetMapping("")
    List<Termo> all() {
        return repository.findAll();
    }

    @PostMapping("")
    Termo criaTermo(@RequestBody Termo novoTermo) {
        return repository.save(novoTermo);
    }

    @GetMapping("/{id}")
    Termo exibeTermo(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new
                TermoNotFoundException(id));
        }

    @PutMapping("/{id}")
    Termo substituiTermo(@RequestBody Termo
                         novoTermo, @PathVariable Long id) {

        return repository.findById(id)
                .map(termo -> {
                    termo.setTermo(novoTermo.getTermo());
                    termo.setSignificado(novoTermo.getSignificado());
                    return repository.save(termo);
                })
                .orElseGet(() -> {
                    novoTermo.setId(id);
                    return repository.save(novoTermo);
                });
    }

    @DeleteMapping("/{id}")
    void apagaTermo(@PathVariable Long id) {
        repository.deleteById(id);
    }
}

