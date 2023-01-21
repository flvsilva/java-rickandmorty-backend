package com.iterative.rickandmorty.dto;

import java.util.List;

import com.iterative.rickandmorty.entity.Personagem;

public class ResponseDTO {
	private List<Personagem> results;

	public List<Personagem> getResults() {
		return results;
	}

	public void setResults(List<Personagem> results) {
		this.results = results;
	}
	
	
}
