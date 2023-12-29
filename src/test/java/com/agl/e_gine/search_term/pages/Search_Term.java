package com.agl.e_gine.search_term.pages;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.agl.e_genie.excel.utility.Excel_Util;
import com.agl.e_genie.or.common.Date_Picker;
import com.agl.e_genie.or.common.Or_Common;
import com.agl.e_genie.utility.WdUtil;

public class Search_Term extends Or_Common {

	
	private WdUtil webUtil;
	private Excel_Util excel;
	private List<Map<String, String>> dataMapList;
	
	
	public Search_Term(WdUtil webUtil,List<Map<String, String>> dataMapList,Excel_Util excel) {
		super(webUtil);
		this.webUtil = webUtil;
		this.dataMapList=dataMapList;
		this.excel=excel;
		PageFactory.initElements(webUtil.getDriver(), this);

	}

	@FindBy(xpath = "//div[text()='Search Term']")
	private WebElement search_Term;
	
	@FindBy(xpath = "//div[@class='card flex justify-content-center h-10 w-full']")
	private WebElement filterDropdown;
	
	@FindBy (xpath = "//select[@class='campaignselect h-10']")
	private WebElement product_DD;
	
	@FindBy(xpath = "//div[@class='p-treeselect-label-container']")
	private WebElement searchFilterDD;
	
	@FindBy(xpath = "//button[@class='p-tree-toggler p-link']")
	private WebElement chooseFilterType;
	
	@FindBy(xpath = "//span[@class='p-treenode-label']")
	private List<WebElement> searchTerm_List;
	
	@FindBy(xpath = "//div[@class='p-checkbox-box']")
	private List<WebElement> searhTerm_CheckBoxList;
	
	@FindBy(xpath = "//div[@class='flex items-center mr-4'][1]//label")
	private List<WebElement> radioBtnText;

	@FindBy(xpath = "//input[@name='search']")
	private WebElement inputBox;

	@FindBy(xpath = "//div//input[@name='inline-radio-group']")
	private List<WebElement> radioBtnList;

	@FindBy(xpath = "//div[@class='flex items-center justify-end p-2  border-solid border-slate-200 rounded-b']//button")
	private List<WebElement> popUpBtn;
	
	
	@FindBy(xpath = "//td[@class='pl-2']//input[@type='checkbox']")
	private List<WebElement> checkBoxes;
	
	@FindBy(xpath = "//tr[@class='tableContentCheckBox']//td[2]")
	private List<WebElement> campaignID;
	
	@FindBy(xpath = "//*[text()='Remove Keyword']")
	private WebElement removeBtn;
	
	@FindBy(xpath = "//div[@class='keywordpopup__container open']/div/div[1]")
	private WebElement popUpText;
	
	@FindBy(xpath = "//*[@class='popup__button']")
	private WebElement applyBtnPopUp;
	
	
	
	public void mouserOverOnAddIcon() {
		webUtil.actionMouseOver(addIcon);
	}
	
	public void apply_fliter_Search_Term(String expChechbox) throws IOException {
		mouserOverOnAddIcon();
		webUtil.jsClick(search_Term);
		webUtil.actionMouseOver(filterDropdown);
//		Date_Picker datePkr=	new Date_Picker(webUtil);
//		datePkr.customDatePicker();
			dataMapList = excel.getTestCaseData("src\\test\\resources\\TestCaseData.xlsx", "apply_Search_Term_Filter");
		
		for (int k = 0; k <= dataMapList.size() - 1; k++) {
			Map<String, String> dataMap = dataMapList.get(k);
		String productName=	dataMap.get("Product_Name");
		webUtil.selectByVisibleText(product_DD, productName);
		webUtil.actionClick(searchFilterDD);
		webUtil.implicitWait(100);
		webUtil.jsClick(chooseFilterType);
		}
		
		for (int i = 0; i <= searchTerm_List.size() - 1; i++) {
			WebElement name = searchTerm_List.get(i);
			String actText = name.getText();
			if (actText.equals(expChechbox)) {
				System.out.println("Expected checkbox ========= "+expChechbox);
				for (int j = i; j <= i; j++) {
					WebElement checkboxBtn = searhTerm_CheckBoxList.get(i);
					webUtil.implicitWait(5);
					webUtil.jsClick(checkboxBtn);
//					System.out.println(expChechbox);
					webUtil.implicitWait(5);
					webUtil.actionClick(filterDropdown);
				}
				break;
			}

		}
		
		dataMapList = excel.getTestCaseData("src\\test\\resources\\TestCaseData.xlsx", "apply_Search_Term_Filter");
		for (int k = 0; k <= dataMapList.size() - 1; k++) {
			Map<String, String> dataMap = dataMapList.get(k);
		for (int i = 0; i <= radioBtnText.size() - 1; i++) {
			WebElement campaignBgt = radioBtnText.get(i);
			String actText = campaignBgt.getText();
			System.out.println("Actual Data ==== "+ actText);
			String expRadioBtn = dataMap.get("RadioBtn");
			if (actText.equals(expRadioBtn)) {
				System.out.println("Expected radio button ==== "+ expRadioBtn);
				if (expRadioBtn.equalsIgnoreCase("Contains")) {
					System.out.println("Expected radio button ==== "+ expRadioBtn);
					for (int j = i; j <= i; j++) {
						WebElement radioBtn = radioBtnList.get(j);
						webUtil.jsClick(radioBtn);
						System.out.println(actText);
					}
					
					String expValue =dataMap.get("ExpContains");
					webUtil.input(inputBox, expValue);
				} else if (expRadioBtn.equalsIgnoreCase("Doesn't Contains")) {
					for (int j = i; j <= i; j++) {
						WebElement radioBtn = radioBtnList.get(j);
						webUtil.jsClick(radioBtn);
						System.out.println(actText);
					}
					String expValue =dataMap.get("ExpDoesNotContains");
					webUtil.input(inputBox, expValue);
				}
			}
		}
		}
		for (int i = 0; i <= popUpBtn.size() - 1; i++) {
			WebElement button = popUpBtn.get(i);
			String btnText = button.getText();
			if (btnText.equalsIgnoreCase("Apply")) {
				webUtil.jsClick(button);
			}
		}
		
		
		
		
	}
	
	
	
	
}
