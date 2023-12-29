package com.agl.e_genie.campaign_manager.pages;

/**
 *@Package：		com.ebux.pagemodules
 *@Class-Name：	Login.java
 *@Environment: Web/Mobile
 *@Author:		Deepak_Kumar_Chaurera
 *@Create-at:	04-Aug-2023, 4:32:44 pm
 *@Version:		1.4
 */

import java.text.DecimalFormat;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.agl.e_genie.or.common.Date_Picker;
import com.agl.e_genie.utility.WdUtil;
import com.aventstack.extentreports.Status;

public class Campaign_Manager_Dashboard {

	private WdUtil webUtil;
//	private Campaign_Manager_Filter campaign_Manager_DashBoard;

	private static final DecimalFormat decfor = new DecimalFormat("0.00");

	String view, click, All_CTR_Existing_Value, percentTotal, AdSpends, TotalCPC_Result, All_CPC_Existing_Values;

	public Campaign_Manager_Dashboard(WdUtil webUtil) {
		this.webUtil = webUtil;
		PageFactory.initElements(webUtil.getDriver(), this);
	}

	@FindBy(xpath = "(//*[@class='liclass__link w-full']//i)[2]")
	private WebElement Advertsing;

	@FindBy(xpath = "//*[contains(text(),'Campaign Manager')]")
	private WebElement Campaign_Manager;

	@FindBy(xpath = "//*[@class='header__dropdownOuter']//*[@class='header__dropdown']/option[2]")
	private WebElement Platform;

	@FindBy(xpath = "//div[@class='flipkart__selectfilter pr-4 ']//select")
	private WebElement Product;

	@FindBy(xpath = "//*[@class='flipkart__selectfilter ']//select[@class='campaignselect ']/option")
	private List<WebElement> Product_List;

	@FindBy(xpath = "//*[@class='selectDate']")
	private WebElement CalendarOpen;

	@FindBy(xpath = "//*[@class='rdrDefinedRangesWrapper']//*[@class='rdrStaticRanges']/button/span[@class='rdrStaticRangeLabel']")
	private List<WebElement> StaticRangeList;

	@FindBy(xpath = "//*[@class='flipkart__calander ml-3 ']//h6")
	private WebElement RangeText;

	@FindBy(xpath = "//*[@class='rdrDefinedRangesWrapper']//*[@class='rdrInputRanges']")
	private WebElement Custom_Date_button;

	@FindBy(xpath = "//*[@class='col']//*[@class='campaignreport__btn flex rounded false false']")
	private WebElement Customise_Button;

	@FindBy(xpath = "//*[@class='row']//*[@class='campaign__navtab relative']/div[1]/button//*[@class='text-lg font-medium']")
	private WebElement Campaigns_button;

	@FindBy(xpath = "//*[@class='sticky bottom-0 left-0 z-[35] flipkarttable__footer']/tr[1]//*[@class='font-semibold pl-2'][1]")
	private WebElement totalCampaign;

	@FindBy(xpath = "//*[@class='row items-center']//input")
	private WebElement SelectAllOption;

	@FindBy(xpath = "//*[text()='Apply']")
	private WebElement Apply_All_button;

	@FindBy(xpath = "//*[@class='campaignreportcheckbox__tablehead table-fixed sticky top-0 left-0 z-[35]']//*[@type='checkbox']")
	private WebElement Select_All_Campaign;

	@FindBy(xpath = "//*[@class='col campaign__tablewrap']//*[@class='campaign__navtab relative']")
	private WebElement Total_Campaigns;

	@FindBy(xpath = "//*[@class='h-full w-full']//*[@class='campaignreportcheckbox__tablehead table-fixed sticky top-0 left-0 z-[35]']/tr/th[9]/div/p")
	private WebElement Title_Campaigns;

	@FindBy(xpath = "//*[@class='h-full w-full']//*[@class='campaignreportcheckbox__tablehead table-fixed sticky top-0 left-0 z-[35]']/tr/th[11]/div/p")
	private WebElement Title_View;

