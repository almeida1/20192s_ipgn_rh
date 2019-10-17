package com.fatec.rh;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RhApplicationTests {

	@Test
	public void CT01CadastrarFuncionarioDadosValidos(){
		try{
			//cenario
			Funcionario umFuncionario;
			//acao
			umFuncionario = new Funcionario("Jose da Silva", "111111", 25.00);
			//verificacao
			assertNotNull (umFuncionario);
		}catch(RuntimeException e){
			fail ("nao deve falhar");
		}
	}


}
