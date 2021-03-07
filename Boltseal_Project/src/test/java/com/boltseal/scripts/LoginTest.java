package com.boltseal.scripts;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.boltseal.generic.BaseLib;
import com.boltseal.pageobjects.EILoginPage;
import com.boltseal.pageobjects.LoginPage;
import com.google.common.io.Files;

public class LoginTest extends BaseLib {
	
	@Test
	public void validSeal() throws InterruptedException, FileNotFoundException {
		String admin="8004543017";
		String pass="Sudhish@1997";
		LoginPage lp=new LoginPage(driver);
		lp.getCustomerLogin().click();
		EILoginPage el= new EILoginPage(driver);
		el.login(admin, pass);
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//button[text()='OK'])[1]")).click();
		driver.findElement(By.xpath("(//h3[text()='Affix Seals'])")).click();
		Thread.sleep(4000);
		
		
		driver.findElement(By.xpath("//input[@placeholder='RFID No.']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='RFID No.']")).sendKeys("BOLT01435912");
		driver.findElement(By.xpath("//button[text()='Check Seal']")).click();
		
		Thread.sleep(4000);
		
		TakesScreenshot ts= (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots/pass.png"); 
		
		try {
			Files.copy(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporter.log("Screenshot taken",true);
		
	
	}
	
	@Test
	public void InvalidSeal() throws InterruptedException {
		String admin="8004543017";
		String pass="Sudhish@1997";
		LoginPage lp=new LoginPage(driver);
		lp.getCustomerLogin().click();
		EILoginPage el= new EILoginPage(driver);
		el.login(admin, pass);
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//button[text()='OK'])[1]")).click();
		driver.findElement(By.xpath("(//h3[text()='Affix Seals'])")).click();
		Thread.sleep(4000);
		
		
		driver.findElement(By.xpath("//input[@placeholder='RFID No.']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='RFID No.']")).sendKeys("BOLT10913173");
		driver.findElement(By.xpath("//button[text()='Check Seal']")).click();
		
		Thread.sleep(4000);
		TakesScreenshot ts= (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots/fail.png"); 
		
		try {
			Files.copy(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporter.log("Screenshot taken",true);
	}
	
}
