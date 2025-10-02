package Hooks;

import Base.DriverManager;
import Utility.EnvReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class hook extends DriverManager {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");

	/**
	 * Her senaryo başlamadan önce driver'ı başlatacak.
	 */
	@Before
	public void beforeScenario() {

		try {
			EnvReader.loadEnv("src/test/resources/TEST.postman_environment.json");
			createDriver();
			System.out.println("Driver başarıyla başlatıldı.");
		} catch (Exception e) {
			System.err.println("Driver başlatılamadı: " + e.getMessage());
			throw new RuntimeException("Driver başlatma hatası", e);
		}
	}

	/**
	 * Her senaryo sonunda çalışacak.
	 * Senaryo başarısız ise ekran görüntüsü alır ve Allure'a ekler.
	 * Sonrasında driver'ı kapatır.
	 */
	@After
	public void afterScenario(Scenario scenario) {
		if (scenario.isFailed()) {
			System.out.println("Hatalı senaryo - ekran görüntüsü alınıyor.");
			attachScreenshotToAllure(scenario);
		}

		quitDriver();
		System.out.println("Driver kapatıldı.");
	}

	/**
	 * Her adım sonrası ekran görüntüsü almak istersek aktif edebiliriz.
	 */
    /*
    @AfterStep
    public void afterStep(Scenario scenario) {
        attachScreenshotToAllure(scenario);
    }
    */

	/**
	 * Screenshot'u Allure raporuna ekler.
	 */
	private void attachScreenshotToAllure(Scenario scenario) {
		try {
			String timestamp = sdf.format(new Date());
			String scenarioName = scenario.getName().replaceAll(" ", "_") + "_" + timestamp;

			byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
			Allure.addAttachment(scenarioName, "image/png", new ByteArrayInputStream(screenshot), "png");

			System.out.println(" Ekran görüntüsü Allure raporuna eklendi: " + scenarioName);
		} catch (Exception e) {
			System.err.println(" Ekran görüntüsü alınamadı: " + e.getMessage());
		}
	}
}
