package com.terrasdevastadas.site.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

//@JsonInclude(Include.NON_NULL)
public class UsuarioDTO {
	
	private String nome;
	
	private String email;
	
	private String senha;
	
	private List<AtividadeDTO> atividades; 
	

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public List<AtividadeDTO> getAtividades() {
		return atividades;
	}

	public void setAtividades(List<AtividadeDTO> atividades) {
		this.atividades = atividades;
	}

}
