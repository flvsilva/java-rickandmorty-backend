package com.iterative.rickandmorty.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.iterative.rickandmorty.dto.ResponseDTO;
import com.iterative.rickandmorty.entity.Episodio;
import com.iterative.rickandmorty.entity.Personagem;
import com.iterative.rickandmorty.entity.RegistroOperacao;
import com.iterative.rickandmorty.service.RegistroOperacaoService;

@RestController
@RequestMapping("/api")
public class PersonagemController {
	
	@Autowired
	public RegistroOperacaoService roService;

    @GetMapping(value = "/personagens")
    public ResponseEntity<List<Personagem>> Get() throws Exception {
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
        String json = new Gson().toJson(ret);
        RegistroOperacao ro = new RegistroOperacao();
        ro.setChamada("/api/personagens");
        ro.setRetorno(json);
        roService.registraOperacao(ro);
        
        return new ResponseEntity<List<Personagem>>(ret, HttpStatus.OK);
    }
    
    @GetMapping(value = "/personagens/{name}")
    public List<Personagem> GetByName(@PathVariable(value = "name") String name) throws Exception {
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

        String json = new Gson().toJson(ret);
        RegistroOperacao ro = new RegistroOperacao();
        ro.setChamada("/api/personagens/"+name);
        ro.setRetorno(json);
        roService.registraOperacao(ro);
        
        return ret;
    }
    
}


