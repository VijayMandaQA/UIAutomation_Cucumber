package com.lao.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Properties;


import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


import com.lao.StepDefinitions.Common_Step_Def;
import com.lao.constants.Constants;
import com.lao.page_Objects.DirectoryPage;
import com.lao.page_Objects.HomePage;
import com.lao.page_Objects.LoginPage;
import com.lao.page_Objects.TimePage;
import com.loa.webdriver_manager.DriverManager;

public class CommonUtils {
	
	private static final Logger LOGGER=LogManager.getLogger(CommonUtils.getcommonUtilsInstance());
	private static CommonUtils commonUtilsInstance = null;

	private CommonUtils() {

	}

	public static CommonUtils getcommonUtilsInstance() {

		if (commonUtilsInstance == null) {
			commonUtilsInstance = new CommonUtils();
		}

		return commonUtilsInstance;

	}

	// config file reader
	public void loadProperties() {

		Properties properties = new Properties();

		try {
			properties.load(getClass().getResourceAsStream("/config.properties"));

		} catch (Exception e) {
			e.printStackTrace();
		}

		Constants.APP_URL = properties.getProperty("APP_URL");
		Constants.BROSWER = properties.getProperty("BROSWER");
		Constants.USERNAME = properties.getProperty("USERNAME");
		Constants.PASSWORD = properties.getProperty("PASSWORD");
		Constants.CHROME_DRIVER_LOCATION = properties.getProperty("CHROME_DRIVER_LOCATION");
		Constants.EDGE_DRIVER_LOCATION = properties.getProperty("EDGE_DRIVER_LOCATION");

	}

	public void initElements() {
		PageFactory.initElements(DriverManager.getDriver(), LoginPage.getLoginPageInstance());
		PageFactory.initElements(DriverManager.getDriver(), HomePage.getHomePageInstance());
		PageFactory.initElements(DriverManager.getDriver(), DirectoryPage.getDirectoryPageInstance());
		PageFactory.initElements(DriverManager.getDriver(), TimePage.getTimePageInsatnce());
	}

	public void takeScreenshot() {
		File screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File(Common_Step_Def.getScenarioName() + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

	public void selectFromDropDown(WebElement dropDown, String howTo, String value) {
		Select select = new Select(dropDown);
		switch (howTo) {
		case "index":
			select.selectByIndex(Integer.parseInt(value));
			break;

		case "value":
			select.selectByValue(value);
			break;

		case "text":
			select.selectByVisibleText(value);
			break;

		default:
			LOGGER.info("Please provide a valid selection in the feature file. Valid selections are: text, value, index");
			break;
		}
	}
}
