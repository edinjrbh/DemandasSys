import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class detalharDemanda {
	
	public static void alterarResponsavel(String codigo, String finalizada, String nome) {
		// TODO Auto-generated method stub]
		
		WebDriverWait wait = new WebDriverWait(ExecutarTestes.driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Painel")));
		ExecutarTestes.driver.findElement(By.linkText("Painel")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.name("pesquisa_demanda")));
		ExecutarTestes.driver.findElement(By.name("pesquisa_demanda")).sendKeys(codigo);
		
		if(finalizada=="0"){
			ExecutarTestes.driver.findElement(By.xpath("//input[@name='finalizada' and @value='0']")).click();
		} else{
			ExecutarTestes.driver.findElement(By.xpath("//input[@name='tipo' and @value='1']")).click();
		}
		ExecutarTestes.driver.findElement(By.xpath("//*[@id='search']/button[1]")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.id("detalhar")));
		ExecutarTestes.driver.findElement(By.id("detalhar")).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cancelar")));
				
		Select responsavel = new Select(ExecutarTestes.driver.findElement(By.id("responsavel")));
		responsavel.selectByVisibleText(nome);
		
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class, 'label label-success')]")));
			System.out.println("Mensagem de Sucesso Exibida");
		} catch (Exception e) {
			System.out.println("Não Exibiu Mensagem de Sucesso");
		}
		
	}

}
