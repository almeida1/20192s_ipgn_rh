package com.fatec.rh.controller;



import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fatec.rh.model.Funcionario;
import com.fatec.rh.servico.ServiceFuncionario;

@Controller
@RequestMapping(path = "/rh")
public class FuncionarioController {
	Logger logger = LogManager.getLogger(FuncionarioController.class);
	@Autowired
	private ServiceFuncionario servico;
	@GetMapping("/cadastrar")
	public ModelAndView retornaFormDeCadastroDe(Funcionario funcionario) {
		logger.info("entrou no cadastrar");
		ModelAndView mv = new ModelAndView("cadastrarFuncionario");
		mv.addObject("funcionario", funcionario);
		return mv;
	}
	@PostMapping("/save")
	public ModelAndView save(@Valid Funcionario funcionario, BindingResult result) {
		ModelAndView modelAndView = new ModelAndView("consultarFuncionario");
		double salarioBruto = servico.salarioBruto(funcionario.getValorHora(), funcionario.getHorasTrabalhadas()); 
		double salarioLiquido = servico.salarioLiquido(salarioBruto);
		if (result.hasErrors()) {
			modelAndView.setViewName("cadastrarFuncionario");
		} else {
			servico.save(funcionario);
			modelAndView.addObject("funcionarios", servico.findAll());
			modelAndView.setViewName("consultarFuncionario");
		}
		return modelAndView;
	}
	@GetMapping("/consultar")
	public ModelAndView retornaFormDeConsultaTodosFuncionarios() {
		ModelAndView modelAndView = new ModelAndView("consultarLivro");
		modelAndView.addObject("livros", servico.findAll());
		return modelAndView;
	}
}
