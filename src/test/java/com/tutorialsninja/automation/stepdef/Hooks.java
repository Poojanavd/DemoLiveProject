package com.tutorialsninja.automation.stepdef;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.chrome.ChromeDriverService;

import com.tutorialsninja.automation.base.Base;
import com.tutorialsninja.automation.config.PropertyFileReader;
import com.tutorialsninja.automation.framework.Browser;
import com.tutorialsninja.automation.util.PathHelper;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	private static Logger log = Logger.getLogger(Hooks.class);
	private static ChromeDriverService service;

	@Before
	public void setUp(Scenario scenario) {
		PropertyConfigurator
				.configure(PathHelper.getResourcePath("/src/main/resources/ConfigurationFile/log4j.properties"));
		log.info("Scenario Started: " + scenario.getName());
		Base.reader = new PropertyFileReader();
		Browser.startBrowser();
		Browser.maximize();
//		service = new ChromeDriverService.Builder().usingDriverExecutable(new File(
//				"C:/Users/PRIYA.LAPTOP-FO9QFT5I/.m2/repository/org/seleniumhq/selenium/selenium-chrome-driver/3.11.0/selenium-chrome-driver-3.11.0-sources.jar"))
//				.usingAnyFreePort().build();
//		try {
//			service.start();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

	@After
	public void closeBrowser(Scenario scenario) {
		if (scenario.isFailed()) {
			scenario.embed(Browser.takeScreenshot(), "image/png");
		}
		log.info("Scenario Completed: " + scenario.getName());
		log.info("Scenario Status is: " + scenario.getStatus());
//		service.stop();
		Base.driver.quit();
	}

}
