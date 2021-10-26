package com.lao.StepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import com.lao.page_Objects.HomePage;
import com.lao.page_Objects.TimePage;
import com.lao.utilities.CommonUtils;
import com.loa.webdriver_manager.DriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Verify_Pending_Timesheet_Step_Def {

	private static final Logger LOGGER = LogManager.getLogger(Verify_Pending_Timesheet_Step_Def.class);

	@Given("the user is on the Home Page")
	public void the_user_is_on_the_home_page() {
		try {
			String currentURL = DriverManager.getDriver().getCurrentUrl();
			if (currentURL.contains("dashboard")) {
				LOGGER.info("the user is on the Home Page");
			}
		} catch (Exception e) {
			LOGGER.error(e);
			CommonUtils.getcommonUtilsInstance().takeScreenshot();
		}

	}

	@When("the user clicks on the time option from the menu")
	public void the_user_clicks_on_the_time_option_from_the_menu() {

		try {
			HomePage.getHomePageInstance().getTime().click();

			LOGGER.info("the user is on the Home Page");
		} catch (Exception e) {
			LOGGER.error(e);
			CommonUtils.getcommonUtilsInstance().takeScreenshot();
		}

	}

	@When("the user enters the name as {string}")
	public void the_user_enters_the_name_as(String employeeName) {
		try {
			TimePage.getTimePageInsatnce().getEmployeeNameText().sendKeys(employeeName);
			LOGGER.info("the user enters the name as {string}");
		} catch (Exception e) {
			LOGGER.error(e);
			CommonUtils.getcommonUtilsInstance().takeScreenshot();
		}

	}

	@When("clicks on the view button")
	public void clicks_on_the_view_button() {
		try {
			TimePage.getTimePageInsatnce().getViewButton().click();
			LOGGER.info("clicks on the view button");
		} catch (Exception e) {
			LOGGER.error(e);
			CommonUtils.getcommonUtilsInstance().takeScreenshot();
		}

	}

	@Then("the user should see the message as {string}")
	public void the_user_should_see_the_message_as(String expectedMessage) {

		try {
			String actualMessage = TimePage.getTimePageInsatnce().getMessageTextResult().getText();
			if (expectedMessage.equals(actualMessage)) {
				LOGGER.info("the user should see the message as {string}");
			}
		} catch (Exception e) {
			LOGGER.error(e);
			CommonUtils.getcommonUtilsInstance().takeScreenshot();
			Assert.fail(e.getMessage());
		}

	}
}
