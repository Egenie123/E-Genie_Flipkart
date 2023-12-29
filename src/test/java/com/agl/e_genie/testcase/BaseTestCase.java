package com.agl.e_genie.testcase;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Capabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.agl.e_genie.campaign_manager.pages.Campaign_Manager_Filter;
import com.agl.e_genie.excel.utility.Excel_Util;
import com.agl.e_genie.negative_keyword.pages.Negative_Keyword;
import com.agl.e_genie.utility.WdUtil;
import com.aventstack.extentreports.Status;
import com.e_genie.login.page.Login_Page;
 import org.testng.ITestResult;

public class BaseTestCase {

	protected WdUtil webUtil;
	protected Excel_Util excel;
	protected List<Map<String, String>> dataMapList;
	
	
	@BeforeSuite
	public void tearUp() {
		webUtil = new WdUtil();
		webUtil.initHtmlReport();
	}
	
	@BeforeClass(alwaysRun = true)
	public void beforeTestCaseClass() throws IOException {
		excel = new Excel_Util();
	}

	 @AfterClass
	 public void afterTestCaseClass() {
//	 webUtil.close();
	 }

	@BeforeMethod(alwaysRun = true)
	public void beforeTestCase(Method tm) throws IOException {
		String tmName = tm.getName();
		webUtil.setExtentLogger(tmName);
		String brName =webUtil.getPropObj().getProperty("BrowserName");
		webUtil.launchBrowser(brName);
		Login_Page loginPage = new Login_Page(webUtil);
		loginPage.validLogin();
	}
	
	
	
	
	
	@AfterMethod
	public void afterTestCase(ITestResult tr, Method tm) throws IOException {
		String tmName = tm.getName();
		if (tr.getStatus() == ITestResult.FAILURE) {
//			webUtil.getExtentLogger().addScreenCaptureFromPath(webUtil.getScreenShot(tmName));
			webUtil.getExtentLogger().log(Status.FAIL, tmName + " is failed ");
		} else if (tr.getStatus() == ITestResult.SUCCESS) {
			webUtil.getExtentLogger().log(Status.PASS, tmName + " is passed ");
		} else {
			webUtil.getExtentLogger().log(Status.SKIP, tmName + " is skipped ");
		}
//		new HomePage(webUtil).logOut();
		webUtil.flushReport();
	}




}