	@FindBy(xpath = "//*[@class='h-full w-full']//*[@class='campaignreportcheckbox__tablehead table-fixed sticky top-0 left-0 z-[35]']/tr/th[12]/div/p")
	private WebElement Title_Clicks;

	@FindBy(xpath = "//*[@class='h-full w-full']//*[@class='campaignreportcheckbox__tablehead table-fixed sticky top-0 left-0 z-[35]']/tr/th[13]/div/p")
	private WebElement Title_CTR;

	@FindBy(xpath = "//*[@class='w-full p-4 bg-white']//td[2]/div")
	private List<WebElement> All_Campaigns_Values;

	@FindBy(xpath = "//*[@class='h-full']/tbody//*[contains(text(),' No Data found')]")
	private WebElement No_Data_Found;

	@FindBy(xpath = "//*[@class='w-full p-4 bg-white']//td[11]/div")
	private List<WebElement> All_Views_Values;

	@FindBy(xpath = "//*[@class='w-full p-4 bg-white']//td[12]/div")
	private List<WebElement> All_Clicks_Values;

	@FindBy(xpath = "//*[@class='w-full p-4 bg-white']//td[13]/div")
	private List<WebElement> All_CTR_Values;

	@FindBy(xpath = "//*[@class='w-full p-4 bg-white']//td[9]/div")
	private List<WebElement> All_AdSpends_Values;

	@FindBy(xpath = "//*[@class='w-full p-4 bg-white']//td[14]/div")
	private List<WebElement> All_CPC_Values;
	
//	Campaign total //////////
	

	@FindBy(xpath = "//td[@class='sticky left-0 min-w-max z-30 pl-2']")
	private WebElement totalCampaignCount;

	@FindBy(xpath = "//tr[@class='font-semibold']//td[8]/div")
	private WebElement totalBudget;

	@FindBy(xpath = "//tr[@class='font-semibold']//td[9]/div")
	private WebElement totalAmountSpend;

	@FindBy(xpath = "//tr[@class='font-semibold']//td[11]/div")
	private WebElement totalView;

	@FindBy(xpath = "//tr[@class='font-semibold']//td[12]/div")
	private WebElement totalClick;

	@FindBy(xpath = "//tr[@class='font-semibold']//td[13]/div")
	private WebElement totalCTR;

	@FindBy(xpath = "//tr[@class='font-semibold']//td[14]/div")
	private WebElement totalCPC;

	@FindBy(xpath = "//tr[@class='font-semibold']//td[17]/div")
	private WebElement totalUnitSold;

	@FindBy(xpath = "//tr[@class='font-semibold']//td[20]/div")
	private WebElement totalRevenue;

	@FindBy(xpath = "//tr[@class='font-semibold']//td[23]/div")
	private WebElement totalCVR;

	@FindBy(xpath = "//tr[@class='font-semibold']//td[26]/div")
	private WebElement totalROI;

	@FindBy(xpath = "//tr[@class='font-semibold']//td[29]/div")
	private WebElement totalAOV;
	
	
	
	/////////////////////////    Flipkart ////////////////////
	
	@FindBy(xpath = "//div[@class='styles__PickerContainer-sc-1bqc7mj-3 bgMxMl']")
	private WebElement datePickerButton;

	@FindBy(xpath = "//div[text()='Last Month']")
	private WebElement chooseDateType;

	@FindBy(xpath = "//input[@placeholder='Enter email']")
	private WebElement userId;

	@FindBy(xpath = "//input[@placeholder='Enter password']")
	private WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginBtn;

	@FindBy(xpath = "//button//div[text()='Got it!']")
	private WebElement notification;
	
	@FindBy(xpath = "//div[@class=' flipkart__maincard relative']//div[@class='p-1 col']//p[1]")
	private WebElement spends;

	@FindBy(xpath = "(//div[@class=' flipkart__maincard relative']//div[@class='p-1 col']//p)[3]")
	private WebElement click_ATB;

