package com.semtec.api;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
class TermoModelAssembler implements RepresentationModelAssembler<Termo,
        EntityModel<Termo>> {

    @Override
    public EntityModel<Termo> toModel(Termo termo) {

        return EntityModel.of(termo,
    linkTo(methodOn(TermoController.class).exibeTermo(termo.getId()))
            .withSelfRel(),
    linkTo(methodOn(TermoController.class).all()).withRel("termos"));
    }
}
