package com.iterative.rickandmorty.entity;

import java.util.List;

public class Personagem {
	
    private long id;
    private String name;
    private String status;
    private String url;
    private String created;
    private List<Episodio> episodes; 

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public List<Episodio> getEpisodes() {
		return episodes;
	}

	public void setEpisodes(List<Episodio> episodes) {
		this.episodes = episodes;
	}


}