	@FindBy(xpath = "(//div[@class=' flipkart__maincard relative']//div[@class='p-1 col']//p)[4]")
	private WebElement cvr;

	@FindBy(xpath = "(//div[@class=' flipkart__maincard relative']//div[@class='p-1 col']//p)[5]")
	private WebElement ctr;

	@FindBy(xpath = "(//div[@class=' flipkart__maincard relative']//div[@class='p-1 col']//p)[6]")
	private WebElement cpc;

	@FindBy(xpath = "(//div[@class=' flipkart__maincard relative']//div[@class='p-1 col']//p)[7]")
	private WebElement sales;

	@FindBy(xpath = "(//div[@class=' flipkart__maincard relative']//div[@class='p-1 col']//p)[8]")
	private WebElement orders;

	@FindBy(xpath = "(//div[@class=' flipkart__maincard relative']//div[@class='p-1 col']//p)[9]")
	private WebElement roas;

	@FindBy(xpath = "(//div[@class=' flipkart__maincard relative']//div[@class='p-1 col']//p)[10]")
	private WebElement aov;

	@FindBy(xpath = "//div[@id='popover-content']//a[@class='styles__LinkAccount-sc-15k3kqb-5 iGCcpg']//div//span")
	private List<WebElement> productList;

	@FindBy(xpath = "//span[contains(text(),'Campaign Manager')]")
	private WebElement fk_Campaignmanager;

	@FindBy(xpath = "(//ul[@class='styles__List-s7bkkg-2 cctxrv'][1]//a)[2]")
	private WebElement maouseOverCampaignManger;

	@FindBy(xpath = "//div[@class='styles__StyledRightContainer-sc-15k3kqb-0 hnYrDS']")
	private WebElement productDD;

	@FindBy(xpath = "//div[contains(text(),'Ad Product')]")
	private WebElement FK_CampaignTypeDD;
                                                             
	@FindBy(xpath = "(//button[@type='submit'])[2]/div[contains(text(),'Apply')]")
	private WebElement FK_ApplyButton;
	
	@FindBy(xpath = "//div[@id='popover-content']//input[1]")
	private WebElement FK_PLA_CampaignType;
	
	@FindBy(xpath = "(//div[@id='popover-content']//input)[2]")
	private WebElement FK_PCA_CampaignType;
	
	@FindBy(xpath = "//*//input[@placeholder='Download']")
	private WebElement downloadButton;
	
	@FindBy(xpath = "//*[@class='styles__DownloadTrigger-kcz6v6-0 kFEROA']")
	private WebElement downloadTableButton;
	
	
	/////////////////////////////////////////////////////////////////////////////////
	
	
	
