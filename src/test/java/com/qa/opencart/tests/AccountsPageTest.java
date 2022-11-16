package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.utils.Constants;


public class AccountsPageTest extends BaseTest {
	
	/**29:52
	 *  can i create Separate specific precondition for AccountPageTest whit @BeforeClass.
	 *  which Method will be executed first, Before class or Before Method.
	 *  According testNG annotation, Before test will be executed from a BeseTest. 
	 *  and then Before class will be executed
	 * @throws InterruptedException 
	 */
	
//	 this is precondition only for "Accountspage" related test cashes
	
	@BeforeClass
	public void accPageSetup() {
		accountsPage = loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));		
	}
	
	@Test(priority = 1)
	public void accPageTitleTest() {
		String actTitle = accountsPage.getAccountPageTitle();
		System.out.println("acc page title: " + actTitle);
		Assert.assertEquals(actTitle, Constants.ACCOUNTS_PAGE_TITLE);		
	}
	
	@Test(priority = 2)
	public void accPageHeaderTest() {
		String header = accountsPage.getAccountsPageHeader();
		System.out.println( header + Constants.ACCOUNTS_PAGE_HEADER);
	}
	
	@Test(priority = 3)
	public void isLogoutExistTest(){
		Assert.assertTrue(accountsPage.isLogoutLinkExist());
	}
	
	@Test(priority = 4)
	public void accPageSectionsTest() {
		List<String> actAccSecList = accountsPage.getAccountSecList();
		Assert.assertEquals(actAccSecList,Constants.getExpectedAccSecList());		
	}
	
	@DataProvider  // Data provider annotation 
	/**
	 *  Data provider should return what ?
	 *  Every Data Provider should return two dymantion array .
	 *  Excel sheet ..multiple  row and columns .
	 *  same thing data provider also , 2D array.
	 *  Return what ?
	 *  return two dymantion array
	 */
	
	public Object[][] productData() {
		// Keep maintaining test data here. 2D Array.
		return new Object[][] {
			{"MacBook Pro"},
			{"Apple"},
			{"Samsung"},
		};		
	}
	
	@Test(priority = 5, dataProvider = "productData")
	public void searchTest(String productName) {
		accountsPage.doSearch(productName);
	}	
	
 
}
