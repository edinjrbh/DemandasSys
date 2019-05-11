import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class editarDemanda {
	
	public static void editar(String codigo, String codigoEditado, String nome, String tipo, String cenarios) {
		// TODO Auto-generated method stub]
		
		WebDriverWait wait = new WebDriverWait(ExecutarTestes.driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Painel")));
		ExecutarTestes.driver.findElement(By.linkText("Painel")).click();
		
		ExecutarTestes.driver.findElement(By.name("pesquisa_demanda")).sendKeys(codigo);
		ExecutarTestes.driver.findElement(By.xpath("//*[@id='search']/button[1]")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='editar']")));
		ExecutarTestes.driver.findElement(By.xpath("//*[@id='editar']")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.id("codigo_editar")));
		ExecutarTestes.driver.findElement(By.id("codigo_editar")).clear();
		ExecutarTestes.driver.findElement(By.id("codigo_editar")).sendKeys(codigoEditado);
		ExecutarTestes.driver.findElement(By.id("nome_editar")).clear();
		ExecutarTestes.driver.findElement(By.id("nome_editar")).sendKeys(nome);
		if(tipo=="2"){
			ExecutarTestes.driver.findElement(By.xpath("//input[@name='tipo' and @value='2']")).click();
		} else{
			ExecutarTestes.driver.findElement(By.xpath("//input[@name='tipo' and @value='1']")).click();
			ExecutarTestes.driver.findElement(By.id("cenarios_editar")).clear();
			ExecutarTestes.driver.findElement(By.id("cenarios_editar")).sendKeys(cenarios);
		}
		ExecutarTestes.driver.findElement(By.id("teste")).click();
		
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class, 'alert alert-success')]")));
			System.out.println("Mensagem de Sucesso Exibida");
		} catch (Exception e) {
			System.out.println("Não Exibiu Mensagem de Sucesso");
		}
		
	}
}
