package com.fatec.rh;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.fatec.rh.model.Funcionario;
@SpringBootTest
class CT01CadastrarFuncionario {
	@Test
	public void CT01CadastrarFuncionarioDadosValidos() {
		try {
			// cenario
			Funcionario umFuncionario;
			// acao
			umFuncionario = new Funcionario("Jose da Silva", "111111", 25.00, 10);
			// verificacao
			assertNotNull(umFuncionario);
		} catch (RuntimeException e) {
			fail("nao deve falhar");
		}
	}
	@Test
	public void CT02CadastrarFuncionarioCom_nome_invalido(){
		//cenario
		Funcionario umFuncionario;
		try{
			//acao
			umFuncionario = new Funcionario("", "111111", 25.00,10);
			fail("deveria lançar uma exceção");
		}catch(RuntimeException e){
			assertEquals("Nome invalido",e.getMessage());
		}
	}
}
