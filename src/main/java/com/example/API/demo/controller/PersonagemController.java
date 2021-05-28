package com.example.API.demo.controller;

import com.example.API.demo.DTO.ListaPersoEncontrados;
import com.example.API.demo.service.PersonagemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/StarWars")
public class PersonagemController {
    private final PersonagemService personagemService;

    public PersonagemController(PersonagemService personagemService) {
        this.personagemService = personagemService;
    }

    @GetMapping("/{nome}")
    public ResponseEntity<ListaPersoEncontrados> getPersonagens(@PathVariable String nome) {
        return new ResponseEntity<>(personagemService.getPersonagemService(nome), HttpStatus.OK);
    }
}