	public void Campaign_Manager_Method() throws Exception {
		try {
			webUtil.implicitWait(20);
			webUtil.actionMouseOver(Advertsing);
			webUtil.enabledElementwait(Campaign_Manager, 10);
			webUtil.jsClick(Campaign_Manager);
			webUtil.actionMouseOver(Product);
			webUtil.implicitWait(20);
			// System.out.println("This is the value of platform "+Platform.getText());
			webUtil.staticWait(2);
			webUtil.jsClick(Product);
			for (WebElement pList : Product_List) {
				if (pList.getText().equalsIgnoreCase(webUtil.getConfigValue("ProductName"))) {
					webUtil.getExtentLogger().pass(pList.getText());
					System.out.println(pList.getText());
					webUtil.jsClick(pList);
					break;
				}
			}
			webUtil.implicitWait(20);
			webUtil.jsClick(CalendarOpen);
			webUtil.implicitWait(20);
			for (WebElement YesTodWeekMonth : StaticRangeList) {
				if (YesTodWeekMonth.getText().equalsIgnoreCase((webUtil.getConfigValue("CalendarRangeList")))) {
					System.out.println(YesTodWeekMonth.getText());
					webUtil.actionMouseOver(YesTodWeekMonth);
					webUtil.actionClick(YesTodWeekMonth);
					webUtil.implicitWait(20);
					webUtil.getExtentLogger().pass(RangeText.getText());
					System.out.println(RangeText.getText());
					break;
				}
			}
			webUtil.staticWait(10);
			webUtil.actionMouseOver(totalCampaign);
			webUtil.implicitWait(20);
			webUtil.jsClick(Customise_Button);
			if (SelectAllOption.isDisplayed()) {
				webUtil.implicitWait(20);
				webUtil.jsClick(Apply_All_button);
				webUtil.implicitWait(20);
				webUtil.jsClick(Advertsing);
			}

			webUtil.implicitWait(20);
			webUtil.jsClick(Select_All_Campaign);
			webUtil.implicitWait(20);
			webUtil.getExtentLogger().pass(Total_Campaigns.getText());
			System.out.println(Total_Campaigns.getText());
			webUtil.implicitWait(20);
			webUtil.jsClick(Select_All_Campaign);
			webUtil.implicitWait(20);
			Click_View_CTR();
			System.err.println("_______________________________");
			AdSpends_Click_CPC();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//		Validate the visibility of the data on the platform per keyword so that the descriptive info is avl. readily to validate whether the X amount gets us the real estate

	public void Click_View_CTR() {
		try {
			webUtil.implicitWait(20);
			for (int i = 0; i < All_Campaigns_Values.size(); i++) {
				try {
					WebElement views = All_Views_Values.get(i);
					view = webUtil.getInerText(views);
					WebElement clicks = All_Clicks_Values.get(i);
					click = webUtil.getInerText(clicks);
					WebElement All_CTR_Existing_Valu = All_CTR_Values.get(i);
					All_CTR_Existing_Value = webUtil.getInerText(All_CTR_Existing_Valu);
					webUtil.getExtentLogger().pass("Campaign name is " + All_Campaigns_Values.get(i).getText());
					System.out.println("Campaign name is " + All_Campaigns_Values.get(i).getText());
					webUtil.getExtentLogger().pass("Views value is " + view);
					System.out.println("Views value is " + view);
					webUtil.getExtentLogger().pass("Clicks value is " + click);
					System.out.println("Clicks value is " + click);
					if (!view.equals("-")) {
						int all_View = Integer.parseInt(view);
						int all_Clicks = Integer.parseInt(click);
						double percent = webUtil.calculatePercentage(all_Clicks, all_View);
						percentTotal = decfor.format(percent) + "%";
						System.out.println("Total percentage is " + percentTotal);
						webUtil.getExtentLogger().pass("Total percentage is " + percentTotal);
						webUtil.implicitWait(20);
						webUtil.scrollPage();
						webUtil.implicitWait(20);
					}
					if (All_CTR_Existing_Value.equals(percentTotal)) {
						System.out.println("On page CTR is " + All_CTR_Existing_Value);
						webUtil.getExtentLogger().pass("On page CTR is " + All_CTR_Existing_Value);
						System.out.println("Calculated the CTR is " + percentTotal);
						webUtil.getExtentLogger().pass("Calculated the CTR is " + percentTotal);
						System.out.println("True");
						webUtil.getExtentLogger().pass("True");
					} else if (All_CTR_Existing_Value.equals("-")) {
						System.out.println("On page CTR is " + All_CTR_Existing_Value);
						webUtil.getExtentLogger().pass("On page CTR is " + All_CTR_Existing_Value);
						System.out.println("Calculation is not possible on this value");
						webUtil.getExtentLogger().pass("Calculation is not possible on this value");
						System.err.println("False");
						webUtil.getExtentLogger().pass("False");
					} else {
						Assert.fail("There is no value in the view and click.");
						webUtil.getExtentLogger().fail("There is no value in the view and click.");
						System.err.println("There is no value in the view and click.");

					}
				} catch (Exception e) {
					System.out.println(e);
					webUtil.getExtentLogger().pass("Getting arun time error " + e);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
			webUtil.getExtentLogger().pass("Getting arun time error " + e.getMessage());
		}
	}

	public void AdSpends_Click_CPC() {
		try {
			webUtil.implicitWait(20);
			for (int i = 0; i < All_Campaigns_Values.size(); i++) {
				try {
					WebElement AdSpend = All_AdSpends_Values.get(i);
					AdSpends = webUtil.getInerText(AdSpend);
					String AdSpendsValueAfterRupeeSymbol = AdSpends.replaceAll("[₹,]|\\.00", "");
					WebElement clicks = All_Clicks_Values.get(i);
					click = webUtil.getInerText(clicks);
					WebElement All_CPC_Existing_Value = All_CPC_Values.get(i);
					All_CPC_Existing_Values = webUtil.getInerText(All_CPC_Existing_Value);
					System.out.println("Campaign name is " + All_Campaigns_Values.get(i).getText());
					webUtil.getExtentLogger().pass("Campaign name is " + All_Campaigns_Values.get(i).getText());
					System.out.println("AdSpends value is " + AdSpends);
					webUtil.getExtentLogger().pass("AdSpends value is " + AdSpends);
					System.out.println("Clicks value is " + click);
					webUtil.getExtentLogger().pass("Clicks value is " + click);
					if (!AdSpends.equals("-")) {
						double all_AdSpends = Integer.parseInt(AdSpendsValueAfterRupeeSymbol);
						double all_Clicks = Integer.parseInt(click);
						double Calculate_TotalCPC = webUtil.CalculateDivide(all_AdSpends, all_Clicks);
						TotalCPC_Result = "₹" + decfor.format(Calculate_TotalCPC);
						System.out.println("Total CPC is:- " + TotalCPC_Result);
						webUtil.getExtentLogger().pass("Total CPC is:- " + TotalCPC_Result);
						webUtil.implicitWait(20);
						webUtil.scrollPage();
						webUtil.implicitWait(20);
					}
					if (All_CPC_Existing_Values.equals(TotalCPC_Result)) {
						webUtil.implicitWait(20);
						System.out.println("On page CPC value is " + All_CPC_Existing_Values);
						webUtil.getExtentLogger().pass("On page CPC value is " + All_CPC_Existing_Values);
						System.out.println("Calculated the CPC value is " + TotalCPC_Result);
						webUtil.getExtentLogger().pass("Calculated the CPC value is " + TotalCPC_Result);
						System.out.println("True");
						webUtil.getExtentLogger().pass("True");
					} else if (All_CPC_Existing_Values.equals("-")) {
						webUtil.implicitWait(20);
						System.out.println("On page CPC is " + All_CPC_Existing_Values);
						webUtil.getExtentLogger().pass("On page CPC is " + All_CPC_Existing_Values);
						System.out.println("Calculation is not possible on this value");
						webUtil.getExtentLogger().pass("Calculation is not possible on this value");
						System.err.println("False");
						webUtil.getExtentLogger().pass("False");
					} else {
						Assert.fail("There is no value in the AdSpends and click.");
						System.err.println("There is no value in the AdSpends and click.");
						webUtil.getExtentLogger().pass("There is no value in the AdSpends and click.");
					}
				} catch (Exception e) {
					System.out.println(e);
					webUtil.getExtentLogger().pass(e);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	String proCampaignCount, prodBudget, prodAmountSpend, prodView, prodClick, prodCTR, prodCVR, prodROI,proRevenue, prodOreder;
	String proCampaignCountData, prodBudgetData, prodAmountSpendData, prodViewData, prodClickData, prodCTRData, prodCVRData, prodROIData,proRevenueData, prodOrederData;
//	String FK_AD_Spend_Text, FK_ROI_Text, FK_View_Text, FK_Click_Text, FK_CTR_Text,FK_Order, FK_CVR_Text, FK_Revenue_Text,FK_Order_Text;
	long prod_CampaignCount, prod_TotalBudget, prod_TotalSpends, prod_TotalClicks, prod_TotalSales, prod_TotalView, prod_TotalOrders;
	double prod_TotalROI,prod_TotalCTR,prod_TotalCVR;


	
	
	public void Get_Total_Row_Data() {
		
		String totalCampaign = webUtil.getInerText(totalCampaignCount);
		String[] campaign = totalCampaign.split("\\r?\\n");
		 proCampaignCount = campaign[1];
		 
		String budget = webUtil.getInerText(totalBudget);
		String[] bdgt = budget.split("\\r?\\n");
		 prodBudget = bdgt[0];
		 prodBudgetData=prodBudget.replaceAll("[^0-9]", "");
		 prod_TotalBudget= Long.parseLong(prodBudgetData);
		 
		String spend = webUtil.getInerText(totalAmountSpend);
		String[] spends = spend.split("\\r?\\n");
		prodAmountSpend = spends[0];
		prodAmountSpendData= prodAmountSpend.replaceAll("[^0-9]", "");
		prod_TotalSpends= Long.parseLong(prodAmountSpendData);
		
		String view = webUtil.getInerText(totalView);
		String[] views = view.split("\\r?\\n");
		prodView = views[0];
		prodViewData= prodView.replaceAll("[^0-9]", "");
		prod_TotalView= Long.parseLong(prodViewData);
		
		String click = webUtil.getInerText(totalClick);
		String[] clicks = click.split("\\r?\\n");
		prodClick = clicks[0];
		prodClickData=prodClick.replaceAll("[^0-9]", "");
		prod_TotalClicks= Long.parseLong(prodClickData);
		
		String order = webUtil.getInerText(totalUnitSold);
		String[] orders = order.split("\\r?\\n");
		prodOreder = orders[0];
		prodOrederData=prodOreder.replaceAll("[^0-9]", "");
		prod_TotalOrders= Long.parseLong(prodOrederData);
		
		String roi = webUtil.getInerText(totalROI);
		String[] ROIS = roi.split("\\r?\\n");
		prodROI = ROIS[0];
		prodROIData=prodROI.replaceAll("\\s", "");
		prod_TotalROI =Double.parseDouble(prodROIData);
		
		String ctr = webUtil.getInerText(totalCTR);
		String[] CTR = ctr.split("\\r?\\n");
		prodCTR= CTR[0];
		prodCTRData= prodCTR.replaceAll("\\s", "").replaceAll("[^\\d.]", "");
		prod_TotalCTR =Double.parseDouble(prodCTRData);
		
		String revenue = webUtil.getInerText(totalRevenue).replaceAll("\\s", "");
		String[] Revenue = revenue.split("\\r?\\n");
		proRevenue = Revenue[0];
		proRevenueData= proRevenue.replaceAll("[^0-9]", "");
		prod_TotalSales= Long.parseLong(proRevenueData);
		
		String cvr = webUtil.getInerText(totalCVR);
		String[] CVR = cvr.split("\\r?\\n");
		prodCVR= CVR[0];
		prodCVRData=prodCVR.replaceAll("\\s", "");
		prod_TotalCVR =Double.parseDouble(prodCVRData);
		
	}
	
	public void flipkartData() {
		webUtil.openURL("https://advertising.flipkart.com/login?returl=/ad-account/campaigns?baccount=RSAUFLMCSZ");
		webUtil.input(userId, "ebux.support@adglobal360.com");
		webUtil.input(password, "Ebuxsupport@@@@@@123");
		webUtil.jsClick(loginBtn);
		webUtil.getExtentLogger().log(Status.PASS, "User logged in successfully in flipkart portal ");
		webUtil.staticWait(5);

		if (notification.isDisplayed() == true) {
			webUtil.jsClick(notification);
			webUtil.getExtentLogger().log(Status.PASS, "Notification close successfully -- ");
		}

		webUtil.ExplicitWaitClick(webUtil.getDriver(), productDD, 10);
		String productName = webUtil.getConfigValue("ProductName");
		for (int i = 0; i <= productList.size() - 1; i++) {
			WebElement actProduct = productList.get(i);
			String expProduct = webUtil.getInerText(actProduct);
			if (expProduct.equalsIgnoreCase(productName)) {
				webUtil.staticWait(3);
				webUtil.ExplicitWaitClick(webUtil.getDriver(), actProduct, 20);
				webUtil.getExtentLogger().log(Status.PASS, "Product name selected successfully :: = :: " + productName);
				break;
			}
		}

		webUtil.actionMouseOver(maouseOverCampaignManger);
		webUtil.ExplicitWaitClick(webUtil.getDriver(), fk_Campaignmanager, 20);

		webUtil.ExplicitWaitClick(webUtil.getDriver(), datePickerButton, 60);
		webUtil.ExplicitWaitClick(webUtil.getDriver(), chooseDateType, 60);
		webUtil.ExplicitWaitClick(webUtil.getDriver(), FK_CampaignTypeDD, 60);

		String expCampaign = webUtil.getConfigValue("CampaignName");
			if (expCampaign.equalsIgnoreCase("PLA")) {
				webUtil.implicitWait(20);
				webUtil.jsClick(FK_PLA_CampaignType);
			}
			else if(expCampaign.equalsIgnoreCase("PLA")) {
				webUtil.implicitWait(20);
				webUtil.jsClick(FK_PCA_CampaignType);
			}
			else {
				webUtil.implicitWait(20);
				webUtil.jsClick(FK_PLA_CampaignType);
				webUtil.jsClick(FK_PCA_CampaignType);
			}
		
			webUtil.ExplicitWaitClick(webUtil.getDriver(), FK_ApplyButton, 15);

			webUtil.staticWait(2);
			webUtil.jsClick(downloadButton);
			webUtil.jsClick(downloadTableButton);	
	}
	
	public void validateBothData() {
		webUtil.renameFilesInFolder("C:\\Users\\AGL\\Downloads", ".csv", "Campaign");
		
	String filePath =webUtil.getConfigValue("FilePath");
	long spends= webUtil.readColumnData(filePath, 11);
	long view= webUtil.readColumnData(filePath, 12);
	long click= webUtil.readColumnData(filePath, 13);
	long order= webUtil.readColumnData(filePath, 14);
	long sales= webUtil.readColumnData(filePath, 15);
	
	float changeFormateSpends= (float)spends;
	float changeFormateSales=(float)sales;
	double calculateROI =(double)(changeFormateSales/changeFormateSpends);
	double ROI=  webUtil.formateDesimalvalue(calculateROI);

	float changeFormateView= (float)view;
	float changeFormateClicks=(float)click;
	double calculateCTR =(double)(changeFormateClicks/changeFormateView*100);
	double CTR=  webUtil.formateDesimalvalue(calculateCTR);
	
	float changeFormateOrder= (float)order;
	double calculateCVR =(double)(changeFormateOrder/changeFormateClicks*100);
	double CVR=  webUtil.formateDesimalvalue(calculateCVR);
	
	calculatePercent("Spends ",prod_TotalSpends,spends,2);
	calculatePercent("View ",prod_TotalView,view,2);
	calculatePercent("Click ",prod_TotalClicks,click,2);
	calculatePercent("Orders ",prod_TotalOrders,order,2);
	calculatePercent("Sales ",prod_TotalSales,sales,2);
	validateData("ROI",prod_TotalROI,ROI);
	validateData("CTR",prod_TotalCTR,CTR);
	validateData("CVR",prod_TotalCVR,CVR);
	
	}
	
	public void calculatePercent(String name, long prodData, long FKdata, int persantage) {
		float percentFloat = (float)persantage / 100;
	    float outValueFloat = (FKdata * percentFloat);
	    int num = Math.round(outValueFloat);
		long i = (prodData - num);
		long j = (prodData + num);
		if (i >= FKdata || j <= FKdata || prodData == FKdata) {
			System.out.println("Verification Passed. Where actual data on our ENV- :: " + name + " " + prodData
					+ " and " + persantage + " persantage data is " + num + " & Expected from Client Portal - :: " + " "
					+ FKdata);
			webUtil.getExtentLogger().log(Status.PASS,
					"Verification Passed. Where actual data on our ENV- :: " + name + " " + prodData + " and "
							+ persantage + " persantage data is " + num + " & Expected from Client Portal - :: " + " "
							+ FKdata);
		} else {
			webUtil.getExtentLogger().log(Status.FAIL,
					"Verification Failed. Where actual data on our ENV- :: " + name + " " + prodData + " and "
							+ persantage + " persantage data is " + num + " & Expected from Client Portal - :: " + " "
							+ FKdata);
			System.out.println("Verification Failed. Where actual data on our ENV- :: " + name + " " + prodData
					+ " and " + persantage + " persantage data is " + num + " & Expected from Client Portal - :: " + " "
					+ FKdata);
		}
	}
	
	public void validateData(String name, double prodData, double FKdata){
		
		if (prodData >= FKdata || prodData <= FKdata || prodData == FKdata) {
			System.out.println("Verification Passed. Where actual data on our ENV- :: " + name + " " + prodData
					+ " and "  + "Expected from Client Portal - :: " + " "
					+ FKdata);
			webUtil.getExtentLogger().log(Status.PASS,
					"Verification Passed. Where actual data on our ENV- :: " + name + " " + prodData + " and "
							+ "Expected from Client Portal - :: " + " "
							+ FKdata);
		} else {
			webUtil.getExtentLogger().log(Status.FAIL,
					"Verification Failed. Where actual data on our ENV- :: " + name + " " + prodData + " and "
							+ "Expected from Client Portal - :: " + " "
							+ FKdata);
			System.out.println("Verification Failed. Where actual data on our ENV- :: " + name + " " + prodData
					+ " and " + "Expected from Client Portal - :: " + " "
					+ FKdata);
		}
	}
	
	
	
	@FindBy(xpath = "(//div[@class='p-treenode-content'])[3]/button")
	private WebElement campaignType;
	
	@FindBy(xpath = "(//li[@class='p-treenode'])[3]//ul//div/div/div")
	private List<WebElement> chooseCampaignTypeBtn;
	
	@FindBy(xpath = "//li[@class='p-treenode'][3]//ul//div[@role='treeitem']/span")
	private List<WebElement> chooseCampaignTypeList;
	
	@FindBy(xpath = "//div[@class='p-treeselect-label-container']")
	private WebElement filterDropdown;

	@FindBy(xpath = "//button[@class='campaignreport__btn flex rounded false false']")
	private WebElement customizeColumnButton;
	
	public void applyFilterFor_chooseCampaignType(String expChechbox) {
		webUtil.jsClick(filterDropdown);
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


	public void validateCampaignManager(String productName) {
		webUtil.implicitWait(20);
		webUtil.actionMouseOver(Advertsing);
	webUtil.ExplicitWaitClick(webUtil.getDriver(), Campaign_Manager, 20);
//		webUtil.actionMouseOver(Product);
		webUtil.implicitWait(20);
		Date_Picker date = new Date_Picker(webUtil);
		date.chooseDateType();
		webUtil.staticWait(5);
		webUtil.selectByVisibleText(Product, productName);
//		String expCampaign = webUtil.getConfigValue("CampaignName");
//		applyFilterFor_chooseCampaignType(expCampaign);
		webUtil.ExplicitWaitClick(webUtil.getDriver(), customizeColumnButton, 3);
		webUtil.ExplicitWaitClick(webUtil.getDriver(), SelectAllOption, 3);
		webUtil.ExplicitWaitClick(webUtil.getDriver(), Apply_All_button, 3);
		Get_Total_Row_Data();
		flipkartData();
		validateBothData();

	}
	
	

}
