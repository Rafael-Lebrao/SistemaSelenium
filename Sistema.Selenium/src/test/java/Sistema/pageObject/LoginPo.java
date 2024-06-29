package Sistema.pageObject;


import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * @author Rafael Lebrão
 * 
 *  data 28/06/2024
 */
// não esquecer do extends!!!
public class LoginPo extends BasePo{
	

	public LoginPo(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "email")
	public WebElement inputEmail;
	
	@FindBy(id = "senha")
	public WebElement inputSenha;
	
	@FindBy(id = "btn-entrar")
	public WebElement buttonEntrar;
	
	@FindBy(css = "form.form-login>div.alert>span")
	public WebElement spanMensagem;
	
	@FindBy(id = "email")
    private WebElement campoEmail;

    @FindBy(id = "senha")
    private WebElement campoSenha;
    
    @FindBy(id = "btn-adicionar")
    private WebElement buttonAdicionar;
	
	
	public String obterMensagem() {
		return this.spanMensagem.getText();
	}
	
	
	public void executarAcaoDeLogar(String email, String senha) {
		
		escrever(inputEmail, email);
		escrever(inputSenha, senha);
		buttonEntrar.click();
		
	}


	private void escrever(WebElement input, String texto) {
		input.clear();
		input.sendKeys(texto + Keys.TAB);
	}
	
	public String getValorCampoEmail() {
        return campoEmail.getAttribute("value");
    }

    public String getValorCampoSenha() {
        return campoSenha.getAttribute("value");
    }
    
    //testando
    public boolean isButtonAdicionarVisible() {
        try {
            return buttonAdicionar.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
