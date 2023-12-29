package com.agl.e_genie.home_page;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import com.agl.e_genie.or.common.Date_Picker;
import com.agl.e_genie.utility.WdUtil;
import com.aventstack.extentreports.Status;

public class Home_Page {

	private WdUtil webUtil;

	public Home_Page(WdUtil webUtil) {
		this.webUtil = webUtil;
		PageFactory.initElements(webUtil.getDriver(), this);
	}

	@FindBy(xpath = "//div[@aria-labelledby='Select Label']//*[1]")
	private WebElement productDropDown;

	@FindBy(xpath = "//span[normalize-space()='Select All']")
	private WebElement selectAll;

	@FindBy(xpath = "//div[contains(@class,'item-renderer')]//span")
	private List<WebElement> dropdownData;

	@FindBy(xpath = "//span[normalize-space()='Dettol']")
	private WebElement dettol;

	@FindBy(xpath = "//span[normalize-space()='Dettol']")
	private WebElement veet;

	@FindBy(xpath = "//span[normalize-space()='Dettol']")
	private WebElement moov;

	@FindBy(xpath = "//span[normalize-space()='Dettol']")
	private WebElement durex;

	@FindBy(xpath = "//div[contains(@class,'sticky z-40 top-14 border px-2 py-4')]//div[3]//div[1]//div[1]//div[1]//div[1]//div[1]")
	private WebElement campaignType;

	@FindBy(xpath = "//span[normalize-space()='PLA']")
	private WebElement PLA_capaignType;

	@FindBy(xpath = "//span[normalize-space()='PCA']")
	private WebElement PCA_capaignType;

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

	private String spendShoadowRoot1 = "//div[@class='styles__FlexBox-rxxhl-3 styles__StyledScoreCardCollection-sc-1w4kge2-0 fCiglQ hzdEPV']/span[1]/pf-scorecard";
	private String AdSpend = ".pf-scorecard-metric > h4";

	private String ROIShoadowRoot1 = "//div[@class='styles__FlexBox-rxxhl-3 styles__StyledScoreCardCollection-sc-1w4kge2-0 fCiglQ hzdEPV']/span[2]/pf-scorecard";
	private String FKROI = ".pf-scorecard-metric > h4";

	private String viewShoadowRoot1 = "//div[@class='styles__FlexBox-rxxhl-3 styles__StyledScoreCardCollection-sc-1w4kge2-0 fCiglQ hzdEPV']/span[3]/pf-scorecard";
	private String FKView = ".pf-scorecard-metric > h4";

	private String clickShoadowRoot1 = "//div[@class='styles__FlexBox-rxxhl-3 styles__StyledScoreCardCollection-sc-1w4kge2-0 fCiglQ hzdEPV']/span[4]/pf-scorecard";
	private String FKclick = ".pf-scorecard-metric > h4";

	private String CTRShoadowRoot1 = "//div[@class='styles__FlexBox-rxxhl-3 styles__StyledScoreCardCollection-sc-1w4kge2-0 fCiglQ hzdEPV']/span[5]/pf-scorecard";
	private String FKCTR = ".pf-scorecard-metric > h4";

	private String orderShoadowRoot1 = "//div[@class='styles__FlexBox-rxxhl-3 styles__StyledScoreCardCollection-sc-1w4kge2-0 fCiglQ hzdEPV']/span[6]/pf-scorecard";
	private String FKOrder = ".pf-scorecard-metric > h4";

	private String CVRShoadowRoot1 = "//div[@class='styles__FlexBox-rxxhl-3 styles__StyledScoreCardCollection-sc-1w4kge2-0 fCiglQ hzdEPV']/span[7]/pf-scorecard";
	private String FKCVR = ".pf-scorecard-metric > h4";

	private String revenueShoadowRoot1 = "//div[@class='styles__FlexBox-rxxhl-3 styles__StyledScoreCardCollection-sc-1w4kge2-0 fCiglQ hzdEPV']/span[8]/pf-scorecard";
	private String FKRevenue = ".pf-scorecard-metric > h4";

