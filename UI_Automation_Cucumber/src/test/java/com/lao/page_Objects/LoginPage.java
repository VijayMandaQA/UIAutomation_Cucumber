package com.lao.page_Objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	private static LoginPage loginPageInstance;
	
	private LoginPage() {
		
	}
	
	public static LoginPage getLoginPageInstance() {
		
		if(loginPageInstance==null) {
			loginPageInstance=new LoginPage();
		}
		return loginPageInstance;
		
	}
	
	

	@FindBy(id = "txtUsername")
	private WebElement Username;
	
	@FindBy(id = "txtPassword")
	private WebElement Password;
	
	@FindBy(id = "btnLogin")
	private WebElement Login;
	
	public WebElement getUsername() {
		return Username;
	}

	public WebElement getPassword() {
		return Password;
	}

	public WebElement getLogin() {
		return Login;
	}
	
}
