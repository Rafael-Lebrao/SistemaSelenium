package Sistema.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import Sistema.pageObject.LoginPo;


public class LoginTest extends BaseTest{
	
	private static LoginPo loginPage;

	@BeforeClass
	public static void prepararTestes() {
		loginPage = new LoginPo(driver);
	}
	
	@Test
	public void Tc001_NaoDeveLogarNoSistemaComEmailESenhaVazio() {
		
		// Executar a ação de logar com email e senha vazios
		loginPage.executarAcaoDeLogar("", "");
		
		// Verificar se o elemento pós-login está visível
		String mensagem = loginPage.obterMensagem();
		
		// Verificar que a mensagem não mudou
		assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");
		// Verificar que a URL não mudou
	    assertEquals("file:///C:/Users/36124872022.2n/Desktop/TesteDeSoft/sistema/login.html", driver.getCurrentUrl());
	    // Verificar se o valor do campo de email é vazio
	    assertEquals("", loginPage.getValorCampoEmail());
	    // Verificar se o valor do campo de senha é vazio
	    assertEquals("", loginPage.getValorCampoSenha());
        
	}
	
	@Test
	public void Tc002_NaoDeveLogarNoSistemaComEmailErradoESenhaVazio() {
		
		//Executar a ação de logar com email Errado e senha vazia
		loginPage.executarAcaoDeLogar("teste", "");
		
		// Verificar se o elemento pós-login está visível
		String mensagem = loginPage.obterMensagem();
		
		// Verificar que a mensagem não mudou
		assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");
		// Verificar que a URL não mudou
	    assertEquals("file:///C:/Users/36124872022.2n/Desktop/TesteDeSoft/sistema/login.html", driver.getCurrentUrl());
	    // Verificar se o valor do campo de senha é vazio
	    assertEquals("", loginPage.getValorCampoSenha());
        
	}
	
	@Test
	public void Tc003_DeveLogarNoSistemaComEmailESenhaCorreto() {
		
		//Executar a ação de logar com email e senha corretos
		loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");
		
		// Verificar se a URL mudou após o login
        String expectedUrl = "file:///C:/Users/36124872022.2n/Desktop/TesteDeSoft/sistema/produtos.html?teste=123";
        String actualUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl);
     // Verificar se o botão "Adicionar" está visível após o login
        assertTrue(loginPage.isButtonAdicionarVisible());
		
	
        
	}

}
