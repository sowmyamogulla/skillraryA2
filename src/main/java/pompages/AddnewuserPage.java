package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddnewuserPage {
//Declaration
	@FindBy(xpath="//b[text()='Add New User']")
	private WebElement pageHeader;
	
	@FindBy(xpath="//input[@id=email and @required]")
	private WebElement emailTF;
	
	@FindBy(xpath="//input[@id=\"password\" and @required]")
	private WebElement passwordTF;
	
	@FindBy(xpath="//input[@id=\"firstname\" and @required]")
	private WebElement firstnameTF;
	
	
	@FindBy(xpath="//input[@id=\"lastname\" and @required]")
	private WebElement lastnameTF;
	
	@FindBy(xpath="//input[@id='address']")
	private WebElement addressTextArea;
	

	
	
	
	@FindBy(xpath="//input[@id='contact']")
	private WebElement contactInfoTf;
	
	@FindBy(xpath="//input[@id='photo'])[2]")
	private WebElement photoUploadButton;
	
	@FindBy(xpath="//button[text()='Save' and @name='add']")
	private WebElement saveButton;

	private WebElement photoUploadButtonTF;
		
	
	//initialization 
	public AddnewuserPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
}
	
	//utilization
	public String getPageHeader()
	{
		return pageHeader.getText();
	}
	
	public void setEmail(String email) {
		emailTF.sendKeys(email);
		
	}
	public void setPassword(String password)
	{
		passwordTF.sendKeys(password);
	}
	
	public void setfirstname(String firstname)
	{
		firstnameTF.sendKeys(firstname);
	}
	
	public void setlastname(String lastname)
	{
		lastnameTF.sendKeys(lastname);
	}
	public void setaddress(String address)
	{
		addressTextArea.sendKeys(address);
	}
	
	public void setContactInfo(String contact) {
		contactInfoTf.sendKeys(contact);
	}
	
	public void uploadPhoto(String photopath) {
		photoUploadButtonTF.sendKeys(photopath);
	}
	public void clicksave() {
		saveButton.click();
	}
	
	
	
	
	
}

