package com.agl.e_genie.report;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.agl.e_genie.or.common.Or_Common;
import com.agl.e_genie.utility.WdUtil;

public class Report extends Or_Common{

	private WdUtil webUtil;

	public Report(WdUtil webUtil) {
		super(webUtil);
		this.webUtil=webUtil;
		PageFactory.initElements(webUtil.getDriver(), this);
	}

	@FindBy(xpath = "//button[@class='header__humburgerBtn']")
	private WebElement humBurger;

	@FindBy(xpath = "//div[contains(text(),'Report')]")
	private WebElement reportButton;

	@FindBy(xpath = "//a[@href='/flipkart/reports/campaign']//div[@class='submenuli__link']//div[contains(text(),'Campaign')]")
	private WebElement campaignReport;
	
	@FindBy(xpath = "//div[contains(text(),'Ad Group')]")
	private WebElement ad_Group_Report;	
	
	@FindBy(xpath = "//div[contains(text(),'Advertised FSN')]")
	private WebElement Advertised_FSN_Report;	
	
	@FindBy(xpath = "//div[contains(text(),'Targeted KW')]")
	private WebElement Targeted_KWReport;
	
	@FindBy(xpath = "//a[@href='/flipkart/reports/searchTermReport']//div[@class='submenuli__link']//div[contains(text(),'Search Term')]")
	private WebElement Search_Term_Report;	
	
	@FindBy(xpath = "//div[contains(text(),'Placement')]")
	private WebElement Placement_Report;
	
	@FindBy(xpath = "//div[contains(text(),'Creative')]")
	private WebElement Creative_Report;
	
	@FindBy(xpath = "//div[contains(text(),'Revenue Report')]")
	private WebElement Revenue_Report;
	
	@FindBy(xpath = "//div[@class='ilclass-sidenav  cursor-default flex']")
	private WebElement syncButton;;
	
	@FindBy(xpath = "//button[@class='exportbutton false']")
	private WebElement exportButton;
	
	@FindBy(xpath = "//div[@class='exportCSVPopUp']//label/input")
	private List<WebElement> dateDuration;
	
	@FindBy(xpath = "//button[@class='exportdownloadbt rounded  false']")
	private WebElement downloadButton;
	
	public void CampaignReport(String expDateType) {
		webUtil.jsClick(humBurger);
		webUtil.actionMouseOver(reportButton);
		webUtil.ExplicitWaitClick(webUtil.getDriver(),campaignReport,20);
		webUtil.staticWait(2);
		webUtil.ExplicitWaitClick(webUtil.getDriver(),syncButton,20);
		webUtil.staticWait(3);
		select_Account("Dettol");
		webUtil.ExplicitWaitClick(webUtil.getDriver(),syncButton,20);
		select_campaign_Type("PLA");
		webUtil.ExplicitWaitClick(webUtil.getDriver(),syncButton,20);
		select_Platform_Report("Supermart");
		webUtil.ExplicitWaitClick(webUtil.getDriver(),syncButton,20);
		webUtil.ExplicitWaitClick(webUtil.getDriver(), exportButton, 10);
		
		for(int i=0;i<=dateDuration.size()-1;i++) {
			WebElement durationType =dateDuration.get(i);
			String dateType =webUtil.getAtrbtText(durationType, "value");
			if(dateType.equalsIgnoreCase(expDateType)) {
				webUtil.ExplicitWaitClick(webUtil.getDriver(), durationType,20);
			}
		}
		
		webUtil.ExplicitWaitClick(webUtil.getDriver(), downloadButton, 20);
		
	}
	
	
	public void AdGroupReport(String expDateType) {
//		webUtil.jsClick(humBurger);
		webUtil.actionMouseOver(reportButton);
		webUtil.ExplicitWaitClick(webUtil.getDriver(),ad_Group_Report,20);
		webUtil.staticWait(2);
		webUtil.ExplicitWaitClick(webUtil.getDriver(),syncButton,20);
		webUtil.staticWait(3);
		select_Account("Dettol");
		webUtil.ExplicitWaitClick(webUtil.getDriver(),syncButton,20);
		select_campaign_Type("PLA");
		webUtil.ExplicitWaitClick(webUtil.getDriver(),syncButton,20);
		select_Platform_Report("Supermart");
		webUtil.ExplicitWaitClick(webUtil.getDriver(),syncButton,20);
		webUtil.ExplicitWaitClick(webUtil.getDriver(), exportButton, 10);
		
		for(int i=0;i<=dateDuration.size()-1;i++) {
			WebElement durationType =dateDuration.get(i);
			String dateType =webUtil.getAtrbtText(durationType, "value");
			if(dateType.equalsIgnoreCase(expDateType)) {
				webUtil.ExplicitWaitClick(webUtil.getDriver(), durationType,20);
			}
		}
		
		webUtil.ExplicitWaitClick(webUtil.getDriver(), downloadButton, 20);
		
	}
	
