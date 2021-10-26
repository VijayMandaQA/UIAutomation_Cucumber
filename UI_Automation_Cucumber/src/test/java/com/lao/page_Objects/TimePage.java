package com.lao.page_Objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TimePage {

	




	private static TimePage timePageInstance;
	
	private TimePage() {
		
	}
	
	public static TimePage getTimePageInsatnce() {
		
		if(timePageInstance==null) {
			
			timePageInstance=new TimePage();
		}
		
		return timePageInstance;
		
	}
	
	


	@FindBy(id = "employee")
	private WebElement EmployeeNameText;
	
	
	@FindBy(id = "btnView")
	private WebElement ViewButton;
	
	
	@FindBy(xpath = "//div[@class='message warning']")
	private WebElement MessageTextResult;
	
	public WebElement getEmployeeNameText() {
		return EmployeeNameText;
	}


	public WebElement getViewButton() {
		return ViewButton;
	}
	
	public WebElement getMessageTextResult() {
		return MessageTextResult;
	}
	
	
	
	
}
