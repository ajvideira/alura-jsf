package br.com.ajvideira.jsflivraria.listener;

import javax.faces.application.FacesMessage;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import br.com.ajvideira.jsflivraria.model.Usuario;

public class Autorizador implements PhaseListener{

    private static final long serialVersionUID = 1L;

    @Override
    public void afterPhase(PhaseEvent event) {
    	
    	FacesContext facesContext = event.getFacesContext();
    	String nomePagina = facesContext.getViewRoot().getViewId();
    	
    	System.out.println(nomePagina);
    	
    	if ("/login.xhtml".equals(nomePagina)) {
    		return;
    	}
    	
    	Usuario usuarioLogado = (Usuario) facesContext.getExternalContext().getSessionMap().get("usuarioLogado");
    	
    	if (usuarioLogado != null) {
    		return;
    	}
    	
    	facesContext.getExternalContext().getFlash().setKeepMessages(true);
    	facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Você precisa estar logado para acessar essa página.", null));
    	
    	//redirecionamento para login.jsf
    	
    	NavigationHandler navigationHandler = facesContext.getApplication().getNavigationHandler();
    	navigationHandler.handleNavigation(facesContext, null, "login?faces-redirect=true");
    	
    	facesContext.renderResponse();
    	
    }

    @Override
    public void beforePhase(PhaseEvent event) {
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }
}