	public void FSNReport(String expDateType) {
//		webUtil.jsClick(humBurger);
		webUtil.actionMouseOver(reportButton);
		webUtil.ExplicitWaitClick(webUtil.getDriver(),Advertised_FSN_Report,20);
		webUtil.staticWait(2);
		webUtil.ExplicitWaitClick(webUtil.getDriver(),syncButton,20);
		webUtil.staticWait(3);
		select_Account("Dettol");
		webUtil.ExplicitWaitClick(webUtil.getDriver(),syncButton,20);
		select_campaign_Type("PLA");
		webUtil.ExplicitWaitClick(webUtil.getDriver(),syncButton,20);
		select_Platform_Report("Supermart");
		webUtil.ExplicitWaitClick(webUtil.getDriver(),syncButton,20);
		webUtil.ExplicitWaitClick(webUtil.getDriver(), exportButton, 10);
		
		for(int i=0;i<=dateDuration.size()-1;i++) {
			WebElement durationType =dateDuration.get(i);
			String dateType =webUtil.getAtrbtText(durationType, "value");
			if(dateType.equalsIgnoreCase(expDateType)) {
				webUtil.ExplicitWaitClick(webUtil.getDriver(), durationType,20);
			}
		}
		
		webUtil.ExplicitWaitClick(webUtil.getDriver(), downloadButton, 20);
		
	}
	
	
	public void SearchTermReport(String expDateType) {
//		webUtil.jsClick(humBurger);
		webUtil.actionMouseOver(reportButton);
		webUtil.ExplicitWaitClick(webUtil.getDriver(),Search_Term_Report,20);
		webUtil.staticWait(2);
		webUtil.ExplicitWaitClick(webUtil.getDriver(),syncButton,20);
		webUtil.staticWait(3);
		select_Account("Dettol");
		webUtil.ExplicitWaitClick(webUtil.getDriver(),syncButton,20);
		select_campaign_Type("PLA");
		webUtil.ExplicitWaitClick(webUtil.getDriver(),syncButton,20);
		select_Platform_Report("Supermart");
		webUtil.ExplicitWaitClick(webUtil.getDriver(),syncButton,20);
		webUtil.ExplicitWaitClick(webUtil.getDriver(), exportButton, 10);
		
		for(int i=0;i<=dateDuration.size()-1;i++) {
			WebElement durationType =dateDuration.get(i);
			String dateType =webUtil.getAtrbtText(durationType, "value");
			if(dateType.equalsIgnoreCase(expDateType)) {
				webUtil.ExplicitWaitClick(webUtil.getDriver(), durationType,20);
			}
		}
		webUtil.ExplicitWaitClick(webUtil.getDriver(), downloadButton, 60);
	}
	
	
	
	
	public void KeywordReport(String expDateType) {
//		webUtil.jsClick(humBurger);
		webUtil.actionMouseOver(reportButton);
		webUtil.ExplicitWaitClick(webUtil.getDriver(),Targeted_KWReport,20);
		webUtil.staticWait(2);
		webUtil.ExplicitWaitClick(webUtil.getDriver(),syncButton,20);
		webUtil.staticWait(3);
		select_Account("Dettol");
		webUtil.ExplicitWaitClick(webUtil.getDriver(),syncButton,20);
		select_campaign_Type("PLA");
		webUtil.ExplicitWaitClick(webUtil.getDriver(),syncButton,20);
		select_Platform_Report("Supermart");
		webUtil.ExplicitWaitClick(webUtil.getDriver(),syncButton,20);
		webUtil.ExplicitWaitClick(webUtil.getDriver(), exportButton, 10);
		
		for(int i=0;i<=dateDuration.size()-1;i++) {
			WebElement durationType =dateDuration.get(i);
			String dateType =webUtil.getAtrbtText(durationType, "value");
			if(dateType.equalsIgnoreCase(expDateType)) {
				webUtil.ExplicitWaitClick(webUtil.getDriver(), durationType,20);
			}
		}
		webUtil.ExplicitWaitClick(webUtil.getDriver(), downloadButton, 20);
	}
	
	
	public void PlacementReport(String expDateType) {
//		webUtil.jsClick(humBurger);
		webUtil.actionMouseOver(reportButton);
		webUtil.ExplicitWaitClick(webUtil.getDriver(),Placement_Report,20);
		webUtil.staticWait(2);
		webUtil.ExplicitWaitClick(webUtil.getDriver(),syncButton,20);
		webUtil.staticWait(3);
		select_Account("Dettol");
		webUtil.ExplicitWaitClick(webUtil.getDriver(),syncButton,20);
		select_campaign_Type("PLA");
		webUtil.ExplicitWaitClick(webUtil.getDriver(),syncButton,20);
		select_Platform_Report("Supermart");
		webUtil.ExplicitWaitClick(webUtil.getDriver(),syncButton,20);
		webUtil.ExplicitWaitClick(webUtil.getDriver(), exportButton, 10);
		for(int i=0;i<=dateDuration.size()-1;i++) {
			WebElement durationType =dateDuration.get(i);
			String dateType =webUtil.getAtrbtText(durationType, "value");
			if(dateType.equalsIgnoreCase(expDateType)) {
				webUtil.ExplicitWaitClick(webUtil.getDriver(), durationType,20);
			}
		}
		webUtil.ExplicitWaitClick(webUtil.getDriver(), downloadButton, 20);
	}
	
