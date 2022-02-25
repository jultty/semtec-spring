package com.semtec.api;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/v1")
class TermoController {

    private final TermoRepository repository;
    private final TermoModelAssembler assembler;

    TermoController(TermoRepository repository,
                    TermoModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    @GetMapping("/termo")
    CollectionModel<EntityModel<Termo>> all() {

    List<EntityModel<Termo>> termos =
            repository.findAll().stream()
                    .map(assembler::toModel).collect(Collectors.toList());

            return CollectionModel.of(termos,
    linkTo(methodOn(TermoController.class).all()).withSelfRel());
    }

    @PostMapping("/termo")
    ResponseEntity<?> novoTermo(@RequestBody Termo novoTermo) {

        EntityModel<Termo> entityModel = assembler.toModel(
                repository.save(novoTermo));

        return ResponseEntity.created(entityModel
                .getRequiredLink(IanaLinkRelations.SELF)
                .toUri()).body(entityModel);
    }

    @GetMapping("/termo/{id}")
    EntityModel<Termo> exibeTermo(@PathVariable Long id) {

        Termo termo = repository.findById(id)
                .orElseThrow(() -> new TermoNotFoundException(id));

        return assembler.toModel(termo);
        }

    @PutMapping("/termo/{id}")
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

    @DeleteMapping("/termo/{id}")
    void apagaTermo(@PathVariable Long id) {
        repository.deleteById(id);
    }
}

