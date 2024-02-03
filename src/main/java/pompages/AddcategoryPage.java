package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddcategoryPage {
//Declaration
	@FindBy(xpath= "//b[text()='Add New Category']")
	private WebElement pageHeader;
	
	@FindBy(id="name")
	private WebElement nameTF;
	
	@FindBy(xpath="//button[text()='Save' and @name='add']")
	private WebElement saveButton;
	
	//initialization
	public AddcategoryPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	//utilization
	public String getPageHeader() {
		return pageHeader.getText();
	}
	public void setName(String courseName) {
		nameTF.sendKeys(courseName);
	}
	public void clickSave()
	{
		saveButton.click();
	}
}
