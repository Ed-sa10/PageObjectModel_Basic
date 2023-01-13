package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BookResultPage;
import pages.LoginPage;
import wrappers.ProjectSpecificWrappers;

public class TestCase2 extends ProjectSpecificWrappers {
	@BeforeClass
	public void setData() {
		testCaseName="TestCase2";
		testDescription="Book search for Learning JavaScript Design Patterns";
		browserName="chrome";
		dataSheetName="TC002";
		category="Smoke";
		authors="Mithra";
	}

	@Test(dataProvider="fetchData")
	public void testCase2(String searchText) throws InterruptedException {
		new LoginPage(driver, test)
		.enterUserName()
		.enterPassword()
		.clickLogin()
		.clickBookStore()
		.enterSearchText(searchText)
		.clickSearchResult(searchText)
		.getTitle();
		new BookResultPage(driver,test).clickLogOut();
		
	}

}
