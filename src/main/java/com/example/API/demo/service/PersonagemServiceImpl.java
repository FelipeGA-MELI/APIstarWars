package com.example.API.demo.service;

import com.example.API.demo.DTO.ListaPersoEncontrados;
import com.example.API.demo.repository.PersonagemRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonagemServiceImpl implements PersonagemService {
    private final PersonagemRepository personagemRepository;

    public PersonagemServiceImpl(PersonagemRepository personagemRepository) {
        this.personagemRepository = personagemRepository;
    }

    @Override
    public ListaPersoEncontrados getPersonagemService(String nomePersonagem) {
        ListaPersoEncontrados listaPersoEncontrados =  new ListaPersoEncontrados();

        listaPersoEncontrados.setPersonagemDTOList(personagemRepository.findIfMatch(nomePersonagem));

        return listaPersoEncontrados;
    }
}
