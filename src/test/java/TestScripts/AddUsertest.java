package TestScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericutilities.Baseclass;

public class AddUsertest  extends Baseclass{
	@Test
	public void adduserTest()
	{
		SoftAssert soft = new SoftAssert();
		
		home.clickUsersTab();
		soft.assertTrue(users.getPageHeader().contains("users"));
		users.clickNewButton();
		soft.assertEquals(adduser.getPageHeader(), "Add User");
		
		Map<String,String> map = excel.readFromExcel("Add User");
		adduser.setEmail(map.get("Email"));
		adduser.setPassword(map.get("password"));
		adduser.setfirstname(map.get("Firstname"));
		adduser.setlastname(map.get("Lastname"));
		adduser.setaddress(map.get("Address"));
		adduser.setContactInfo(map.get("contact info"));
		adduser.uploadPhoto(map.get("photo"));
		adduser.clicksave();
	soft.assertEquals(users.getSuccessMessage(),"Success!");
	soft.assertAll();
	}
	
	
	

}
