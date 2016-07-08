package br.com.ajvideira.jsflivraria.bean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.ajvideira.jsflivraria.model.Usuario;
import br.com.ajvideira.jsflivraria.service.UsuarioService;
import br.com.ajvideira.jsflivraria.util.SimpleEntityManager;

@ManagedBean
@ViewScoped
public class LoginBean extends BaseBean {

	private UsuarioService usuarioService;
	
	private SimpleEntityManager simpleEntityManager;
	
	private Usuario usuario;
	
	@PostConstruct
	public void init() {
		usuario = new Usuario();
	}
		
	public String processLogin() {
		System.out.println("chegou aqui");
		simpleEntityManager = new SimpleEntityManager("jsflivraria");
		usuarioService = new UsuarioService(simpleEntityManager);
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		Usuario usuario = usuarioService.findByLoginAndPassword(this.usuario.getLogin(), this.usuario.getSenha());
		
		if (usuario != null) {
			context.getExternalContext().getSessionMap().put("usuarioLogado", usuario);
			return "livro?faces-redirect=true";
		} 

		context.getExternalContext().getFlash().setKeepMessages(true);
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado", null));
		
		
		return "login?faces-redirect=true";
		
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
}
