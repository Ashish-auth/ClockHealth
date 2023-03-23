package testClasses;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.Dashboard;
import Pages.LoginPage;
import testBase.TestBase;
import Pages.HighAlertScreen;

public class HighAlert_ScreenTest extends TestBase {
	
	LoginPage loginPage;
	Dashboard dashboard;
	//Dashboard highAlert;
	//HighAlertScreen highAlert;
	HighAlertScreen high_Alert;
	
	
	public HighAlert_ScreenTest() {
		super();
	}
	
@BeforeMethod
public void setup() {
	System.setProperty("webdriver.http.factory", "jdk-http-client");
	initialization();
	loginPage = new LoginPage();
	high_Alert = new HighAlertScreen();
	dashboard=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
}

//Initialization
public void HighAlertScreen() {
	
	PageFactory.initElements(driver, this);
}

//Validating Prescription,Medication and Adherence tabs
@Test
public void HighAlertTab()
{
high_Alert.HighAlert_Tab();
high_Alert.Tabs_Available();
}

//Entering title and uploading jpg image to the prescription tab
@Test
public void PrescriptionTab()
{
	high_Alert.HighAlert_Tab();
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2));
	high_Alert.Prescription_Tab();
}

//Verifying the existed prescription can be delete
@Test
public void PrescriptionDelete()
{
	high_Alert.HighAlert_Tab();
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2));
	high_Alert.Prescription_Delete();
}

//Verifying prescription cannot accept text file
@Test
public void PrescriptionNotAccept()
{
	high_Alert.HighAlert_Tab();
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2));
	high_Alert.NotAccepting_TextFile();
}

//Verifying Prescription title is mandatory field
@Test
public void PrescriptionTitle() 
{
	high_Alert.HighAlert_Tab();
	high_Alert.Prescription_Title();
	//high_Alert.Prescription_Tab();
		
}

//Verifying to upload prescription image 
@Test
public void PrescriptionUpload()
{
	high_Alert.HighAlert_Tab();
	high_Alert.Prescription_Tab();
}

//Verifying Upload button is clickable
@Test
public void Uploadclickable() {
	high_Alert.HighAlert_Tab();
	boolean flag  = high_Alert.Upload_Clickable();
	Assert.assertTrue(flag);
	System.out.println(flag);

}

//Verifying prescription tab colour in blue
@Test
public void PrescriptionTabColor()
{
high_Alert.HighAlert_Tab();
high_Alert.Prescriptiontab_Color();
}
























/*public void validatePrescritionTab() {
	
	boolean flag  = high_Alert.Prescription_Test();;
	Assert.assertTrue(flag);
	
}
@Test
public void validateMedicationTab() {

	
	boolean flag1  = high_Alert.Medication_Test();;
	Assert.assertTrue(flag1);
	
}
public void validateAdherenceTab() {
	
	boolean flag2  = high_Alert.Adherence_Test();;
	Assert.assertTrue(flag2);
	
}*/

}

