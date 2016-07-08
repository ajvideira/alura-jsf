package br.com.ajvideira.jsflivraria.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import br.com.ajvideira.jsflivraria.model.Autor;
import br.com.ajvideira.jsflivraria.model.Livro;
import br.com.ajvideira.jsflivraria.service.AutorService;
import br.com.ajvideira.jsflivraria.service.LivroService;
import br.com.ajvideira.jsflivraria.util.SimpleEntityManager;

@ManagedBean(name="livroBean")
@ViewScoped
public class LivroBean extends BaseBean {
	
	private LivroService livroService;
	
	private AutorService autorService;

	private SimpleEntityManager simpleEntityManager;
	
	private Livro livro;
	
	private List<Autor> autores;
	
	private Integer autorId;
	
	private List<Livro> livros;
	
	private Integer livroId;
	
	@PostConstruct
	public void init() {
		livro = new Livro();
		setLivros(new ArrayList<Livro>());
		simpleEntityManager = new SimpleEntityManager("jsflivraria");
		
		autorService = new AutorService(simpleEntityManager);
		livroService = new LivroService(simpleEntityManager);
		
		autores = autorService.findAll();
		setLivros(livroService.findAll());
		
		simpleEntityManager.close();
	}
	
	public void gravar() {
		
		simpleEntityManager = new SimpleEntityManager("jsflivraria");
		livroService = new LivroService(simpleEntityManager);
		
		System.out.println("Gravando livro " + livro.getTitulo());
		
		if (livro.getAutores().isEmpty()) {
			FacesContext.getCurrentInstance().addMessage("autor", new FacesMessage("O livro deve ter ao menos um autor"));
			return;
		}
		
		if (livro.getId() != null) {
			livroService.update(livro);
		} else {
			livroService.save(livro);
		}
		
		livro = new Livro();
		
		setLivros(livroService.findAll());
		
		simpleEntityManager.close();
	}
	
	public void remover(Livro livro) {
		
		simpleEntityManager = new SimpleEntityManager("jsflivraria");
		livroService = new LivroService(simpleEntityManager);
		
		System.out.println("Removendo livro " + livro.getTitulo());
		
		livroService.delete(livro);
		
		setLivros(livroService.findAll());
		simpleEntityManager.close();
	}
	
	public void carregar(Livro livro) {
		
		System.out.println("Carregando livro " + livro.getTitulo());
		
		this.livro = livro;
		
	}
	
	public void adicionarAutor() {
		simpleEntityManager = new SimpleEntityManager("jsflivraria");
		autorService = new AutorService(simpleEntityManager);
		
		Autor autor = autorService.findById(autorId);
		livro.getAutores().add(autor);
		
		simpleEntityManager.close();
	}
	
	public void removerAutor(Autor autor) {
		int index = livro.getAutores().indexOf(autor);
		if (index != -1) {
			livro.getAutores().remove(index);
		}
	}

	public void comecaComDigitoUm(FacesContext fc, UIComponent ui, Object value) throws ValidatorException {
		String valor  = value.toString();
		
		if (!valor.startsWith("1")) {
			throw new ValidatorException(new FacesMessage("Deve começar com 1"));
		}
	}
	
	public void carregarLivroPeloId() {
		
		simpleEntityManager = new SimpleEntityManager("jsflivraria");
		livroService = new LivroService(simpleEntityManager);
		
		System.out.println("Carregando livro ID: " + livroId);
		
		this.livro = livroService.findById(livroId);
		
		if (this.livro == null) {
			this.livro = new Livro();
		}
		
		simpleEntityManager.close();
	}
	
	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
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

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public Integer getLivroId() {
		return livroId;
	}

	public void setLivroId(Integer livroId) {
		this.livroId = livroId;
	}
	
}
