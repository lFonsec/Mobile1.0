package com.example.lucas.multimidia.model;

public class Autor {

	public static String[] colunas = new String[] { "_id", "nome", "endereco", "cpf" };

	/**
	 * Pacote do Content Provider. Precisa ser único.
	 */

	private long _id;
	private String nome;
	private String endereco;
	private String cpf;

	public Autor() {
	}

	public Autor(String nome, String endereco, String cpf) {
		super();
		this.setNome(nome);
		this.setEndereco(endereco);
		this.setCpf(cpf);
	}

	public Autor(long _id, String nome, String endereco, String cpf) {
		super();
		this.setId(_id);
		this.setNome(nome);
		this.setEndereco(endereco);
		this.setCpf(cpf);
	}

	public long getId() {
		return _id;
	}

	public void setId(long _id) {
		this._id = _id;
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

	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	
}
