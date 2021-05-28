package com.example.API.demo.repository;

import com.example.API.demo.DTO.PersonagemDTO;
import java.util.List;

public interface PersonagemRepository {
    public List<PersonagemDTO> findIfMatch(String name);
}
