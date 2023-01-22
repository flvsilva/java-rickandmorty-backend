package com.iterative.rickandmorty.service;

import org.springframework.stereotype.Service;

import com.iterative.rickandmorty.entity.RegistroOperacao;
import com.iterative.rickandmorty.repository.RegistroOperacaoRepository;

@Service
public class RegistroOperacaoService {

	private final RegistroOperacaoRepository repository;
	
	public RegistroOperacaoService(RegistroOperacaoRepository repository) {
	    this.repository = repository;
	}
	
	public void registraOperacao(RegistroOperacao ro) throws Exception {
		repository.save(ro);
	}
}