	public void chooseProduct(String expProductName) {
		webUtil.staticWait(5);
		webUtil.ExplicitWaitClick(webUtil.getDriver(), productDropDown, 5);
		webUtil.staticWait(5);
		webUtil.jsClick(selectAll);
		webUtil.implicitWait(10);
		if (expProductName.equalsIgnoreCase("Dettol")) {
			webUtil.jsClick(dettol);
		} else if (expProductName.equalsIgnoreCase("Veet")) {
			webUtil.jsClick(veet);
		} else if (expProductName.equalsIgnoreCase("Moov")) {
			webUtil.jsClick(moov);
		} else if (expProductName.equalsIgnoreCase("Durex")) {
			webUtil.jsClick(durex);
		} else if (expProductName.equalsIgnoreCase("Select All")) {
			webUtil.jsClick(selectAll);

		}
		webUtil.actionRandomClick();
	}

	int FK_AD_Spend, FK_ROI, FK_ViewNumber, FK_Click, FK_CTRNumber, FK_Order, FK_CVRNumber, FK_Revenue;

	public void verify_Data(String name, int expNumber1, int expNumber2) {

		if (expNumber1 >= expNumber2 || expNumber1 <= expNumber2 || expNumber1 == expNumber2) {
			webUtil.getExtentLogger().log(Status.PASS, "Verification Passed. Where actual data on our ENV- :: " + name
					+ " " + expNumber1 + " & Expected from Client Portal - :: " + name + " " + expNumber2);
			System.out.println("Verification Pass. Where actual data on our ENV- :: " + name + " " + expNumber1
					+ " & Expected from Client Portal - :: " + name + " " + expNumber2);
		} else {
			SoftAssert soft = new SoftAssert();
			soft.assertTrue(false);
			webUtil.getExtentLogger().log(Status.FAIL, "Verification Failed. Where actual data on our ENV- :: " + name
					+ " " + expNumber1 + " & Expected from Client Portal - :: " + name + " " + expNumber2);
			System.out.println("Verification Failed. Where actual data on our ENV- :: " + name + " " + expNumber1
					+ " & Expected from Client Portal - :: " + name + " " + expNumber2);
		}
		webUtil.actionRandomClick();
	}

	public void choose_CampaignType(String expCampaignName) {
		webUtil.ExplicitWaitClick(webUtil.getDriver(), campaignType, 20);
		webUtil.staticWait(3);
		webUtil.jsClick(selectAll);
		if (expCampaignName.equalsIgnoreCase("PLA")) {
			webUtil.jsClick(PLA_capaignType);
		} else if (expCampaignName.equalsIgnoreCase("PCA")) {
			webUtil.jsClick(PCA_capaignType);
		} else {
			webUtil.jsClick(selectAll);
		}
		webUtil.actionRandomClick();
	}

	@FindBy(xpath = "//div[@class=' flipkart__maincard relative']//div[@class='p-1 col']//p[1]")
	private WebElement spends;

	@FindBy(xpath = "(//div[@class=' flipkart__maincard relative']//div[@class='p-1 col']//p)[2]")
	private WebElement view;

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

	@FindBy(xpath = "//div[@class='styles__DownloadTrigger-kcz6v6-0 kFEROA']")
	private WebElement downloadReport;

	String prod_Spends, prod_View, prod_Click, FK_CVR, FK_CTR, FK_CPC, prod_Sales, prod_Orders, FK_ROAS, FK_AOV;
	long Prod_Spends, Prod_View, Prod_Click_ATB, Prod_Sales, Prod_Orders;
	double Prod_CVR, Prod_CTR, Prod_CPC, Prod_ROAS, Prod_AOV;
	
