package com.agl.e_genie.campaign_manager.pages;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.agl.e_genie.excel.utility.Excel_Util;
import com.agl.e_genie.or.common.Or_Common;
import com.agl.e_genie.utility.WdUtil;

public class Campaign_Manager_Filter extends Or_Common {

	private WdUtil webUtil;
	private Excel_Util excel;
	private List<Map<String, String>> dataMapList;
	
	
	public Campaign_Manager_Filter(WdUtil webUtil,List<Map<String, String>> dataMapList,Excel_Util excel) {
		super(webUtil);
		this.webUtil = webUtil;
		this.dataMapList=dataMapList;
		this.excel=excel;
		PageFactory.initElements(webUtil.getDriver(), this);
	}

	@FindBy(xpath = "(//*[@class='liclass__link w-full']//i)[2]")
	private WebElement addIcon;

	@FindBy(xpath = "//div[text()='Campaign Manager']")
	private WebElement campaignManager;

	@FindBy(xpath = "//div[@class='p-treeselect-label-container']")
	private WebElement filterDropdown;

	@FindBy(xpath = "(//li[@class='p-treenode'])[1]//ul//div")
	private List<WebElement> saveSearchButtonList;

	@FindBy(xpath = "//div[@role='treeitem']")
	private List<WebElement> dropDownTextList;

	@FindBy(xpath = "//button[@class='p-tree-toggler p-link']")
	private List<WebElement> checkBoxList;

	@FindBy(xpath = "(//div[@class='p-treenode-content'])[1]//button")
	private WebElement savedSearchBtn;

	@FindBy(xpath = "//li[@class='p-treenode'][1]//ul//div[@role='treeitem']/span")
	private List<WebElement> savedSearchList;

	@FindBy(xpath = "(//div[@class='p-treenode-content'])[2]/button")
	private WebElement nameIDBtn;

	@FindBy(xpath = "//li[@class='p-treenode'][2]//ul//div[@role='treeitem']/span")
	private List<WebElement> nameIDcheckBoxList;

	@FindBy(xpath = "(//li[@class='p-treenode'])[2]//ul//div")
	private List<WebElement> nameIdcheckBoxList;

	@FindBy(xpath = "//div[@class='campaign-name-wrap']//input[@type='text'][1]")
	private WebElement nameIdContainsField;

	@FindBy(xpath = "(//div[@class='campaign-name-wrap']//input[@type='text'])[2]")
	private WebElement nameIdDoesNotContainsField;

	@FindBy(xpath = "//div[@class='flex items-center justify-end p-2  border-solid border-slate-200 rounded-b']//button")
	private List<WebElement> popUpBtn;

	@FindBy(xpath = "(//div[@class='p-treenode-content'])[3]/button")
	private WebElement segmentBtn;

	@FindBy(xpath = "//li[@class='p-treenode'][3]//ul//div[@role='treeitem']/span")
	private List<WebElement> segmentList;

	@FindBy(xpath = "(//li[@class='p-treenode'])[3]//ul//div")
	private List<WebElement> segmentcheckBoxList;

	@FindBy(xpath = "(//div[@class='p-treenode-content'])[4]/button")
	private WebElement platformBtn;

	@FindBy(xpath = "//li[@class='p-treenode'][4]//ul//div[@role='treeitem']/span")
	private List<WebElement> platformList;

	@FindBy(xpath = "(//li[@class='p-treenode'])[4]//ul//div")
	private List<WebElement> platformcheckBoxList;

	@FindBy(xpath = "(//div[@class='p-treenode-content'])[5]/button")
	private WebElement campaignBtn;

	@FindBy(xpath = "//li[@class='p-treenode'][5]//ul//div[@role='treeitem']/span")
	private List<WebElement> campaignList;

	@FindBy(xpath = "(//li[@class='p-treenode'])[5]//ul//div/div/div")
	private List<WebElement> campaigncheckBoxList;

	@FindBy(xpath = "(//div[@class='p-treenode-content'])[6]/button")
	private WebElement campaignBgtBtn;

	@FindBy(xpath = "//li[@class='p-treenode'][6]//ul//div[@role='treeitem']/span")
	private List<WebElement> campaignBgtList;

	@FindBy(xpath = "(//li[@class='p-treenode'])[6]//ul//div/div/div")
	private List<WebElement> campaignBgtcheckBoxList;

	@FindBy(xpath = "(//div[@class='p-treenode-content'])[7]/button")
	private WebElement campaignMatricBtn;

