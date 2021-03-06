package com.fatec.rh;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.fatec.rh.model.Funcionario;

@SpringBootTest
class RhApplicationTests {

	@Test
	public void CT01CadastrarFuncionarioDadosValidos(){
		try{
			//cenario
			Funcionario umFuncionario=null;
			//acao
			umFuncionario = new Funcionario("Jose da Silva", "111111", 25.00,10);
			//verificacao
			assertNotNull (umFuncionario);
		}catch(RuntimeException e){
			fail ("nao deve falhar");
		}
	}


}
