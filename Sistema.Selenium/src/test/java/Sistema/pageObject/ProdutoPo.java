package Sistema.pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Rafael Lebrão
 * 
 *  data 28/06/2024
 */
public class ProdutoPo extends BasePo{

	public ProdutoPo(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "email")
	public WebElement inputEmail;
	
	@FindBy(id = "senha")
	public WebElement inputSenha;
	
	@FindBy(id = "btn-entrar")
	public WebElement buttonEntrar;
	
	@FindBy(id = "btn-adicionar")
    private WebElement buttonAdicionar;
	
	@FindBy(id = "codigo")
	public WebElement inputCodigo;
	
	@FindBy(id = "nome")
	public WebElement inputNome;
	
	@FindBy(id = "quantidade")
	public WebElement inputQuantidade;
	
	@FindBy(id = "valor")
	public WebElement inputValor;
	
	@FindBy(id = "data")
	public WebElement inputData;
	
	@FindBy(id = "btn-salvar")
    private WebElement buttonSalvar;
    
	@FindBy(id = "btn-sair")
    private WebElement buttonSair;
	
	@FindBy(css = "div.alert>span")
	public WebElement spanMensagem;
	
	@FindBy(css = "table.table-hover>tbody>tr>td>button")
	public WebElement buttonEditar;
	
	
	public String obterMensagem() {
		return this.spanMensagem.getText();
	}
	
	public void abrirModal() {
		buttonAdicionar.click();
	}
	
	public void abrirModalEditar() {
		buttonEditar.click();
	}
	
	public void sairDoModal() {
		buttonSair.click();
	}
	
	public void executarAcaoDeLogar() {
		
		inputEmail.sendKeys("admin@admin.com");
		inputSenha.sendKeys("admin@123");
		buttonEntrar.click();
		
	}
	
	public void executarAcaoDeCadastro(String codigo, String nome, String quantidade, String valor, String data) {
		
		escrever(inputCodigo,codigo);
		escrever(inputNome, nome);
		escrever(inputQuantidade, quantidade);
		escrever(inputValor, valor);
		escrever(inputData, data);
		buttonSalvar.click();
		
	}

	private void escrever(WebElement input, String texto) {
		input.clear();
		input.sendKeys(texto + Keys.TAB);
	}
		
	

	
	
	
	
	
	
	

}
