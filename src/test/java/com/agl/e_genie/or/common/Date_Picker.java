package com.agl.e_genie.or.common;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.agl.e_genie.utility.WdUtil;

public class Date_Picker {

	private WdUtil webUtil;

	public Date_Picker(WdUtil webUtil) {
		this.webUtil = webUtil;
		PageFactory.initElements(webUtil.getDriver(), this);
	}

	@FindBy(xpath = "//div[text()='Campaign Manager']")
	private WebElement campaignManager;

	@FindBy(xpath = "//div[@class='p-treeselect-label-container']")
	private WebElement filterDropdown;

	@FindBy(xpath = "//div[@class='pr-2']//*[name()='svg']//*[name()='path' and contains(@d,'M148 288h-')]")
	private WebElement datePickerDD;

	@FindBy(xpath = "//div[@class='rdrInputRanges']")
	private WebElement selectDateType;

	@FindBy(xpath = "(//div[@class='rdrDays'])[1]//button")
	private List<WebElement> fromDateList;

	@FindBy(xpath = "(//div[@class='rdrDays'])[2]//button//span/span")
	private List<WebElement> toDateList;

	@FindBy(xpath = "//*[text()='Apply']")
	private WebElement applyBtn;

	@FindBy(xpath = "//button[@class='rdrNextPrevButton rdrPprevButton']")
	private WebElement previousBtn;

	@FindBy(xpath = "//div[@class='rdrMonthName']")
	private WebElement actMonth;

	@FindBy(xpath = "(//li[@class='text-center text-sm menu liclass px-0 false false'])[1]")
	private WebElement addIcon;

	@FindBy(xpath = "//div[@class='rdrDefinedRangesWrapper']//span")
	private List<WebElement> dateTypes;

	public void mouserOverOnAddIcon() {
		webUtil.actionMouseOver(addIcon);
	}

	public void customDatePicker() {
		webUtil.ExplicitWaitClick(webUtil.getDriver(),datePickerDD,20);
				webUtil.jsClick(selectDateType);
				String expMonth = webUtil.getConfigValue("ExpMonthYear");
				while (true) {
					String monthText = actMonth.getText();
					if (monthText.equalsIgnoreCase(expMonth)) {
						break;
					} else {
						webUtil.jsClick(previousBtn);
					}
				}
				for (WebElement fromDate : fromDateList) {
					String frmDate = webUtil.getInerText(fromDate);
					String actFromDate = webUtil.getConfigValue("ExpDateFrom");
					if (frmDate.equalsIgnoreCase(actFromDate)) {
						for (WebElement toDate : toDateList) {
							String expToDate = webUtil.getConfigValue("ExpDateTo");
							String actToDateText = webUtil.getInerText(toDate);
							if (actToDateText.equalsIgnoreCase(expToDate)) {
								webUtil.actiondragAndDrop(fromDate, toDate);
							}
						}
					}
				}
				webUtil.scrollPage();
				webUtil.jsClick(applyBtn);
			}
		
	
	public void chooseDateType() {
		webUtil.ExplicitWaitClick(webUtil.getDriver(),datePickerDD,20);
		for (int i = 0; i <= dateTypes.size() - 1; i++) {
			WebElement dateType = dateTypes.get(i);
			String actDateType = webUtil.getInerText(dateType);
			String expDateTpe = webUtil.getConfigValue("ExpDateType");
			if (actDateType.equalsIgnoreCase(expDateTpe)) {
				webUtil.jsClick(dateType);
			} 
		
		}
		
	}
	

}
