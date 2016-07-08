package br.com.ajvideira.jsflivraria.bean;

import javax.faces.context.FacesContext;

public class BaseBean {
	
	public String logout() {
		
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
		return "login?faces-redirect=true";
		
	}

}