	@FindBy(xpath = "//li[@class='p-treenode'][7]//ul//div[@role='treeitem']/span")
	private List<WebElement> campaignmatricList;

	@FindBy(xpath = "(//li[@class='p-treenode'])[7]//ul//div/div/div")
	private List<WebElement> campaignMatriccheckBoxList;

	@FindBy(xpath = "//div//input[@name='inline-radio-group']")
	private List<WebElement> radioBtnList;

	@FindBy(xpath = "//div[@class='flex items-center mr-4']//label")
	private List<WebElement> radioBtnText;

	@FindBy(xpath = "//input[@placeholder='Search']")
	private WebElement inputBox;
 
	@FindBy(xpath = "//input[@name='metricFrom']")
	private WebElement inputBoxFrom;

	@FindBy(xpath = "//input[@name='metricTo']")
	private WebElement inputBoxTo;

	@FindBy(xpath = "(//div[@class='p-treenode-content'])[8]/button")
	private WebElement addGroupMatricBtn;

	@FindBy(xpath = "//li[@class='p-treenode'][8]//ul//div[@role='treeitem']/span")
	private List<WebElement> addGroupMatricList;

	@FindBy(xpath = "(//li[@class='p-treenode'])[8]//ul//div/div/div")
	private List<WebElement> addGroupMatricCheckBoxList;

	@FindBy(xpath = "(//div[@class='p-treenode-content'])[9]/button")
	private WebElement keywordMatricBtn;

	@FindBy(xpath = "//li[@class='p-treenode'][9]//ul//div[@role='treeitem']/span")
	private List<WebElement> keywordMatricList;

	@FindBy(xpath = "(//li[@class='p-treenode'])[9]//ul//div/div/div")
	private List<WebElement> keywordMatricCheckBoxList;

	@FindBy(xpath = "(//div[@class='p-treenode-content'])[10]/button")
	private WebElement FSNMatricBtn;

	@FindBy(xpath = "//li[@class='p-treenode'][10]//ul//div[@role='treeitem']/span")
	private List<WebElement> FSNMatricList;

	@FindBy(xpath = "(//li[@class='p-treenode'])[10]//ul//div/div/div")
	private List<WebElement> FSNMatricCheckBoxList;

	@FindBy(xpath = "(//div[@class='p-treenode-content'])[11]/button")
	private WebElement creativeMatricBtn;

	@FindBy(xpath = "//li[@class='p-treenode'][11]//ul//div[@role='treeitem']/span")
	private List<WebElement> creativeMatricList;

	@FindBy(xpath = "(//li[@class='p-treenode'])[11]//ul//div/div/div")
	private List<WebElement> creativeMatricCheckBoxList;

	@FindBy(xpath = "(//div[@class='p-treenode-content'])[11]/button")
	private WebElement placementMatricBtn;

	@FindBy(xpath = "//li[@class='p-treenode'][11]//ul//div[@role='treeitem']/span")
	private List<WebElement> placementMatricList;

	@FindBy(xpath = "(//li[@class='p-treenode'])[11]//ul//div/div/div")
	private List<WebElement> placementMatricCheckBoxList;

	@FindBy(xpath = "//i[@class='fas fa-calendar mr-2']")
	private WebElement datePickerDD;

	@FindBy(xpath = "//div[@class='rdrInputRanges']")
	private WebElement selectDateType;

	@FindBy(xpath = "(//div[@class='rdrDays'])[1]//button")
	private List<WebElement> fromDateList;

	@FindBy(xpath = "(//div[@class='rdrDays'])[2]//button//span/span")
	private List<WebElement> toDateList;

	@FindBy(xpath = "//div[@class='flipkart__selectfilter ']//select[@class='campaignselect ']")
	private WebElement productDropDown;

	@FindBy(xpath = "//div[@class='flipkart__selectfilter ']//select//option")
	private List<WebElement> dropdownData;

	@FindBy(xpath = "//select[@class='header__dropdown']")
	private WebElement platformDropDown;

	@FindBy(xpath = "//select[@class='header__dropdown']//option")
	private List<WebElement> platformName;

	@FindBy(xpath = "//button[@class='calBtnApply  false']")
	private WebElement applyBtn;

	@FindBy(xpath = "//button[@class='rdrNextPrevButton rdrPprevButton']")
	private WebElement previousBtn;

	@FindBy(xpath = "//div[@class='rdrMonthName']")
	private WebElement actMonth;

	@FindBy(xpath = "//div[@class='rdrDays']//button")
	private List<WebElement> atribute;

