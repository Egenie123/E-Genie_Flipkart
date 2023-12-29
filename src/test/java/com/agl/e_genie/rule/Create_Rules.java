package com.agl.e_genie.rule;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.agl.e_genie.utility.WdUtil;

public class Create_Rules {

	private WdUtil webUtil;

	public Create_Rules(WdUtil webUtil) {
		this.webUtil = webUtil;
		PageFactory.initElements(webUtil.getDriver(), this);
	}

	@FindBy(xpath = "//button[@class='header__humburgerBtn']")
	private WebElement humBurger;

	@FindBy(xpath = "//div[contains(text(),'Rules')]")
	private WebElement rulesButton;

	@FindBy(xpath = "//button[@class='card__btn row mb-4']")
	private WebElement createRuleButton;

	@FindBy(xpath = "//*[@type='checkbox']")
	private List<WebElement> platformCheckBox;

	@FindBy(id = "rule_name")
	private WebElement ruleName;

	@FindBy(id = "campaign_type")
	private WebElement campaignType_Dropdown;

	@FindBy(xpath = "//div[@class='rmsc multi-select']//div[@class='dropdown-heading']")
	private WebElement accountDropdown;

	@FindBy(xpath = "//span[normalize-space()='Select All']")
	private WebElement selectAll;

	@FindBy(xpath = "//div[@class='col_6 ']//select[@id='campaign_type']")
	private WebElement campaignType_DD;

	@FindBy(xpath = "//div[contains(@class,'w-1/2 pl-1')]//div[contains(@class,'dropdown-heading-value')]")
	private WebElement tags;

	@FindBy(xpath = "//select[@id='rule_action']")
	private WebElement action_Dropdown;

	@FindBy(xpath = "//input[contains(@class,'w-full border h-10 pl-2 rounded border-gray-300 cursor-not-allowed')]")
	private WebElement increase_Budget;

	@FindBy(xpath = "//span[normalize-space()='tag']")
	private WebElement selectTags;

	@FindBy(id = "budget_type")
	private WebElement budget_Type_Dropdown;

	@FindBy(id = "conditionCategory")
	private WebElement conditionCategory_Dropdown;

	@FindBy(id = "conditionType")
	private WebElement conditionType_DD;

	@FindBy(xpath = "//input[@name='custom']")
	private WebElement schedule_Time;

	@FindBy(xpath = "//div[@class='col_3 px-4']//input")
	private List<WebElement> selectDay;
	
	@FindBy(xpath = "//div[@class='col_3 px-4']//span")
	private List<WebElement> daySlider;
	
	@FindBy(id = "appt_0")
	private WebElement timerIcon;

	@FindBy(xpath = "//button[@class='popup__button text-sm ']")
	private WebElement apply_Button;
	
	@FindBy(xpath = "//button[contains(@class,'weekbtn false')]")
	private WebElement dateWise;

	@FindBy(xpath = "//input[@id='appt_0']")
	private WebElement scheduleDate;
	
	public void create_Rule() {
		webUtil.jsClick(humBurger);

		webUtil.jsClick(rulesButton);

		webUtil.jsClick(createRuleButton);
		for (int i = 0; i <= platformCheckBox.size() - 1; i++) {
			WebElement platform = platformCheckBox.get(i);
			String platformName = webUtil.getAtrbtText(platform, "value");
			if (platformName.equalsIgnoreCase("NA")) {
				webUtil.actionDoudleClick(platform);
				break;
			} else if (platformName.equalsIgnoreCase("SM")) {
				webUtil.click(platform);
				break;
			}
		}

		webUtil.input(ruleName, "Test101");
		webUtil.selectByVisibleText(campaignType_Dropdown, "Campaign");

		webUtil.jsClick(accountDropdown);

		webUtil.jsClick(selectAll);
		webUtil.actionRandomClick();

		webUtil.selectByVisibleText(campaignType_DD, "PLA");

		webUtil.jsClick(tags);

		webUtil.jsClick(selectTags);

		webUtil.selectByVisibleText(action_Dropdown, "Send Notification Only");
		webUtil.scrollPageTillEnd();
//		webUtil.jsClick(dateWise);
//		webUtil.jsClick(scheduleDate);
//		for (int i = 0; i <= selectDay.size() - 1; i++) {
//			WebElement days = selectDay.get(i);
//			WebElement Dyas =daySlider.get(i);
//			String daysText = days.getAttribute("value");
//
//			if (daysText.equalsIgnoreCase("Tuesday")) {
//				webUtil.jsClick(Dyas);
//				webUtil.jsClick(timerIcon);
//			}
//		}
		
		
		webUtil.jsClick(apply_Button);

	}

}
