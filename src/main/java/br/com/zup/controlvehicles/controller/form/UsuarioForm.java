package br.com.zup.controlvehicles.controller.form;

import javax.validation.constraints.NotBlank;

import br.com.zup.controlvehicles.entity.Usuario;


public class UsuarioForm {
	
	@NotBlank
	private String nome = "";
	
	@NotBlank
	private String email = "";
	
	@NotBlank
	private String cpf = "";
	
	@NotBlank
	private String dataNascimento = "";
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public Usuario converteParaUsuario() {
		Usuario usuario = new Usuario();
		
		usuario.setNome(nome);
		usuario.setEmail(email);
		usuario.setCpf(cpf);
		usuario.setDataNascimento(dataNascimento);
		
		return usuario;
	}
}
