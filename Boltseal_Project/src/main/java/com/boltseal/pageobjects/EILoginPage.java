package com.boltseal.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EILoginPage {
	
	@FindBy(name="iec")
	private WebElement adminTxtBx;
	
	@FindBy(name="password")
	private WebElement passTxtBx;
	
	@FindBy(xpath = "(//span[text()='LOGIN'])[1]")
	private WebElement loginBtn;
	
	public EILoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void login(String admin, String Pass) {
		adminTxtBx.sendKeys(admin);
		passTxtBx.sendKeys(Pass);
		loginBtn.click();
	}
	

}