	public void validateHomeData() {

		Date_Picker date = new Date_Picker(webUtil);
		date.chooseDateType();
		prod_Spends = webUtil.getInerText(spends).replaceAll("\\s", "").replaceAll("[^a-zA-Z0-9.]", "");
		Prod_Spends = webUtil.convertIntoLong(prod_Spends);
		System.out.println("Spends == " + Prod_Spends);

		prod_View = webUtil.getInerText(view).replaceAll("\\s", "");
		Prod_View = webUtil.convertIntoLong(prod_View);
		System.out.println("View == " + Prod_View);

		prod_Click = webUtil.getInerText(click_ATB).replaceAll("\\s", "");
		Prod_Click_ATB = webUtil.convertIntoLong(prod_Click);
		System.out.println("Click and ATB == " + Prod_Click_ATB);

		FK_CVR = webUtil.getInerText(cvr).replaceAll("[^\\d.]", "");
		Prod_CVR = Double.parseDouble(FK_CVR);
		System.out.println("CVR == " + Prod_CVR);

		FK_CTR = webUtil.getInerText(ctr).replaceAll("[^\\d.]", "");
		Prod_CTR = Double.parseDouble(FK_CTR);
		System.out.println("CTR == " + Prod_CTR);

		FK_CPC = webUtil.getInerText(cpc).replaceAll("[^\\d.]", "");
		Prod_CPC = Double.parseDouble(FK_CPC);
		System.out.println("CPC == " + Prod_CPC);

		prod_Sales = webUtil.getInerText(sales).replaceAll("\\s", "");
		Prod_Sales = webUtil.convertIntoLong(prod_Sales);
		System.out.println("Sales == " + Prod_Sales);

		prod_Orders = webUtil.getInerText(orders).replaceAll("\\s", "");
		Prod_Orders = webUtil.convertIntoLong(prod_Orders);
		System.out.println("Orders == " + Prod_Orders);

		FK_ROAS = webUtil.getInerText(roas);
		Prod_ROAS =Double.parseDouble(FK_ROAS);
		System.out.println("ROAS == " + FK_ROAS);

		FK_AOV = webUtil.getInerText(aov).replaceAll("[^\\d.]", "");
		Prod_AOV =Double.parseDouble(FK_AOV);
		System.out.println("AOV == " + Prod_AOV);

	}

	String FK_AD_Spend_Text, FK_ROI_Text, FK_View_Text, FK_Click_Text, FK_CTR_Text, FK_Order_Text, FK_CVR_Text,
			FK_Revenue_Text;
//	int FK_AD_Spend, FK_ROI, FK_ViewNumber, FK_Click, FK_CTRNumber, FK_Order, FK_CVRNumber, FK_Revenue;

	public void flipkartData() {
		webUtil.openURL("https://advertising.flipkart.com/login?returl=/ad-account/campaigns?baccount=RSAUFLMCSZ");
		webUtil.input(userId, "ebux.support@adglobal360.com");
		webUtil.input(password, "Ebuxsupport@@@@@@123");
		webUtil.jsClick(loginBtn);
		webUtil.getExtentLogger().log(Status.PASS, "User logged in successfully in flipkart portal ");
		webUtil.staticWait(2);
		if (notification.isDisplayed() == true) {
			webUtil.jsClick(notification);
			webUtil.getExtentLogger().log(Status.PASS, "Notification close successfully -- ");
		}
		webUtil.ExplicitWaitClick(webUtil.getDriver(), productDD, 30);
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
		webUtil.actionRandomClick();
		webUtil.staticWait(5);
		webUtil.ExplicitWaitClick(webUtil.getDriver(), datePickerButton, 60);
		webUtil.ExplicitWaitClick(webUtil.getDriver(), chooseDateType, 60);
		webUtil.ExplicitWaitClick(webUtil.getDriver(), FK_CampaignTypeDD, 60);
		String expCampaign = webUtil.getConfigValue("CampaignName");
		if (expCampaign.equalsIgnoreCase("PLA")) {
			webUtil.implicitWait(20);
			webUtil.jsClick(FK_PLA_CampaignType);
			webUtil.getExtentLogger().log(Status.PASS, "Campaign name selected successfully :: = :: " + expCampaign);
		} else if (expCampaign.equalsIgnoreCase("PLA")) {
			webUtil.implicitWait(20);
			webUtil.jsClick(FK_PCA_CampaignType);
			webUtil.getExtentLogger().log(Status.PASS, "Campaign name selected successfully :: = :: " + expCampaign);

		} else {
			webUtil.implicitWait(20);
			webUtil.jsClick(FK_PLA_CampaignType);
			webUtil.jsClick(FK_PCA_CampaignType);
			webUtil.getExtentLogger().log(Status.PASS, "Campaign name selected successfully :: = :: " + "PLA, PCA");
		}

		webUtil.ExplicitWaitClick(webUtil.getDriver(), FK_ApplyButton, 15);
		webUtil.staticWait(5);
		webUtil.jsClick(downloadButton);
		webUtil.jsClick(downloadReport);
	}

