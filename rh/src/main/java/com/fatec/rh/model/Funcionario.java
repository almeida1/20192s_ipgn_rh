package com.fatec.rh.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Funcionario {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	String nome;
	String rg;
	double valorHora;
	int horasTrabalhadas;
	public Funcionario(String umNome, String umRg, double valorHora, int horas) {
		setNome(umNome);
		setRg(umRg);
		setValorHora(valorHora);
		
	}
	
	public Funcionario() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		if (nome.equals("") | nome.equals(null)) {
			throw new RuntimeException("Nome invalido");
		} else {
			this.nome = nome;
		}
	}
	public String getNome() {
		return nome;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public double getValorHora() {
		return valorHora;
	}
	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}
	
	public int getHorasTrabalhadas() {
		return horasTrabalhadas;
	}

	public void setHorasTrabalhadas(int horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}

	
}
