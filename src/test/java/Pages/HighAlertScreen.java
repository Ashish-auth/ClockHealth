package Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.lang.invoke.MethodHandles.Lookup.ClassOption;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Driver;

import Utility.TestUtil;
import net.bytebuddy.asm.Advice.This;
import testBase.TestBase;
//import testClasses.string;

public class HighAlertScreen extends TestBase{
	@FindBy(xpath = "//*[@aria-posinset=\"1\"]")
	WebElement highalert_tab;

	@FindBy(xpath = "//table/tbody/tr[1]/td[1]")
	WebElement click_on_patient;
	
	@FindBy(xpath="//mat-card[1]/div[1]/div[5]/div[1]/img[1]")
	WebElement medication_Icon;
	
	@FindBy(xpath="//mat-tab-header/div[2]")
	WebElement tabsHeader;
		
	@FindBy(xpath="//mat-tab-header[1]/div[2]/div[1]/div[1]/div[1]")
	WebElement prescription_Tab;
	
	@FindBy(xpath="//div[@id='mat-tab-label-2-1']")
	WebElement medication_Tab;
	
	@FindBy(xpath="//div[@id='mat-tab-label-2-2']")
	WebElement adherence_Tab;
	
	//@FindBy(id="mat-input-10")
	@FindBy(xpath="//mat-form-field[1]/div[1]/div[1]/div[3]/input[1]")
	WebElement title;
		
	//@FindBy(xpath="//div[@class='file-input']")
	//WebElement upload;
	
	@FindBy(xpath = "//div[@class='file-input']/input")
	WebElement upload;

	
	@FindBy(xpath="//button[@class='mat-focus-indicator save-button mat-flat-button mat-button-base']")
	WebElement saveButton;
	
	@FindBy(xpath="//img[@class='pres-delete ng-star-inserted']")
	WebElement deleteIcon;
	
	@FindBy(id="mat-dialog-0")
	WebElement dialogbox;
	
	@FindBy(xpath="//button[@class='mat-focus-indicator mat-raised-button mat-button-base mat-primary']")
	WebElement yesButton;
	
	@FindBy(xpath="//button[@class='mat-focus-indicator buttons disable-outline mat-button mat-button-base']")
	WebElement noButton;
	
	@FindBy(xpath="//div[@class='hot-toast-bar-base']")
	WebElement errorMsg;
	
	@FindBy(xpath="//label[@aria-owns='mat-input-2']")
	WebElement titleLabel;
	public final static String workingdir=System.getProperty("user.dir");
	public static String path =workingdir + "/ChcProject/src/test/java/Meds.jpg";
	
	public  HighAlertScreen() {

		PageFactory.initElements(driver, this);
	}

	public void HighAlert_Tab() {
		highalert_tab.click();
		click_on_patient.click();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
		medication_Icon.click();
	}
	
	public void Tabs_Available()
	{
		if(tabsHeader.getText().contains("Prescription")&tabsHeader.getText().contains("Medication")&tabsHeader.getText().contains("Adherence"))
		{
		System.out.println("Prescription,Medication and Adherence tabs are available");
		}
		else
		{		
			System.out.println("Test Fail");
		}
		
	}
	
	public void Prescription_Tab()
	{
		//driver.setFileDetector=new LocalFileDetector();
		prescription_Tab.click();
		title.sendKeys("Meds");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		//upload.click();
		upload.sendKeys("C:\\Users\\Prasanna Lakshmi\\OneDrive - XYRAM SOFTWARE SOLUTIONS PRIVATE LIMITED\\Desktop\\CHC\\Meds.jpg");
		saveButton.click();
		
	}
	public void Prescription_Delete()
	{
		deleteIcon.click();
		if(dialogbox.isDisplayed())
		{
		noButton.click();
			
		}
		
			
}
	public void NotAccepting_TextFile() 
	{
		prescription_Tab.click();
		title.sendKeys("Meds");
		upload.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		upload.sendKeys("C:\\Users\\Prasanna Lakshmi\\OneDrive - XYRAM SOFTWARE SOLUTIONS PRIVATE LIMITED\\Desktop\\CHC\\med1.txt");
		saveButton.click();
		
	}
	public void Prescription_Title()
	{
		String label=titleLabel.getText();
		if(label.contains("Title *"))
		{
			System.out.println("* is available");
			
		}
		
		title.sendKeys("");
		saveButton.click();
		String actual_Msg=errorMsg.getText();
		System.out.println(actual_Msg);
		String expected_Msg="Enter prescription title";
		if(actual_Msg.contains(expected_Msg))
		{
			logger.info(expected_Msg+"is Matched");
		}
		else
		{
			logger.info(expected_Msg+"Does not Match");
		}
		
		//Assert.assertEquals(actual_Msg, expected_Msg);
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		//System.out.println(errorMsg.getText());
		
	}
	public boolean Upload_Clickable()
	{
		return upload.isEnabled();
	}
	
	
	public void Prescriptiontab_Color()
	{
		Color prescriptiontabColor=Color.fromString(prescription_Tab.getCssValue("background-color"));
		System.out.println(prescriptiontabColor);		
		System.out.println( prescriptiontabColor.asRgba().equals("rgba(0, 101, 149, 1)"));
		
	}
	
