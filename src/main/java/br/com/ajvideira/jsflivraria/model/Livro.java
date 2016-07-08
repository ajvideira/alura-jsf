package br.com.ajvideira.jsflivraria.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="livro")
public class Livro {

	@Id
	@GeneratedValue
	@Column(name="livro_id")
	private Integer id;
	
	@Column(name="titulo")
	private String titulo;
	
	@Column(name="isbn")
	private String isbn;
	
	@Column(name="preco")
	private Double preco;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_lancamento")
	private Calendar dataLancamento = Calendar.getInstance();
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="livro_autor", joinColumns={@JoinColumn(name="livro_id")}, 
	inverseJoinColumns={@JoinColumn(name="autor_id")}, 
	uniqueConstraints=@UniqueConstraint(columnNames={"livro_id", "autor_id"}))
	private List<Autor> autores = new ArrayList<Autor>();;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Calendar getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Calendar dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}
	
}
