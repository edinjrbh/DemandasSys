import org.openqa.selenium.By;

public class logarSistema {

	public static void logar(String login, String senha){
		ExecutarTestes.driver.get("https://demandas-sys.000webhostapp.com/");
		ExecutarTestes.driver.findElement(By.id("login")).sendKeys(login);
		ExecutarTestes.driver.findElement(By.id("senha")).sendKeys(senha);
		ExecutarTestes.driver.findElement(By.xpath("//input[@value='Logar']")).click();
	}
}
