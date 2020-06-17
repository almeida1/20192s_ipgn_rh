package com.fatec.rh.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.rh.model.Funcionario;
import com.fatec.rh.model.FuncionarioRepository;

@Service
public class ServiceFuncionario {
	@Autowired
	FuncionarioRepository repository;
	public double salarioBruto(double valorHora, int nroHorasTrabalhadas) {
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
	public void save(Funcionario funcionario) {
		repository.save(funcionario);
	}
	public Iterable<Funcionario> findAll() {
		return repository.findAll();
	}
}
