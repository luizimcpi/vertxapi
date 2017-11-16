package com.concrete.vertxapi.entities;

import java.util.concurrent.atomic.AtomicInteger;

public class Contato {

	private static final AtomicInteger COUNTER = new AtomicInteger();

	private final int id;

	private String nome;

	private String telefone;

	public Contato(String nome, String telefone) {
		this.id = COUNTER.getAndIncrement();
		this.nome = nome;
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getId() {
		return id;
	}

}
