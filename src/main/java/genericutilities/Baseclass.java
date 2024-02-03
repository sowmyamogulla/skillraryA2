package genericutilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pompages.AddNewCoursePage;
import pompages.AddcategoryPage;
import pompages.AddnewuserPage;
import pompages.CourseListPage;
import pompages.categorypage;
import pompages.homepage;
import pompages.loginpage;
import pompages.userspage;

public class Baseclass {
	 protected WebDriver driver;
	 protected propertiesUtility property;
	 protected JavaUtility jutil;
	 protected WebDriverUtility web;
	 protected Excelutility excel;
	 
	 protected loginpage login;
	 protected homepage home;
	 protected userspage users;
	 protected CourseListPage courseList;
	 protected categorypage category;
	 protected AddnewuserPage adduser;
	 protected AddNewCoursePage addCourse;
	 protected AddcategoryPage addCategory;
	 
	 public static WebDriver sdriver;
	 public static JavaUtility sjutil;
	 
	//@BeforeSuite
	//@BeforeTest
	@BeforeClass
	public void classSetUp()
	{
		web = new WebDriverUtility();
		jutil=new JavaUtility();
		property=new propertiesUtility();
		excel=new Excelutility();
		
		property.propertiesInit(iconstantpath.PROPERTIES_FILE_PATH);
		driver = web.launchBrowserAndMaximize(property.readFromProperties("browsers"));
		web.waitTillElementFound(Long.parseLong(property.readFromProperties("timeouts")));
		sdriver = driver;
		sjutil=jutil;
		
	}
	@BeforeMethod
	public void methodSetup(){
		login = new loginpage(driver);
		home = new homepage(driver);
		users = new userspage(driver);
		courseList = new CourseListPage(driver);
		category = new categorypage(driver);
		adduser = new AddnewuserPage(driver);
		addCourse= new AddNewCoursePage(driver);
		addCategory= new AddcategoryPage(driver);
		
		excel.excelInit(iconstantpath.EXCEL_PATH,"Sheet1");
		web.navigateToApp(property.readFromProperties("url"));
		Assert.assertEquals(login.getPageHeader(),"login");
		login.loginToApp(property.readFromProperties("username"),property.readFromProperties("password"));
		
		Assert.assertEquals(home.getPageHeader(), "Home");
	}
	
	
	
	
	@AfterMethod
	public void methodTearDown() {
		excel.closeExcel();
		home.signOutofApp();
		
	}
	@AfterClass
	public void classTearDown()
	{
	web.quitAllWindows();
	}
	
	//
	
	//@AfterTest
	//@AfterSuite
	

}
