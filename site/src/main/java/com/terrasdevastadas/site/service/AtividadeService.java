package com.terrasdevastadas.site.service;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.terrasdevastadas.site.dto.AtividadeDTO;
import com.terrasdevastadas.site.model.Atividade;
import com.terrasdevastadas.site.model.Usuario;
import com.terrasdevastadas.site.repository.AtividadeRepository;
import com.terrasdevastadas.site.repository.UsuarioRepository;

@Service
public class AtividadeService {
	
	@Autowired
	private AtividadeRepository atividadeRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
//	@Autowired
//	private AtividadeBuilder atividadeBuilder;
	
//	public List<Atividade> findAllAtividades(){
//
//	        return atividadeRepository.findAll();
//	    }
	 
	 public Optional<Atividade> findAtividadeById(Long id){

	        return atividadeRepository.findById(id);
	    }
	 
	 
	  public Optional<Atividade> createAtividade(Long idUsuario, Atividade novaAtividade){
		  
		     Optional<Atividade> atividade = usuarioRepository.findById(idUsuario).map(usuario -> { 
		       novaAtividade.setUsuario(usuario);
		       return atividadeRepository.save(novaAtividade);
		    });
		  
		     return atividade;
		 }
	  
	  public Atividade updateAtividade(AtividadeDTO atividadeDTO, Long id){

		     Atividade novaAtividade = atividadeRepository.findById(id).get();
		     
		     if (Objects.nonNull(atividadeDTO.isConcluida())) {
		    	 novaAtividade.setConcluida(atividadeDTO.isConcluida());
		         }
		  
		     if (Objects.nonNull(atividadeDTO.getNome()) && !"".equalsIgnoreCase(atividadeDTO.getNome())) {
		    	 novaAtividade.setNome(atividadeDTO.getNome());
		         }
		  
		     
		     if (Objects.nonNull(atividadeDTO.getDescrição()) && !"".equalsIgnoreCase(atividadeDTO.getDescrição())) {
		    	 novaAtividade.setDescrição(atividadeDTO.getDescrição());
	         }
		    
		     Usuario novoUsuario = usuarioRepository.findById(novaAtividade.getUsuario_id()).get();
		     
		     atividadeRepository.save(novaAtividade);
		  	  
			if (novaAtividade.isConcluida()){
				
			novoUsuario.setPontos(novoUsuario.getPontos() + 1);
				 
			usuarioRepository.save(novoUsuario);
								
			}
		     
		    return atividadeRepository.save(novaAtividade);
		         
	  }
		
	 	 
	  public void deleteAtividadeById (Long id){

		  atividadeRepository.deleteById(id);
	  }
	  

}
