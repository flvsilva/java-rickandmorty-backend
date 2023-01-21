package com.iterative.rickandmorty.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.iterative.rickandmorty.dto.ResponseDTO;
import com.iterative.rickandmorty.entity.Episodio;
import com.iterative.rickandmorty.entity.Personagem;

@RestController
public class PersonagemController {

    @GetMapping(value = "/personagens")
    public List<Personagem> Get() throws JsonMappingException, JsonProcessingException {
    	String BASE_URL = "https://rickandmortyapi.com/api/character";
    	RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ResponseDTO> response = restTemplate.getForEntity(BASE_URL, ResponseDTO.class);
        List<Personagem> ret = response.getBody().getResults();
        
        for (Personagem personagem : ret) {
			for (String ep : personagem.getEpisode()) {
		        ResponseEntity<Episodio> responseEp = restTemplate.getForEntity(ep, Episodio.class);
		        personagem.getEpisodes().add(responseEp.getBody());
			}
		}
        return ret;
    }
    
    @GetMapping(value = "/personagens/{name}")
    public List<Personagem> GetByName(@PathVariable(value = "name") String name) throws JsonMappingException, JsonProcessingException {
    	String BASE_URL = "https://rickandmortyapi.com/api/character/?name=";
    	RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ResponseDTO> response = restTemplate.getForEntity(BASE_URL+name, ResponseDTO.class);
        List<Personagem> ret = response.getBody().getResults();
        
        for (Personagem personagem : ret) {
			for (String ep : personagem.getEpisode()) {
		        ResponseEntity<Episodio> responseEp = restTemplate.getForEntity(ep, Episodio.class);
		        personagem.getEpisodes().add(responseEp.getBody());
			}
		}
        return ret;
    }
    
}


