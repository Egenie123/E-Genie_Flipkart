package com.agl.e_genie.testcase;

import java.io.IOException;
import java.util.Map;
import org.testng.annotations.Test;

import com.agl.e_genie.campaign_manager.pages.Campaign_Manager_Dashboard;
import com.agl.e_genie.campaign_manager.pages.Campaign_Manager_Filter;
import com.agl.e_genie.home_page.Home_Page;
import com.agl.e_genie.or.common.Date_Picker;
import com.agl.e_genie.report.Report;
import com.agl.e_genie.rule.Create_Rules;

public class Campaign_Manager_Testcase extends BaseTestCase {


//	@Test
	public void apply_Campaign_Manager_Filter() throws IOException {
		Campaign_Manager_Filter campaignManager = new Campaign_Manager_Filter(webUtil,dataMapList,excel);
		dataMapList = excel.getTestCaseData("src\\test\\resources\\TestCaseData.xlsx", "apply_Campaign_Manager_Filter");
		for (int i = 0; i <= dataMapList.size() - 1; i++) {
			Map<String, String> dataMap = dataMapList.get(i);
			String expAdGrpMatricCheckBox = dataMap.get("ExpAddGroupMatricCheckBox");
			campaignManager.applyFilterFor_AddGroupMatric(expAdGrpMatricCheckBox);
			webUtil.getExtentLogger().pass("Applied filter : "+expAdGrpMatricCheckBox);
			String expKeywordMatricCheckBox = dataMap.get("ExpKeywordMatricCheckBox");
			campaignManager.applyFilterFor_KeywordMatric(expKeywordMatricCheckBox);
			webUtil.getExtentLogger().pass("Applied filter : "+expKeywordMatricCheckBox);
			String expFSNMatricCheckBox = dataMap.get("ExpFSNMatricCheckBox");
			campaignManager.applyFilterFor_FSNMatric(expFSNMatricCheckBox);
			webUtil.getExtentLogger().pass("Applied filter : "+expFSNMatricCheckBox);

		}

	}

//	@Test
	public void campaign_Data_validation() throws Exception {
		Campaign_Manager_Dashboard campaignData=	new Campaign_Manager_Dashboard(webUtil);
//		String productName =webUtil.getConfigValue("ProductName");
//		campaignData.flipkartData();
		campaignData.Campaign_Manager_Method();
	}
	
	
	
	@Test
	public void getTotalRowData() {
		Campaign_Manager_Dashboard campaignData=	new Campaign_Manager_Dashboard(webUtil);
		String productName = webUtil.getConfigValue("ProductName");
		campaignData.validateCampaignManager(productName);
	}
	

	@Test
	public void homePageTestcase() {
		Home_Page homePg=	new Home_Page(webUtil);
		String productName = webUtil.getConfigValue("ProductName");
		homePg.chooseProduct(productName);
		String campaigntName = webUtil.getConfigValue("CampaignName");
		homePg.choose_CampaignType(campaigntName);
		homePg.validateHomeData();
		homePg.flipkartData();
		homePg.validateDate_of_Both_Pltform();
	}
	
	
	public void create_New_Rules() {
		Create_Rules rule =new Create_Rules(webUtil);
		rule.create_Rule();
	}
	
	
//	@Test
	public void report_Page() {
		Report reports =new Report(webUtil);
		reports.CampaignReport("Daily");
		reports.AdGroupReport("Daily");
		reports.CrreativeReport("Daily");
		reports.FSNReport("Weekly");
		reports.KeywordReport("Daily");
		reports.PlacementReport("Monthly");
		reports.RevenueReport("Weekly");
		reports.SearchTermReport("Cumulative");
		
		
		
		
		
	}
	
//	Validate the data according to the symbol and range
	
	public void remove_Campaign_Manager_Filter() throws IOException {
		Campaign_Manager_Filter campaignManager = new Campaign_Manager_Filter(webUtil,dataMapList,excel);
		dataMapList = excel.getTestCaseData("src\\test\\resources\\TestCaseData.xlsx",
				"remove_Campaign_Manager_Filter");
		for (int i = 0; i <= dataMapList.size() - 1; i++) {
			Map<String, String> dataMap = dataMapList.get(i);
			String expFilterName = dataMap.get("ExpFilterText");
			campaignManager.removeFilter(expFilterName);
		}
	}

	public void apply_Filter_Platform() throws IOException {
		Campaign_Manager_Filter campaignManager = new Campaign_Manager_Filter(webUtil,dataMapList,excel);
		dataMapList = excel.getTestCaseData("src\\test\\resources\\TestCaseData.xlsx", "apply_Filter_Platform");
		for (int i = 0; i <= dataMapList.size() - 1; i++) {
			Map<String, String> dataMap = dataMapList.get(i);
			String expPlatformName = dataMap.get("ExpPlatform");
			campaignManager.choosePlatform(expPlatformName);
		}
	}

	public void apply_Filter_Product() throws IOException {
		Campaign_Manager_Filter campaignManager = new Campaign_Manager_Filter(webUtil,dataMapList,excel);
		dataMapList = excel.getTestCaseData("src\\test\\resources\\TestCaseData.xlsx", "apply_Filter_Product");
		for (int i = 0; i <= dataMapList.size() - 1; i++) {
			Map<String, String> dataMap = dataMapList.get(i);
			String exproductName = dataMap.get("ExpProduct");
			campaignManager.chooseProduct(exproductName);
		}
	}
	

	public void datePicker() throws IOException {
		Date_Picker date = new Date_Picker(webUtil);
		date.chooseDateType();
	
		
	}
	

}
