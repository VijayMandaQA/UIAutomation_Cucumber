package com.lao.StepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.lao.constants.Constants;
import com.lao.page_Objects.LoginPage;
import com.lao.utilities.CommonUtils;
import com.loa.webdriver_manager.DriverManager;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Common_Step_Def {

	
	private static String scenarioName=null;
	
	public static String getScenarioName() {
		return scenarioName;
	}

	
	private static final Logger LOGGER=LogManager.getLogger(Common_Step_Def.class);

	@Before
	public void beforeScenario(Scenario scenario) {
		LOGGER.info("Execution Started");
		try {
			
			scenarioName=scenario.getName();
			LOGGER.info("Instantiating the CommonUtils");
			
			LOGGER.info("Loading the properties file");
			CommonUtils.getcommonUtilsInstance().loadProperties();
			LOGGER.info("Checking the driver is Null or Not?");

			if (DriverManager.getDriver()== null) {
				LOGGER.info("Driver is null, instatiating it");
				DriverManager.launchBrowser();
				CommonUtils.getcommonUtilsInstance().initElements();
				login();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void login() {
		DriverManager.getDriver().get(Constants.APP_URL);
		LoginPage.getLoginPageInstance().getUsername().sendKeys(Constants.USERNAME);
		LoginPage.getLoginPageInstance().getPassword().sendKeys(Constants.PASSWORD);
		LoginPage.getLoginPageInstance().getLogin().click();
		
	}

	
}
