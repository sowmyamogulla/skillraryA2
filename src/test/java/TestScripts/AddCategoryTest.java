package TestScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericutilities.Baseclass;
import genericutilities.iconstantpath;

public class AddCategoryTest extends Baseclass {
@Test
public void addcategoryTest() {
	SoftAssert soft = new SoftAssert();
	home.clickCoursesTab();
	home.clickCategoryLink();
	
	soft.assertEquals(category.getPageHeader(),"category");
	category.clickNewButton();
	soft.assertEquals(addCategory.getPageHeader(),"Add New Category");
	Map<String,String> map = excel.readFromExcel("Add Category");
	addCategory.setName(map.get("Name"));
	addCategory.clickSave();
	
	System.out.println(category.getSuccessMessage());
	soft.assertEquals(category.getSuccessMessage(),"Success!");
	category.deleteCategory(web,map.get("Name"));
	soft.assertEquals(category.getSuccessMessage(),"Success!");
	
	if(category.getSuccessMessage().equals("success!"))
	excel.updateTestStatus("Add Category" ,"Pass" , iconstantpath.EXCEL_PATH);
	else
		excel.updateTestStatus("Add Category" ,"Fail" , iconstantpath.EXCEL_PATH);
	soft.assertAll();
	
     }

}
