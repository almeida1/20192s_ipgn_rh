package com.fatec.rh;

public class Funcionario {
	String nome;
	String rg;
	double valorHora;
	public Funcionario(String umNome, String umRg, double umValorHora) {
		setNome(umNome);
		setRg(umRg);
		setValorHora(umValorHora);
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
	public double salarioBruto(int nroHorasTrabalhadas) {
		return (valorHora * nroHorasTrabalhadas);
	}
	public double salarioLiquido(double salarioBruto) {
		double inss = salarioBruto * 0.1;
		double ir = 0; // Se salario < 2000
		if ((salarioBruto >= 2000) && (salarioBruto < 5000.0))
			ir = salarioBruto * 0.15;
		if (salarioBruto > 5000)
			ir = salarioBruto * 0.275;
		return (salarioBruto - inss - ir);
	}
}
