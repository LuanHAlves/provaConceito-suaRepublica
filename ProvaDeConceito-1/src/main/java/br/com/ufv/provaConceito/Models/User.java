package br.com.ufv.provaConceito.Models;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Transient;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@SuppressWarnings({ "deprecation", "serial" })
@Entity
@Table(name = "user")
public class User implements UserDetails{


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private int id;
	
	@Column(name = "email")
	@Email(message = "*Por favor, informe um email válido")
	@NotEmpty(message = "*Por favor, informe um email")
	private String email;
	
	@Column(name = "senha")
	@Length(min = 5, message = "*Sua senha deve possuir ao menos 5 caracteres")
	@NotEmpty(message = "*Por favor forneça a sua senha")
	@Transient
	private String senha;
	
	@Column(name = "cofirmacaoSenha")
	@Transient
	private String confirmacaoSenha;
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL,fetch = FetchType.LAZY)
//	@JoinColumn(name="user_id")
	private List<Republica> republicas;

	@Column(name = "nomeUsuario")
	@NotEmpty(message = "*Please provide your name")
	private String nomeUsuario;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;
	
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getConfirmacaoSenha() {
		return confirmacaoSenha;
	}

	public void setConfirmacaoSenha(String confirmacaoSenha) {
		this.confirmacaoSenha = confirmacaoSenha;
	}
	
	public void addRepublica(Republica r) {
		this.republicas.add(r);
	}

	public User() {
		this.republicas = new ArrayList<Republica>();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public List<Republica> getRepublicas() {
		return republicas;
	}

	public void setRepublicas(List<Republica> republicas) {
		this.republicas = republicas;
	}


	@Override
	public String getPassword() {
		return this.senha;
	}

	
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String getUsername() {
		return this.nomeUsuario;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}
