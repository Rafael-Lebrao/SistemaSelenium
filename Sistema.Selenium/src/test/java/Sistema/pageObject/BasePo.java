package Sistema.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Classe base para a criação das novas PageObjects
 * Todas as pages devem herdar esta classe
 * @author Rafael Lebrão
 * 
 * data 28/06/2024
 * 
 */
public class BasePo {

	/**Driver base que será usado pelas pages*/
	protected WebDriver driver;
	
	/**
	 * Construtor base para a criação da fábrica de elementos (PageFactory)
	 * @param driver (Driver do navegador atual)
	 */
	public BasePo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		
	
}
