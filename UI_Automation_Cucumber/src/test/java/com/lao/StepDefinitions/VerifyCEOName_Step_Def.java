package com.lao.StepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.lao.page_Objects.DirectoryPage;
import com.lao.page_Objects.HomePage;
import com.lao.utilities.CommonUtils;
import com.loa.webdriver_manager.DriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VerifyCEOName_Step_Def {
	private static final Logger LOGGER = LogManager.getLogger(VerifyCEOName_Step_Def.class);

	@Given("the user is logged in successfully and is on Home Page")
	public void the_user_is_logged_in_successfully_and_is_on_home_page() {
		// Write code here that turns the phrase above into concrete actions

		try {
		

			String currentUrl = DriverManager.getDriver().getCurrentUrl();

			if (currentUrl.contains("dashboard")) {
				LOGGER.info("the user is logged in successfully and is on Home Page");
			}
		} catch (Exception e) {
			LOGGER.error(e);
			CommonUtils.getcommonUtilsInstance().takeScreenshot();
		}

	}

	@When("the user clicks on the directory option from the Menu bar")
	public void the_user_clicks_on_the_directory_option_from_the_menu_bar() {
		// Write code here that turns the phrase above into concrete actions

		try {
			HomePage.getHomePageInstance().getDirectory().click();

			LOGGER.info("the user clicks on the directory option from the Menu bar");

		} catch (Exception e) {
			LOGGER.error(e);
			CommonUtils.getcommonUtilsInstance().takeScreenshot();
		}

	}

	@When("the user selects the job title as {string} from the dropdown and using {string}")
	public void the_user_selects_the_job_title_as_from_the_dropdown(String jobTitle, String howTo) {
		// Write code here that turns the phrase above into concrete actions

		try {
			CommonUtils.getcommonUtilsInstance().
			selectFromDropDown(DirectoryPage.getDirectoryPageInstance().getJob_Title(), howTo, jobTitle);

			LOGGER.info("the user selects the job title as {string} from the dropdown");
		} catch (Exception e) {
			LOGGER.error(e);
			CommonUtils.getcommonUtilsInstance().takeScreenshot();
		}

	}

	@When("clicks the search button")
	public void clicks_the_search_button() {

		try {
			DirectoryPage.getDirectoryPageInstance().getSearch_Button().click();
			LOGGER.info("clicks the search button");
		} catch (Exception e) {
			LOGGER.error(e);
			CommonUtils.getcommonUtilsInstance().takeScreenshot();
		}

	}

	@Then("the user should see the CEO name as {string}")
	public void the_user_should_see_the_ceo_name_as(String expectedName) {

		try {
			String actualName = DirectoryPage.getDirectoryPageInstance().getCEO_Name().getText();

			if (actualName.equalsIgnoreCase(expectedName)) {
				LOGGER.info("the user should see the CEO name as {string}");
			}
		} catch (Exception e) {
			LOGGER.error(e);
			CommonUtils.getcommonUtilsInstance().takeScreenshot();
		}

	}

}
