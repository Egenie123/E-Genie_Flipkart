package com.agl.e_genie.or.common;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.agl.e_genie.utility.WdUtil;

public class Or_Common {

	private WdUtil webUtil;

	public Or_Common(WdUtil webUtil) {
		this.webUtil = webUtil;
	}

	@FindBy(xpath = "//li[@class='liclass  px-0 false false']//a//i[@class='far fa-home-lg-alt']")
	protected WebElement homePageicon;

	@FindBy(xpath = "//div[@class='flipkart__selectfilter ']//select[@class='campaignselect ']")
	protected WebElement productDropDown;

	@FindBy(xpath = "//div[@class='flipkart__selectfilter ']//select//option")
	protected List<WebElement> dropdownData;

	@FindBy(xpath = "//div[text()='Campaign Manager']")
	protected WebElement campaignManager;

	@FindBy(xpath = "//div[@class='p-treeselect-label-container']")
	protected WebElement filterDropdown;

	@FindBy(xpath = "(//*[@class='liclass__link w-full']//i)[2]")
	protected WebElement addIcon;

	@FindBy(xpath = "//select[@class='header__dropdown']")
	protected WebElement platformDropDown;

	@FindBy(xpath = "//select[@class='header__dropdown']//option")
	protected List<WebElement> platformName;

	@FindBy(xpath = "//*[@class='flipkart__selectfilter ']//button")
	private WebElement selectAccount;
	
	@FindBy(xpath = "(//*[@class='selectdropdown__box w-full false'])[2]")
	private WebElement selectPlatformName;
	
	@FindBy(xpath = "(//*[@class='selectdropdown__box w-full false'])[3]")
	private WebElement selectCampaignType_Dropdown;

	@FindBy(xpath = "//*[@class='dropdowOptionsul ']//label")
	private List<WebElement> selectAccount_Checkbox;

	@FindBy(xpath = "//*[contains(text(),'Select all')]")
	private WebElement selectAll_Button;

	@FindBy(xpath = "//*[@class='relative']//button")
	private WebElement customize_Column_Button;

	@FindBy(xpath = "//*[@class='cursor-pointer pl-5 ']//*[contains(text(),'Select All')]")
	private WebElement selectAll_Column_Checkbox;

	@FindBy(xpath = "//*[@class='applybutton  false false']")
	private WebElement apply_Button;

	public void customizeColumn() {
		webUtil.jsClick(customize_Column_Button);
		webUtil.jsClick(selectAll_Column_Checkbox);
		webUtil.jsClick(apply_Button);
	}

	public void select_Account(String expAccountName) {	
		webUtil.jsClick(selectAccount);
		webUtil.jsClick(selectAll_Button);
		for (int i = 0; i <= selectAccount_Checkbox.size() - 1; i++) {
			WebElement accounts = selectAccount_Checkbox.get(i);
			String getAccount = webUtil.getInerText(accounts);
			System.out.println(getAccount);
			webUtil.getExtentLogger().pass("Getting All Account -- : " + getAccount);
			if (getAccount.equalsIgnoreCase(expAccountName)) {
				webUtil.jsClick(accounts);
				System.out.println(getAccount);
				webUtil.getExtentLogger().pass("Selected Account -- : " + getAccount);
				break;
			}
		}
//		webUtil.ExplicitWaitClick(webUtil.getDriver(),selectAccount,20);
	}

	public void select_Platform_Report(String expPlatformName) {
		webUtil.jsClick(selectPlatformName);
		webUtil.jsClick(selectAll_Button);
		for (int i = 0; i <= selectAccount_Checkbox.size() - 1; i++) {
			WebElement platform = selectAccount_Checkbox.get(i);
			String getPlatform = webUtil.getInerText(platform);
			webUtil.getExtentLogger().pass("Getting All Platform -- : " + getPlatform);
			System.out.println(getPlatform);
			if (getPlatform.equalsIgnoreCase(expPlatformName)) {
				webUtil.jsClick(platform);
				webUtil.getExtentLogger().pass("Getting All Platform -- : " + getPlatform);
				System.out.println(getPlatform);
				break;
			}
		}
//		webUtil.ExplicitWaitClick(webUtil.getDriver(),selectPlatformName,20);

	}

	public void select_campaign_Type(String expCampaignType) {
		webUtil.jsClick(selectCampaignType_Dropdown);
		webUtil.jsClick(selectAll_Button);
		for (int i = 0; i <= selectAccount_Checkbox.size() - 1; i++) {
			WebElement campaignType = selectAccount_Checkbox.get(i);
			String getCampaignType = webUtil.getInerText(campaignType);
			System.out.println(getCampaignType);
			webUtil.getExtentLogger().pass("Getting All Campaign Type -- : " + getCampaignType);
			if (getCampaignType.equalsIgnoreCase(expCampaignType)) {
				webUtil.jsClick(campaignType);
				System.out.println(getCampaignType);
				webUtil.getExtentLogger().pass("Getting All Campaign Type -- : " + getCampaignType);
				break;
			}
		}
//		webUtil.ExplicitWaitClick(webUtil.getDriver(),selectCampaignType_Dropdown,20);

	}

	public void mouserOverOnAddIcon() {
		webUtil.actionMouseOver(addIcon);
	}

	public void choosePlatform(String expPlatform) {
		mouserOverOnAddIcon();
		webUtil.jsClick(campaignManager);
		webUtil.actionMouseOver(filterDropdown);
		for (int i = 0; i <= platformName.size() - 1; i++) {
			String ddText = platformName.get(i).getText();
			if (ddText.equalsIgnoreCase(expPlatform)) {
				webUtil.selectByVisibleText(platformDropDown, expPlatform);
			} else
				System.out.println("Please enter valid product name : --- :");
		}
	}

	public void chooseProduct(String expProductName) {
		mouserOverOnAddIcon();
		webUtil.jsClick(campaignManager);
		webUtil.actionMouseOver(filterDropdown);
		for (int i = 0; i <= dropdownData.size() - 1; i++) {
			String ddText = dropdownData.get(i).getText();
			if (ddText.equalsIgnoreCase(expProductName)) {
				webUtil.selectByVisibleText(productDropDown, expProductName);
			} else
				System.out.println("Please enter valid product name : --- :");
		}
	}
}
