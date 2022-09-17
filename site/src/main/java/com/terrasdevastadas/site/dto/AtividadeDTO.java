package com.terrasdevastadas.site.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.terrasdevastadas.site.model.Usuario;

//@JsonInclude(Include.NON_NULL)
public class AtividadeDTO {
	
	private String nome;
	
	private String descrição;
	
	private boolean concluida;
	
	private Usuario usuario;

	
	public String getDescrição() {
		return descrição;
	}
	
	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	

	public boolean isConcluida() {
		return concluida;
	}
	
	public void setConcluida(boolean concluida) {
		this.concluida = concluida;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
		

}
