package br.com.ajvideira.jsflivraria.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.ajvideira.jsflivraria.model.Autor;
import br.com.ajvideira.jsflivraria.service.AutorService;
import br.com.ajvideira.jsflivraria.util.SimpleEntityManager;

@ManagedBean
@ViewScoped
public class AutorBean extends BaseBean {

	private AutorService autorService;
	
	private SimpleEntityManager simpleEntityManager;
	
	private Autor autor;
	
	private List<Autor> autores;
	
	private Integer autorId;

	@PostConstruct
	public void init() {
		autor = new Autor();
		setAutores(new ArrayList<Autor>());
		simpleEntityManager = new SimpleEntityManager("jsflivraria");
		autorService = new AutorService(simpleEntityManager);
		setAutores(autorService.findAll());
		
		simpleEntityManager.close();
	}
	
	public void gravar() {
		System.out.println("Gravando autor.");
		System.out.println("Nome: " + autor.getNome());
		
		simpleEntityManager = new SimpleEntityManager("jsflivraria");
		autorService = new AutorService(simpleEntityManager);
		
		if (autor.getId() != null) {
			autorService.update(autor);
		} else {
			autorService.save(autor);
		}
		
		autor = new Autor();
		
		setAutores(autorService.findAll());
		
		simpleEntityManager.close();
	}
	
	public void remover(Autor autor) {
		
		simpleEntityManager = new SimpleEntityManager("jsflivraria");
		autorService = new AutorService(simpleEntityManager);
		
		System.out.println("Removendo autor " + autor.getNome());
		
		autorService.delete(autor);
		
		setAutores(autorService.findAll());
		simpleEntityManager.close();
	}
	
	public void carregar(Autor autor) {
		
		System.out.println("Carregando autor " + autor.getNome());
		
		this.autor = autor;
		
	}
	
	public void carregarAutorPeloId() {
		
		simpleEntityManager = new SimpleEntityManager("jsflivraria");
		autorService = new AutorService(simpleEntityManager);
		
		System.out.println("Carregando autor ID: " + autorId);
		
		this.autor = autorService.findById(autorId);
		
		if (this.autor == null) {
			this.autor = new Autor();
		}
		
		simpleEntityManager.close();
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	public Integer getAutorId() {
		return autorId;
	}

	public void setAutorId(Integer autorId) {
		this.autorId = autorId;
	}
	
}