	@FindBy(xpath = "//div[@class='treeselect-input__tags-element']")
	private List<WebElement> chooseFilterToRemove;
	
	@FindBy(xpath = "(//div[@class='p-treenode-content'])[3]/button")
	private WebElement campaignType;
	
	@FindBy(xpath = "(//li[@class='p-treenode'])[3]//ul//div/div/div")
	private List<WebElement> chooseCampaignTypeBtn;
	
	@FindBy(xpath = "//li[@class='p-treenode'][3]//ul//div[@role='treeitem']/span")
	private List<WebElement> chooseCampaignTypeList;
	

	public void removeFilter(String filterName) {
		mouserOverOnAddIcon();
		webUtil.jsClick(campaignManager);
		webUtil.actionMouseOver(filterDropdown);
		for (int i = 0; i <= chooseFilterToRemove.size() - 1; i++) {
			WebElement removeFilter = chooseFilterToRemove.get(i);
			String filterText = removeFilter.getText();
			if (filterText.equalsIgnoreCase(filterName)) {
				removeFilter.click();
			}
		}	
	}

	public void applyConditionViaNumberOnPopup() {
		try {
			dataMapList = excel.getTestCaseData("src\\test\\resources\\TestCaseData.xlsx", "apply_Campaign_Manager_Filter");
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int k = 0; k <= dataMapList.size() - 1; k++) {
			Map<String, String> dataMap = dataMapList.get(k);

		for (int i = 0; i <= radioBtnText.size() - 1; i++) {
			WebElement campaignBgt = radioBtnText.get(i);
			String actText = campaignBgt.getText();
			String expRadioBtn = dataMap.get("RadioBtn");
			if (actText.equals(expRadioBtn)) {
				System.out.println(" ================ "+actText);
				webUtil.getExtentLogger().pass("Applied filter : "+actText);

				if (expRadioBtn.equalsIgnoreCase("is greater than")) {
					for (int j = i; j <= i; j++) {
						WebElement radioBtn = radioBtnList.get(j);
						webUtil.jsClick(radioBtn);
//						System.out.println(actText);
					}
					
					
					String expValue	= dataMap.get("Gretter_Than");
					webUtil.input(inputBox, expValue);
					webUtil.getExtentLogger().pass("Value input in text field : "+expValue);
					System.out.println("Value input successfully");
				
				} else if (expRadioBtn.equalsIgnoreCase("is less than")) {
					for (int j = i; j <= i; j++) {
						WebElement radioBtn = radioBtnList.get(j);
						webUtil.jsClick(radioBtn);
						System.out.println(actText);
					}
					String expvalue =dataMap.get("Less_Than");
					webUtil.input(inputBox, expvalue);

				} else if (expRadioBtn.equalsIgnoreCase("is between")) {
					for (int j = i; j <= i; j++) {
						WebElement radioBtn = radioBtnList.get(j);
						webUtil.jsClick(radioBtn);
						System.out.println(actText);
					}
					String expFromValue = dataMap.get("BtwnFrom");
					String expToValue = dataMap.get("BtwnTo");
					webUtil.input(inputBoxFrom, expFromValue);
					webUtil.input(inputBoxTo, expToValue);

				} else if (expRadioBtn.equalsIgnoreCase("isn't between")) {
					for (int j = i; j <= i; j++) {
						WebElement radioBtn = radioBtnList.get(j);
						webUtil.jsClick(radioBtn);
						System.out.println(actText);
					}
					String expFromValue =dataMap.get("BtwnFrom");
					String expToValue = dataMap.get("BtwnTo");
					webUtil.input(inputBoxFrom, expFromValue);
					webUtil.input(inputBoxTo, expToValue);
					webUtil.getExtentLogger().pass(" From Value input in text field : "+expFromValue);
					webUtil.getExtentLogger().pass("To Value input in text field : "+expToValue);
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

	public void mouserOverOnAddIcon() {
		webUtil.actionMouseOver(addIcon);
	}

	public void clickOnFilterDD() {
		mouserOverOnAddIcon();
		webUtil.jsClick(campaignManager);
		webUtil.actionMouseOver(filterDropdown);
		webUtil.jsClick(filterDropdown);
	}

	public void applyFilterFor_Saved_Search(String expChechbox) {
		clickOnFilterDD();
		webUtil.jsClick(savedSearchBtn);
		for (int i = 0; i <= savedSearchList.size() - 1; i++) {
			WebElement savedSearch = savedSearchList.get(i);
			String actText = savedSearch.getText();
			if (actText.equals(expChechbox)) {
				for (int j = i; j <= i; j++) {
					WebElement checkboxBtn = saveSearchButtonList.get(j);
					webUtil.jsClick(checkboxBtn);
					System.out.println(expChechbox);
					webUtil.actionClick(filterDropdown);
				}
			}
		}

	}

	public void applyFilterFor_NameID(String expNameCheckBox, String expContains, String notContains) {
		clickOnFilterDD();
		webUtil.jsClick(nameIDBtn);

		for (int i = 0; i <= nameIDcheckBoxList.size() - 1; i++) {
			WebElement nameID = nameIDcheckBoxList.get(i);
			String actText = nameID.getText();
			if (actText.equals(expNameCheckBox)) {
				for (int j = i; j <= i; j++) {
					WebElement checkboxBtn = nameIdcheckBoxList.get(j);
					webUtil.staticWait(2);
					webUtil.jsClick(checkboxBtn);

					webUtil.actionClick(filterDropdown);
				}
				break;
			}
		}

		webUtil.input(nameIdContainsField, expContains);
		webUtil.keys("Enter", nameIdContainsField);
		webUtil.input(nameIdDoesNotContainsField, notContains);
		webUtil.keys("Enter", nameIdDoesNotContainsField);
		for (int i = 0; i <= popUpBtn.size() - 1; i++) {
			WebElement button = popUpBtn.get(i);
			String btnText = button.getText();
			if (btnText.equalsIgnoreCase("Apply")) {
				webUtil.jsClick(button);
				break;
			}
		}

	}

	public void applyFilterFor_Segment(String expChechbox) {
		try {
			clickOnFilterDD();
			webUtil.jsClick(segmentBtn);
			for (int i = 0; i <= segmentList.size() - 1; i++) {
				WebElement savedSearch = segmentList.get(i);
				String actText = savedSearch.getText();
				if (actText.equals(expChechbox)) {
					for (int j = i; j <= i; j++) {
						WebElement checkboxBtn = segmentcheckBoxList.get(j);
						webUtil.jsClick(checkboxBtn);
						System.out.println(expChechbox);
						webUtil.actionClick(filterDropdown);
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Exception handing : - ");
		}

	}

	public void applyFilterFor_Platform(String expChechbox) {
		clickOnFilterDD();
		webUtil.jsClick(platformBtn);
		for (int i = 0; i <= platformList.size() - 1; i++) {
			WebElement savedSearch = platformList.get(i);
			String actText = savedSearch.getText();
			if (actText.equals(expChechbox)) {
				for (int j = i; j < i; j++) {
					WebElement checkboxBtn = platformcheckBoxList.get(j);
					webUtil.jsClick(checkboxBtn);
					System.out.println(expChechbox);
					webUtil.actionClick(filterDropdown);
				}
			}
		}

	}

	public void applyFilterFor_CampaignStatus(String expChechbox) {
		clickOnFilterDD();
		webUtil.jsClick(campaignBtn);
		for (int i = 0; i <= campaignList.size() - 1; i++) {
			WebElement campaign = campaignList.get(i);
			String actText = campaign.getText();
			if (actText.equalsIgnoreCase(expChechbox)) {
				for (int j = i; j < i; j++) {
					WebElement checkboxBtn = campaigncheckBoxList.get(j);
					webUtil.jsClick(checkboxBtn);
					System.out.println(actText);
					webUtil.actionClick(filterDropdown);

				}
			}

		}
	}

	public void applyFilterFor_CampaignBugetType(String expChechbox) {
		clickOnFilterDD();
		webUtil.jsClick(campaignBgtBtn);
		for (int i = 0; i <= campaignBgtList.size() - 1; i++) {
			WebElement campaignBgt = campaignBgtList.get(i);
			String actText = campaignBgt.getText();
			if (actText.equals(expChechbox)) {
				for (int j = i; j < i; j++) {
					WebElement checkboxBtn = campaignBgtcheckBoxList.get(j);
					webUtil.jsClick(checkboxBtn);
					System.out.println(actText);
					webUtil.actionClick(filterDropdown);
				}
			}
		}

	}

	public void applyFilterFor_CampaignMatric(String expChechbox) {
		clickOnFilterDD();
		webUtil.jsClick(campaignMatricBtn);
		for (int i = 0; i <= campaignmatricList.size() - 1; i++) {
			WebElement campaignBgt = campaignmatricList.get(i);
			String actText = campaignBgt.getText();
			if (actText.equals(expChechbox)) {
				for (int j = i; j <= i; j++) {
					WebElement checkboxBtn = campaignMatriccheckBoxList.get(j);
					webUtil.jsClick(checkboxBtn);
					System.out.println(actText);
					applyConditionViaNumberOnPopup();
				}
			}
		}

	}
	
	
	public void applyFilterFor_AddGroupMatric(String expChechbox) {
		clickOnFilterDD();
		webUtil.jsClick(addGroupMatricBtn);
		for (int i = 0; i <= addGroupMatricList.size() - 1; i++) {
			WebElement adGroupMatric = addGroupMatricList.get(i);
			String actText = adGroupMatric.getText();
			if (actText.equals(expChechbox)) {
				for (int j = i; j <= i; j++) {
					WebElement checkboxBtn = addGroupMatricCheckBoxList.get(j);
					webUtil.jsClick(checkboxBtn);
					applyConditionViaNumberOnPopup();
				}
				break;
			}
		}
	}
	
	
	

	public void applyFilterFor_KeywordMatric(String expChechbox) {
		clickOnFilterDD();
		webUtil.jsClick(keywordMatricBtn);
		for (int i = 0; i <= keywordMatricList.size() - 1; i++) {
			WebElement campaignBgt = keywordMatricList.get(i);
			String actText = campaignBgt.getText();
			if (actText.equals(expChechbox)) {
				for (int j = i; j <= i; j++) {
					WebElement checkboxBtn = keywordMatricCheckBoxList.get(j);
					webUtil.jsClick(checkboxBtn);
					System.out.println(actText);
					applyConditionViaNumberOnPopup();
				}
			}
		}

	}

	public void applyFilterFor_FSNMatric(String expChechbox) {
		clickOnFilterDD();
		webUtil.jsClick(FSNMatricBtn);
		for (int i = 0; i <= FSNMatricList.size() - 1; i++) {
			WebElement campaignBgt = FSNMatricList.get(i);
			String actText = campaignBgt.getText();
			if (actText.equals(expChechbox)) {
				for (int j = i; j <= i; j++) {
					WebElement checkboxBtn = FSNMatricCheckBoxList.get(j);
					webUtil.jsClick(checkboxBtn);
					System.out.println(actText);
					webUtil.getExtentLogger().pass("FSN Matric actual data : "+actText);
					applyConditionViaNumberOnPopup();
				}
			}
		}

	}

	public void applyFilterFor_CreativeMatric(String expChechbox) {
		clickOnFilterDD();
		webUtil.jsClick(creativeMatricBtn);
		for (int i = 0; i <= creativeMatricList.size() - 1; i++) {
			WebElement campaignBgt = creativeMatricList.get(i);
			String actText = campaignBgt.getText();
			if (actText.equals(expChechbox)) {
				for (int j = i; j <= i; j++) {
					WebElement checkboxBtn = creativeMatricCheckBoxList.get(j);
					webUtil.jsClick(checkboxBtn);
					System.out.println(actText);
					webUtil.getExtentLogger().pass("Creative matric actual data : "+actText);
					applyConditionViaNumberOnPopup();
				}
			}
		}

	}

	public void applyFilterFor_PlacementMatric(String expChechbox) {
		clickOnFilterDD();
		webUtil.jsClick(placementMatricBtn);
		for (int i = 0; i <= placementMatricList.size() - 1; i++) {
			WebElement campaignBgt = placementMatricList.get(i);
			String actText = campaignBgt.getText();
			if (actText.equals(expChechbox)) {
				for (int j = i; j <= i; j++) {
					WebElement checkboxBtn = placementMatricCheckBoxList.get(j);
					webUtil.jsClick(checkboxBtn);
					System.out.println(actText);
					applyConditionViaNumberOnPopup();
				}
			}
		}

	}
	
	public void applyFilterFor_chooseCampaignType(String expChechbox) {
		clickOnFilterDD();
		webUtil.jsClick(campaignType);
		for (int i = 0; i <= chooseCampaignTypeList.size() - 1; i++) {
			WebElement campaignBgt = chooseCampaignTypeList.get(i);
			String actText = campaignBgt.getText();
			if (actText.equals(expChechbox)) {
				for (int j = i; j <= i; j++) {
					WebElement checkboxBtn = chooseCampaignTypeBtn.get(j);
					webUtil.jsClick(checkboxBtn);
					System.out.println(actText);
				}
			}
		}

	}
	
	
	

}