	public void CrreativeReport(String expDateType) {
//		webUtil.jsClick(humBurger);
		webUtil.actionMouseOver(reportButton);
		webUtil.ExplicitWaitClick(webUtil.getDriver(),Creative_Report,20);
		webUtil.staticWait(2);
		webUtil.ExplicitWaitClick(webUtil.getDriver(),syncButton,20);
		webUtil.staticWait(3);
		select_Account("Dettol");
		webUtil.ExplicitWaitClick(webUtil.getDriver(),syncButton,20);
		select_campaign_Type("PLA");
		webUtil.ExplicitWaitClick(webUtil.getDriver(),syncButton,20);
		select_Platform_Report("Supermart");
		webUtil.ExplicitWaitClick(webUtil.getDriver(),syncButton,20);
		webUtil.ExplicitWaitClick(webUtil.getDriver(), exportButton, 10);
		
		for(int i=0;i<=dateDuration.size()-1;i++) {
			WebElement durationType =dateDuration.get(i);
			String dateType =webUtil.getAtrbtText(durationType, "value");
			if(dateType.equalsIgnoreCase(expDateType)) {
				webUtil.ExplicitWaitClick(webUtil.getDriver(), durationType,20);
			}
		}
		webUtil.ExplicitWaitClick(webUtil.getDriver(), downloadButton, 20);
	}
	
	
	
	public void RevenueReport(String expDateType) {
//		webUtil.jsClick(humBurger);
		webUtil.actionMouseOver(reportButton);
		webUtil.ExplicitWaitClick(webUtil.getDriver(),Revenue_Report,20);
		webUtil.staticWait(2);
		webUtil.ExplicitWaitClick(webUtil.getDriver(),syncButton,20);
		webUtil.staticWait(3);
		select_Account("Dettol");
		webUtil.ExplicitWaitClick(webUtil.getDriver(),syncButton,20);
		select_campaign_Type("PLA");
		webUtil.ExplicitWaitClick(webUtil.getDriver(),syncButton,20);
		select_Platform_Report("Supermart");
		webUtil.ExplicitWaitClick(webUtil.getDriver(),syncButton,20);
		webUtil.ExplicitWaitClick(webUtil.getDriver(), exportButton, 10);
		
		for(int i=0;i<=dateDuration.size()-1;i++) {
			WebElement durationType =dateDuration.get(i);
			String dateType =webUtil.getAtrbtText(durationType, "value");
			if(dateType.equalsIgnoreCase(expDateType)) {
				webUtil.ExplicitWaitClick(webUtil.getDriver(), durationType,20);
			}
		}
		
		webUtil.ExplicitWaitClick(webUtil.getDriver(), downloadButton, 20);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
