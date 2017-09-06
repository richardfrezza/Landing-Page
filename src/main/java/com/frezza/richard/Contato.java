package com.frezza.richard;

import java.util.Date;
import java.util.Map;



public class Contato implements Parseable{
	
	String nome;
	String email;
	String telefone;
        String mensagem;
        
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
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	 @Override
	    public String toString() {
	        	 StringBuilder stb = new StringBuilder();
		 stb.append("{");
		 stb.append("\"nome\":\""+nome+"\",");
		 stb.append("\"email\":\""+email+"\",");
		 stb.append("\"telefone\":\""+telefone+"\",");
		 stb.append("\"mensagem\":\""+mensagem+"\",");
		 stb.append("}");
		 return stb.toString();
	    }
	 @Override
	 public void parse(Map<String, String> dados) {
	    nome = dados.get("nome");
	    email= dados.get("email");
	    telefone = dados.get("telefone");
            mensagem = dados.get("mensagem");
	 }
}
