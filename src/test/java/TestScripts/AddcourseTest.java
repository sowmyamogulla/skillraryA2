package TestScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericutilities.Baseclass;
import genericutilities.iconstantpath;
//this test  is verifies
public class AddcourseTest extends Baseclass {
	@Test
	public void addcourseTest() {

		SoftAssert soft = new SoftAssert();

		home.clickCoursesTab();
		home.clickCourseListLink();

		soft.assertTrue(courseList.getPageHeader().contains("CourseList"));
		courseList.clickNewButton();
		soft.assertEquals(addCourse.getPageHeader(), "Add New Course");
		Map<String, String> map = excel.readFromExcel("Add Course");
		addCourse.setName(map.get("Name"));
		addCourse.selectCategory(web, map.get("Category"));
		addCourse.setPrice(map.get("price"));
		addCourse.setDescription(map.get("Description"), web);
		addCourse.clickSave();

		soft.assertEquals(courseList.getsuccessMessage(), "Success!");
		// System.out.println(courseList.getsuccessMessage());
		courseList.deleteCourse(web, map.get("Name"));
		soft.assertEquals(courseList.getsuccessMessage(), "Success!");

		if (courseList.getsuccessMessage().equals("Success!"))
			excel.updateTestStatus("Add Course", "pass", iconstantpath.EXCEL_PATH);
		else
			excel.updateTestStatus("Add Course", "Fail", iconstantpath.EXCEL_PATH);
		soft.assertAll();
	}
}
