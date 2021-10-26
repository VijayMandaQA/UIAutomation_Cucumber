package com.loa.webdriver_manager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.lao.constants.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

	public static WebDriver getDriver() {
		return driver;
	}
	private static WebDriver driver=null;
	private static final Logger LOGGER=LogManager.getLogger(DriverManager.class);
	public static void launchBrowser() {
		try {

			switch (Constants.BROSWER) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				LOGGER.info("Launching "+Constants.BROSWER);
				driver = new ChromeDriver();
				break;

			case "edge":
				WebDriverManager.edgedriver().setup();
				LOGGER.info("Launching "+Constants.BROSWER);
				driver = new EdgeDriver();
			default:
				WebDriverManager.chromedriver().setup();
				LOGGER.info("Launching "+Constants.BROSWER);
				driver = new ChromeDriver();
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
