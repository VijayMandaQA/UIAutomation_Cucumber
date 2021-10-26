 package com.lao.page_Objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DirectoryPage {


	private static DirectoryPage directoryPageInstance;
	
	private DirectoryPage() {
		
	}
	
	public static DirectoryPage getDirectoryPageInstance() {
		
		if(directoryPageInstance==null) {
			directoryPageInstance=new DirectoryPage();
		}
		return directoryPageInstance;
		
	}
	
	
	
	@FindBy(id = "searchDirectory_job_title")
	private WebElement Job_Title;

	@FindBy(id = "searchBtn")
	private WebElement Search_Button;

	@FindBy(xpath = "//b[text()='John Smith']")
	private WebElement CEO_Name;
	
	public WebElement getJob_Title() {
		return Job_Title;
	}

	public WebElement getSearch_Button() {
		return Search_Button;
	}

	public WebElement getCEO_Name() {
		return CEO_Name;
	}
	

}
