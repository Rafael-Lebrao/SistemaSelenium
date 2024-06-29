package Sistema.test;


import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import Sistema.pageObject.ProdutoPo;


public class ProdutoTest extends BaseTest{

	private static ProdutoPo produtoPage;

	@BeforeClass
	public static void prepararTestes() {
		produtoPage = new ProdutoPo(driver);
	}
	
	
	@Test
	public void Tc001_NaoDeveSerPossivelCriarProdutoComOsCamposVazios() {
		
		// Logando
		produtoPage.executarAcaoDeLogar();
		
		// Abrindo modal
		produtoPage.abrirModal();
		produtoPage.abrirModal();
		
		// Executar a ação de cadastro de produto com campos vazios
		produtoPage.executarAcaoDeCadastro("", "", "", "", "");
		
		

		String mensagem = produtoPage.obterMensagem();
		
		// Verificar que a mensagem não mudou
		assertEquals(mensagem, "Todos os campos são obrigatórios para o cadastro!");
		// Verificar que a URL não mudou
	    assertEquals("file:///C:/Users/36124872022.2n/Desktop/TesteDeSoft/sistema/produtos.html?teste=123#", driver.getCurrentUrl());
	
        
	}
	
	
	@Test
	public void Tc002_NaoDeveSerPossivelCriarProdutoComCadastroIncompleto() {
		
		// Logando
		produtoPage.executarAcaoDeLogar();
		
		// Abrindo modal
		produtoPage.abrirModal();
		produtoPage.abrirModal();
		
		// Executar a ação de cadastro de produto com campos vazios
		produtoPage.executarAcaoDeCadastro("01","teste", "", "", "");
		
		// Verificar se o elemento pós-login está visível
		String mensagem = produtoPage.obterMensagem();
		
		// Verificar que a mensagem não mudou
		assertEquals(mensagem, "Todos os campos são obrigatórios para o cadastro!");
		// Verificar que a URL não mudou
	    assertEquals("file:///C:/Users/36124872022.2n/Desktop/TesteDeSoft/sistema/produtos.html?teste=123#", driver.getCurrentUrl());
	
        
	}
	
	@Test
	public void Tc003_DeveSerPossivelEditarProduto() {
		
		// Logando
		produtoPage.executarAcaoDeLogar();
		
		// Abrindo modal
		produtoPage.abrirModal();
		produtoPage.abrirModal();
		
		// Executar a ação de cadastro de produto com campos vazios
		produtoPage.executarAcaoDeCadastro("01","teste", "50", "50", "04072024");
		
		// saindo do madal
		produtoPage.sairDoModal();
		
		// Tentando Abrir modal de editar
		produtoPage.abrirModalEditar();
		
		
		// Verificar que a URL não mudou
	    assertEquals("file:///C:/Users/36124872022.2n/Desktop/TesteDeSoft/sistema/produtos.html?teste=123#", driver.getCurrentUrl());
	
        
	}
	
	
	

	
	
	
	
	
	
	
}
