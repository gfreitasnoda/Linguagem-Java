package br.com.projeto.testeinicio.dao.teste;





import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.projeto.testeinicio.dao.DAOPessoa;
import br.com.projeto.testeinicio.domain.Pessoa;

public class TesteDAOPessoa {
		
		@Test
		public void testSalvar(){
				DAOPessoa dp = new DAOPessoa();
				
				Pessoa pe = new Pessoa();
				pe.setId(50);
				pe.setNome("Márcia");
				pe.setEmail("marcia@bol.com.br");
				
				String rs = dp.salvar(pe);
				
				Assertions.assertEquals("Seus dados foram recebidos",rs); 
			}
		@Test
		public void testPessoAtualizada() {
			
			DAOPessoa dp = new DAOPessoa();
			
			Pessoa pe = new Pessoa(10, "Mauro", "mauro@bol.com");
			String rs = dp.salvar(pe);
			System.out.println(pe.getNome());
			pe.setNome("Márcia");
			Pessoa rsp = dp.pessoAtualizada(pe);
			
			Assertions.assertEquals("Márcia", rsp.getNome());
		}
}
