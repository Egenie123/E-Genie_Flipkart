package com.agl.e_genie.testcase;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.agl.e_genie.campaign_manager.pages.Campaign_Manager;
import com.agl.e_genie.negative_keyword.pages.Negative_Keyword;
import com.agl.e_genie.utility.WdUtil;
import com.e_genie.login.page.Login_Page;


public class BaseTestCase {

	private WdUtil webUtil;

	@BeforeClass(alwaysRun = true)
	public void beforeTestCaseClass() throws IOException {
		webUtil = new WdUtil();
		String browserName = webUtil.getConfigValue("BrowserName");
		webUtil.launchBrowser(browserName);
	}

//	@AfterClass
//	public void afterTestCaseClass() {
//		webUtil.close();
//	}

	@BeforeMethod(alwaysRun = true)
	public void beforeTestCase() throws IOException {
		Login_Page loginPage = new Login_Page(webUtil);
		loginPage.validLogin();
	}
	
	
	@Test
	public void campaign() {
		Campaign_Manager campaignManager=	new Campaign_Manager(webUtil);
		campaignManager.datePicker();
	}
	@Test
	public void negativeKeyword() {
		Negative_Keyword negativekey=new	Negative_Keyword(webUtil);
		negativekey.applyFilter_Name();
		
	}

	
	
	
	
	
	
	
	
	
	
	
}
