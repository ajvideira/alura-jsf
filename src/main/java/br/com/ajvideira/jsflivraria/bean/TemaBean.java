package br.com.ajvideira.jsflivraria.bean;

import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name="temaBean")
public class TemaBean {

	private String tema = "bootstrap";
	
	private List<String> temas = Arrays.asList("afterdark", "afternoon", "afterwork"
			,"aristo", "black-tie","blitzer","bluesky","casablanca","cruze","cupertino"
			,"dark-hive","delta","dot-luv","eggplant","excite-bike","flick","glass-x"
			,"home","hot-sneaks","humanity","le-frog","midnight","mint-choc","overcast"
			,"pepper-grinder","redmond","rocket","sam","smoothness","south-street"
			,"start","sunny","swanky-purse","trontastic","bootstrap","ui-darkness"
			,"ui-lightness","vader");

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public List<String> getTemas() {
		return temas;
	}

	public void setTemas(List<String> temas) {
		this.temas = temas;
	}
	
	
	
}
