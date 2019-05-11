import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class cadastrarDemanda {
	
	public static void cadastrar(String codigo, String nome, String tipo, String cenarios) {
		// TODO Auto-generated method stub]
		
		WebDriverWait wait = new WebDriverWait(ExecutarTestes.driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Cadastrar")));
	
		ExecutarTestes.driver.findElement(By.linkText("Cadastrar")).click();
		ExecutarTestes.driver.findElement(By.id("codigo")).sendKeys(codigo);
		ExecutarTestes.driver.findElement(By.id("nome")).sendKeys(nome);
		if(tipo=="2"){
			ExecutarTestes.driver.findElement(By.xpath("//input[@name='tipo' and @value='2']")).click();
		} else{
			ExecutarTestes.driver.findElement(By.xpath("//input[@name='tipo' and @value='1']")).click();
			ExecutarTestes.driver.findElement(By.id("cenarios")).sendKeys(cenarios);
		}
		ExecutarTestes.driver.findElement(By.xpath("//*[@id='form_cliente']/div/table/tbody/tr/td/button")).click();
		
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class, 'alert alert-success')]")));
			System.out.println("Mensagem de Sucesso Exibida");
		} catch (Exception e) {
			System.out.println("Não Exibiu Mensagem de Sucesso");
		}
		
	}
}
