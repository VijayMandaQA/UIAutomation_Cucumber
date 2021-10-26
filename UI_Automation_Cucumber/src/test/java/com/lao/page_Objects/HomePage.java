package com.lao.page_Objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	

	private static HomePage homePageInstance;
	
	private HomePage() {
		
	}
	
	public static HomePage getHomePageInstance() {
		if(homePageInstance==null) {
			homePageInstance =new HomePage();
		}
		
		return homePageInstance;
		
	}

	@FindBy(id = "menu_directory_viewDirectory")
	private WebElement Directory;
	
	@FindBy(id = "menu_time_viewTimeModule")
	private WebElement Time;
	
	public WebElement getDirectory() {
		return Directory;
	}
	
	public WebElement getTime() {
		return Time;
	}
	
	
	
}
