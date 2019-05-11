import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExecutarTestes {

	static WebDriver driver;

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		logarSistema.logar("edison.junior", "frame2019");
		cadastrarDemanda.cadastrar("9999900002","Demanda Automatizada", "1","03");
		editarDemanda.editar("99999","99998","Demanda Automatizada Edição", "1","03");
		detalharDemanda.alterarResponsavel("99998","0","Edison  Junior");
		driver.close();
	}
}
