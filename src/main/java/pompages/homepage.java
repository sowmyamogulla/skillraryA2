package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homepage {

	
	//Declaration
	@FindBy(xpath="//a[text()= ' Home']")
	private WebElement pageHeader;
	@FindBy(xpath="/span[text()='Users']")
	private WebElement usersTab;
	
	@FindBy(xpath="//span[text()='Courses']")
	private WebElement CoursesTab;
	
	@FindBy(xpath="//a[text()='Course List']")
	private WebElement courseListLink;
	
	@FindBy(xpath="//a[text()='Category']")
	private WebElement categoryLink;
	
	@FindBy(xpath="//span[text()='Skillrary Admin']")
	private WebElement skillraryAdminIcon;
	@FindBy(xpath="//text()='sign out']")
    private  WebElement signoutLink;	
	
	
	//Initialization
	public homepage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		
	}
	//utilization
	public String getPageHeader()
	{
		return pageHeader.getText();
		
	}
	public void clickUsersTab() {
		usersTab.click();
		
	}
	public void clickCoursesTab()
	{
		CoursesTab.click();
	}
	
	public void clickCourseListLink() {
		courseListLink.click();
		
	}
	public void clickCategoryLink() {
		categoryLink.click();
	}
	public void signOutofApp()
	{
		skillraryAdminIcon.click();
		signoutLink.click();
	}
	
	
	
	
	
	
	
	
}
