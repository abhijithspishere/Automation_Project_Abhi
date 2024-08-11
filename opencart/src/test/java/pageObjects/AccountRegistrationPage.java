package pageObjects;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath="//input[@id='gender-male']") 
	WebElement Chkbox_male;
	
	@FindBy(xpath="//input[@id='FirstName']")
	WebElement txt_firstName;
	
	@FindBy(xpath="//input[@id='LastName']") 
	WebElement txt_lastName;
	
	@FindBy(xpath="//select[@name='DateOfBirthDay']") 
	WebElement select_Date;
	
	@FindBy(xpath="//select[@name='DateOfBirthMonth']") 
	WebElement select_Month;
	
	@FindBy(xpath="//select[@name='DateOfBirthYear']") 
    WebElement select_Year;
	
	@FindBy(xpath="//input[@id='Email']")
    WebElement txt_email;
	
	@FindBy(xpath="//input[@id='Company']") 
	WebElement txt_CpnyName;
	
	@FindBy(xpath="//input[@id='Password']") 
	WebElement txt_password;
	
	@FindBy(xpath="//input[@id='ConfirmPassword']") 
	WebElement txt_con_Password;
	
	@FindBy(xpath="//button[@id='register-button']") 
	WebElement btn_register;
	
	@FindBy(xpath="//div[@class='result']")
	WebElement msgConfirmation;
	
	
	public void setChkBox()
	{
		Chkbox_male.click();
	}
	
	public void setFirstname(String fname)
	{
		txt_firstName.sendKeys(fname);
	}
	
	public void setLastname(String lname)
	{
		txt_lastName.sendKeys(lname);
	}
	
	public void setDate(String date) 
	{
		select_Date.sendKeys(date);
	}
	
	public void setMonth(String month) 
	{
		select_Month.sendKeys(month);
	}
	
	public void setYear(String year) 
	{
		select_Year.sendKeys(year);
	}
	
	public void setEmail(String email)
	{
		txt_email.sendKeys(email);
	}
	
	public void setCompanyName(String company)
	{
		txt_CpnyName.sendKeys(company);
	}
	
	public void setPassword(String pwd)
	{
		txt_password.sendKeys(pwd);
	}
	
	public void setConfirmPassword(String Confirmpwd)
	{
		 txt_con_Password.sendKeys(Confirmpwd);
	}
	
	public void clickRegister()
	{
		btn_register.click();
	}
	
	public String getConfirmationMsg()
	{
	
		try
		{
			return msgConfirmation.getText();
			}
		catch (Exception e) 
		{
			return (e.getMessage());
		}
		
	}
	
	}


//sol2 
//btnContinue.submit();

//sol3
//Actions act=new Actions(driver);
//act.moveToElement(btnContinue).click().perform();
			
//sol4
//JavascriptExecutor js=(JavascriptExecutor)driver;
//js.executeScript("arguments[0].click();", btnContinue);

//Sol 5
//btnContinue.sendKeys(Keys.RETURN);

//Sol6  
//WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
//mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
