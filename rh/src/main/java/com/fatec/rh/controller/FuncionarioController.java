package com.fatec.rh.controller;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fatec.rh.model.Funcionario;

@Controller
@RequestMapping(path = "/rh")
public class FuncionarioController {
	Logger logger = LogManager.getLogger(FuncionarioController.class);
	@GetMapping("/cadastrar")
	public ModelAndView retornaFormDeCadastroDe(Funcionario funcionario) {
		logger.info("entrou no cadastrar");
		ModelAndView mv = new ModelAndView("cadastrarFuncionario");
		mv.addObject("funcionario", funcionario);
		return mv;
	}
}
