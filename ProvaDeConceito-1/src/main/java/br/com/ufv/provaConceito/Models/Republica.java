package br.com.ufv.provaConceito.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("deprecation")
@Entity
@Table(name= "Republica")
public class Republica {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "republica_id")
	private int id;
	
	@Column(name = "email")
	@Email(message = "*Insira um email valido")
	@NotEmpty(message = "*Este campo deve ser preenchido")
	private String email;
	
	
	private String nome;
	private String endereco;
	private int lotacao;
	private float valorDespesas;
	private float valorAluguel;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	public Republica() {
		
	}
	
	
	public Republica(
			@Email(message = "*Insira um email valido") 
			@NotEmpty(message = "*Este campo deve ser preenchido") 
			String email,
			String nome, String endereco, String proprietario, int lotacao, float valorDespesas, float valorAluguel) {

		super();

		this.email = email;
		this.nome = nome;
		this.endereco = endereco;
		this.lotacao = lotacao;
		this.valorDespesas = valorDespesas;
		this.valorAluguel = valorAluguel;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public int getLotacao() {
		return lotacao;
	}
	public void setLotacao(int lotacao) {
		this.lotacao = lotacao;
	}
	public float getValorDespesas() {
		return valorDespesas;
	}
	public void setValorDespesas(float valorDespesas) {
		this.valorDespesas = valorDespesas;
	}
	public float getValorAluguel() {
		return valorAluguel;
	}
	public void setValorAluguel(float valorAluguel) {
		this.valorAluguel = valorAluguel;
	}	
}
