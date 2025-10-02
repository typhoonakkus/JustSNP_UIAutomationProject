package Base;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

	protected static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

	public static void createDriver() throws MalformedURLException {
		System.out.println("Creating WebDriver instance...");

		String runMode = System.getProperty("runMode", "local");
		String browser = System.getProperty("browser", "chrome").toLowerCase();
		System.out.println("Selected browser: " + browser);
		String baseURL = System.getProperty("baseURL", "https://www.saucedemo.com/");

		WebDriver driver;

		if (runMode.equalsIgnoreCase("grid")) {
			String gridURL = System.getProperty("gridURL", "http://localhost:4444/wd/hub");
			DesiredCapabilities dc = new DesiredCapabilities();

			switch (browser) {
				case "firefox":
					dc.setBrowserName("firefox");
					break;
				case "safari":
					dc.setBrowserName("safari");
					break;
				case "edge":
					dc.setBrowserName("edge");
					break;
				default:
					dc.setBrowserName("chrome");
			}

			driver = new RemoteWebDriver(new URL(gridURL), dc);

		} else {
			switch (browser) {
				case "firefox":
					WebDriverManager.firefoxdriver().setup();
					driver = new org.openqa.selenium.firefox.FirefoxDriver();
					break;
				case "safari":
					driver = new org.openqa.selenium.safari.SafariDriver();
					break;
				case "edge":
					WebDriverManager.edgedriver().setup();
					driver = new org.openqa.selenium.edge.EdgeDriver();
					break;
				default:
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
			}
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(baseURL);

		webDriver.set(driver);
	}

	public static WebDriver getDriver() {
		return webDriver.get();
	}

	public static void quitDriver() {
		WebDriver driver = webDriver.get();
		if (driver != null) {
			driver.quit();
			webDriver.remove();
		}
		System.out.println("Driver closed.");
	}
}