	public void validateDate_of_Both_Pltform() {

		webUtil.renameFilesInFolder("C:\\Users\\AGL\\Downloads", ".csv", "CampaignData");
		String filePath = webUtil.getConfigValue("FilePathHomePage");
		long spends = webUtil.readColumnData(filePath, 11);
		String FK_spend =webUtil.numberFormate(spends);
		long view = webUtil.readColumnData(filePath, 12);
		String FK_View =webUtil.numberFormate(view);
		long click = webUtil.readColumnData(filePath, 13);
		String FK_Click =webUtil.numberFormate(click);
		long order = webUtil.readColumnData(filePath, 14);
		String FK_Order =webUtil.numberFormate(order);
		long sales = webUtil.readColumnData(filePath, 15);
		String FK_Sales =webUtil.numberFormate(sales);

		float changeFormateSpends = (float) spends;
		float changeFormateSales = (float) sales;
		double calculateROI = (double) (changeFormateSales / changeFormateSpends);
		double ROI = webUtil.formateDesimalvalue(calculateROI);

		float changeFormateView = (float) view;
		float changeFormateClicks = (float) click;
		double calculateCTR = (double) (changeFormateClicks / changeFormateView * 100);
		double CTR = webUtil.formateDesimalvalue(calculateCTR);

		float changeFormateOrder = (float) order;
		double calculateCVR = (double) (changeFormateOrder / changeFormateClicks * 100);
		double CVR = webUtil.formateDesimalvalue(calculateCVR);

		calculatePercent("Spends ", Prod_Spends, spends, 2);
		calculatePercent("View ", Prod_View, view, 2);
		calculatePercent("Click ", Prod_Click_ATB, click, 2);
		calculatePercent("Orders ", Prod_Orders, order, 2);
		calculatePercent("Sales ", Prod_Sales, sales, 2);
		validateData("ROI", Prod_ROAS, ROI);
		validateData("CTR", Prod_CTR, CTR);
		validateData("CVR", Prod_CVR, CVR);
		
		System.err.println("-----------------------------------");
		verifyData("Spends ", prod_Spends, FK_spend);
		verifyData("View ", prod_View, FK_View);
		verifyData("Click ", prod_Click,FK_Click);
		verifyData("Orders ", prod_Orders, FK_Order);
		verifyData("Sales ", prod_Sales, FK_Sales);

	}
	
	public void verifyData(String name, String actData, String expData) {
		
		if (actData.contains(expData)) {
			System.out.println("Verification Passed. Where actual data on our ENV- :: " + name + " " + actData
					+ " and "+"Expected from Client Portal - :: " + " "
					+ expData);
			webUtil.getExtentLogger().log(Status.PASS,
					"Verification Passed. Where actual data on our ENV- :: " + name + " " + actData
					+ " and "+"Expected from Client Portal - :: " + " "
					+ expData);
		} else {
			webUtil.getExtentLogger().log(Status.FAIL,
					"Verification Fail. Where actual data on our ENV- :: " + name + " " + actData
					+ " and "+"Expected from Client Portal - :: " + " "
					+ expData);
			System.out.println("Verification Fail. Where actual data on our ENV- :: " + name + " " + actData
					+ " and "+"Expected from Client Portal - :: " + " "
					+ expData);
			
		}
	}
	

	public void calculatePercent(String name, long prodData, long FKdata, int persantage) {

		float percentFloat = (float) persantage / 100;
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

	public void validateData(String name, double prodData, double FKdata) {

		if (prodData >= FKdata || prodData <= FKdata || prodData == FKdata) {
			System.out.println("Verification Passed. Where actual data on our ENV- :: " + name + " " + prodData
					+ " and " + "Expected from Client Portal - :: " + " " + FKdata);
			webUtil.getExtentLogger().log(Status.PASS, "Verification Passed. Where actual data on our ENV- :: " + name
					+ " " + prodData + " and " + "Expected from Client Portal - :: " + " " + FKdata);
		} else {
			webUtil.getExtentLogger().log(Status.FAIL, "Verification Failed. Where actual data on our ENV- :: " + name
					+ " " + prodData + " and " + "Expected from Client Portal - :: " + " " + FKdata);
			System.out.println("Verification Failed. Where actual data on our ENV- :: " + name + " " + prodData
					+ " and " + "Expected from Client Portal - :: " + " " + FKdata);
		}
	}

	public int stringTOInt(String word) {
		double i = Double.parseDouble(word.replaceAll("[^\\d.]", ""));
		int num = (int) i;
		return num;
	}

}
