package com.example.API.demo.repository;

import com.example.API.demo.DTO.PersonagemDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@Repository
public class PersonagemRepositoryImpl implements PersonagemRepository{
    @Override
    public List<PersonagemDTO> findIfMatch(String name) {
        List<PersonagemDTO> personagemDTOList;
        personagemDTOList = LocalDataBase();
        List<PersonagemDTO> resultadoList = new LinkedList<>();

        if(personagemDTOList != null) {
            for(PersonagemDTO personagem: personagemDTOList) {
                if(personagem.getName().contains(name)) {
                    resultadoList.add(personagem);
                }
            }
        }

        return resultadoList;
    }

    private List<PersonagemDTO> LocalDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<PersonagemDTO>> typeref = new TypeReference<>() { };
        List<PersonagemDTO> personagemDTOS = null;
        try {
            personagemDTOS = objectMapper.readValue(file,typeref);
        } catch(IOException e) {
            e.printStackTrace();
        }

        return personagemDTOS;
    }
}
