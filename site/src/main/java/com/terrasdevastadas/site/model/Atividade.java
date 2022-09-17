package com.terrasdevastadas.site.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terrasdevastadas.site.searialize.AtividadeSerializer;

@Entity
@Table(name="tb_atividades", schema="terras_devastadas")
@JsonSerialize(using = AtividadeSerializer.class)
public class Atividade implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String nome;
	
	private String descrição;
	
	
	private boolean concluida;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_usuario", nullable = false)
//	@JsonBackReference
	private Usuario usuario;
	

	public String getDescrição() {
		return descrição;
	}
	
	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Long getUsuario_id(){
	    return usuario.getId();
	}

	public boolean isConcluida() {
		return concluida;
	}
	
	public void setConcluida(boolean concluida) {
		this.concluida = concluida;
	}
	
		

}
