package com.agl.e_genie.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WdUtil {
	
	private WebDriver driver;
	private Properties propObj;
	private ExtentReports reports;
	private ExtentTest test;

	public WdUtil() {
		try {
			InputStream fs = new FileInputStream("config.properties");
			propObj = new Properties();
			propObj.load(fs);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//	 Extents Reports 

	public void initHtmlReport() {
		SimpleDateFormat SimpledateFormate = new SimpleDateFormat("dd-MM-yyyy-HHmmss");
		Date date = new Date();
		String day = SimpledateFormate.format(date);
		ExtentSparkReporter htmlReport = new ExtentSparkReporter("Report/" + " Extent Report " + day + ".html");
		htmlReport.config().setDocumentTitle("Automation Extends Report");
		htmlReport.config().setReportName("Automation Report");
		htmlReport.config().setTheme(Theme.STANDARD);
		reports = new ExtentReports();
		reports.attachReporter(htmlReport);

	}

	public void ExplicitWaitClick(WebDriver driver, WebElement locator, int timeout) {
		new WebDriverWait(driver, Duration.ofSeconds(timeout)).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}

	public void setExtentLogger(String tcName) {
		test = reports.createTest(tcName);
	}

	public ExtentTest getExtentLogger() {
		return test;
	}

	public void flushReport() {
		reports.flush();
	}

	public void clearChache() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.localStorage.clear();");
	}
	
	public WebDriver launchBrowser(String Browser) {
		if (Browser.equalsIgnoreCase("Chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
		} else if (Browser.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		} else if (Browser.equalsIgnoreCase("InternetExplorer")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
		} else
			System.out.println(Browser + " Browser name is wrong . Please chacke it - ");
		return driver;
	}

	public void openURL(String url) {
		driver.get(url);
	}

	public WebDriver getDriver() {
		return driver;

	}

	public Properties getPropObj() {
		return propObj;
	}

	public String getScreenShot(String tcName) {
		TakesScreenshot tss = (TakesScreenshot) driver;
		File to = tss.getScreenshotAs(OutputType.FILE);
		File from = new File("ScreenShot/" + tcName + getCurrentTime() + ".png");
		try {
			Files.copy(to, from);
		} catch (IOException e) {

		}
		return null;
	}

	public String getCurrentTime() {
		SimpleDateFormat smpDatTime = new SimpleDateFormat("yyyy_mm_dd_hh_mm_ss");
		Date dtObj = new Date();
		String date = smpDatTime.format(dtObj);
		return date;
	}

//	 Config properties
	public String getConfigValue(String keyName) {
		String value = propObj.getProperty(keyName);
		return value;
	}

	///////////// Windows ////////////////

	public void maximizeWindow() {
		driver.manage().window().maximize();
		System.out.println("Windows Maximize successefully : ");
	}

	public void refreshWindow() {
		driver.navigate().refresh();
		System.out.println("Page Refresh successefully : ");
	}

	public void close() {
		driver.close();
		driver.quit();
		System.out.println("Current Windows clossed succesefully :");
	}

	public void quit() {
		driver.quit();
		System.out.println("Current Windows quit succesefully :");

	}

	/////////////// Shadow Element //////////////////

	public String getShadowText(String root1, String root2) {
		WebElement shadowHost = driver.findElement(By.xpath(root1));
		SearchContext shadowRoot = shadowHost.getShadowRoot();
		String text = shadowRoot.findElement(By.cssSelector(root2)).getText();
		return text;
	}

//	Convert String in to number ///

	public long convertInTO_Int(String text) {
		long i = Long.parseLong(text);
		return i;
	}

	public double convertInTO_Double(String text) {
		double d = Double.parseDouble(text);
		return d;
	}

	/////////////// Random Number or Random Option ///////////

	public static int selectRandomNumber(int minNum, int maxNum) {
		int randNum = (int) (Math.random() * (maxNum - minNum + 1) + minNum);
		System.out.println(randNum);
		return randNum;

	}

	public static List<WebElement> selectRandomOption(WebElement weVariable) {
		Select sct = new Select(weVariable);
		List<WebElement> opt = sct.getOptions();
		opt.size();
		return opt;
	}

	////////////////// WebElement ////////////////////////

	public void click(WebElement we) {
		if (we.isDisplayed() & we.getSize().getHeight() == 0 & we.getSize().getWidth() == 0) {
			if (we.isEnabled()) {
				we.click();
				System.out.println(" Element is clicked by WebElement ");
			} else
				System.out.println(" Element is not Visible");
		} else
			System.out.println(" Element is not clicked ");
	}

	public void input(WebElement we, String inputvalue) {
		we.clear();
		if (we.isEnabled()) {
			if (we.isDisplayed() & we.getSize().getHeight() > 0 & we.getSize().getWidth() > 0) {
				we.sendKeys(inputvalue);
				System.out.println("value input successfully by WebElement ");
			} else
				System.out.println("Element is not Displayed ");
		} else
			System.out.println("Element is not input ");
	}

	public String getInerText(WebElement we) {
		String text =  we.getText();
	
		return text;
	}

	public String getAtrbtText(WebElement we, String attributeName) {
		String attributeValue = null;
		if (we.isDisplayed() & we.getSize().getHeight() > 0 & we.getSize().getWidth() > 0) {
			if (we.isEnabled()) {
				attributeValue = we.getAttribute(attributeName);
				System.out.println("InerText of Element : " + attributeValue);
			} else
				System.out.println("Element is not Enable");
		} else
			System.out.println("Element is not displayed");
		return attributeValue;
	}

	public String getTagName(WebElement we, String elementname) {
		String tgn = null;
		if (we.isDisplayed() & we.getSize().getHeight() > 0 & we.getSize().getWidth() > 0) {
			if (we.isEnabled()) {
				tgn = we.getTagName();
				System.out.println("TagName of " + elementname + " : " + tgn);
			} else
				System.out.println("Element is not Enable");
		} else
			System.out.println("Element of tagname is not Displayed ");
		return tgn;
	}

	///////////////////// DropDown ////////////////////

	public void selectByVisibleText(WebElement we, String Text) {
		Select se = new Select(we);

		if (we.isDisplayed()) {
			if (we.isDisplayed() & we.getSize().getHeight() > 0 & we.getSize().getWidth() > 0) {
				se.selectByVisibleText(Text);
				System.out.println(Text + " is selected by visibleText ");
			} else
				System.out.println("DropDown Element is not enable : ");
		} else {
			System.out.println("DropDown Element is not Displayed : ");
		}
	}

	public void selectByIndex(WebElement we, int Number) {
		Select se = new Select(we);
		if (we.isDisplayed() & we.getSize().getHeight() > 0 & we.getSize().getWidth() > 0) {
			if (we.isEnabled()) {
				se.selectByIndex(Number);
				System.out.println(Number + "Element is selected by index ");
			} else {
				System.out.println("DropDown Element is not enable : ");
			}
		} else {
			System.out.println("DropDown Element is not Displayed : ");
		}
	}

	public void selectByvalue(WebElement we, String value) {
		Select se = new Select(we);
		if (we.isDisplayed() & we.getSize().getHeight() > 0 & we.getSize().getWidth() > 0) {
			if (we.isEnabled()) {
				se.selectByValue(value);
				System.out.println(value + "Element is selected by value ");
			} else {
				System.out.println("DropDown Element is not enable : ");
			}
		} else {
			System.out.println("DropDown Element is not Displayed : ");
		}
	}

	//////////////////// Actions /////////////////

	public void actionMouseOver(WebElement we) {
		Actions act = new Actions(driver);
		if (we.getSize().getHeight() > 0 && we.getSize().getWidth() > 0) {
			if (we.isDisplayed()) {
				if (we.isEnabled()) {
					act.moveToElement(we).build().perform();
					System.out.println("Element is moved by Actions : ");
				}

			} else
				System.out.println("Element is not Enable :");
		} else
			System.out.println("Element is not find on HTML Page");
	}

	public void actionClickAndHoldd(WebElement we) {
		Actions act = new Actions(driver);
		if (we.getSize().getHeight() > 0 && we.getSize().getWidth() > 0) {
			act.clickAndHold(we).build().perform();
			if (we.isDisplayed()) {
				if (we.isEnabled()) {
					act.moveToElement(we).build().perform();
					System.out.println(" Element is clicked and hold by actions");
				} else
					System.out.println(" Element is not Enable :");
			} else
				System.out.println("Element is not Display ");
		} else
			System.out.println("Element is not find on HTML Page");

	}

	public void actionInput(WebElement we, String inputDat) {
		Actions act = new Actions(driver);
		we.clear();
		if (we.getSize().getHeight() > 0 && we.getSize().getWidth() > 0) {
			if (we.isDisplayed()) {
				if (we.isEnabled()) {
					act.sendKeys(we, inputDat).build().perform();
					System.out.println("Value input successfully by action");
				} else
					System.out.println("Element is not Enable :");
			} else
				System.out.println("Element is not display : ");
		} else
			System.out.println("Element is not find on HTML Page");
	}

	
	public void actionRandomClick() {
		Actions act = new Actions(driver);
		act.click().build().perform();
		System.out.println("Random click success");
	}
	
	public void actionClick(WebElement we) {
		Actions act = new Actions(driver);
		if (we.getSize().getHeight() > 0 && we.getSize().getWidth() > 0) {
			if (we.isDisplayed()) {
				if (we.isEnabled()) {
					act.click().build().perform();
					System.out.println("Element is clicked by Actions ");
				} else
					System.out.println("Element is not Enable :");
			} else
				System.out.println("Element is not displayed : ");
		} else
			System.out.println("Element is not find on HTML Page");
	}

	public void actionDoudleClick(WebElement we) {
		Actions act = new Actions(driver);
		if (we.getSize().getHeight() > 0 && we.getSize().getWidth() > 0) {
			if (we.isDisplayed()) {
				if (we.isEnabled()) {
					act.doubleClick(we).build().perform();
					System.out.println("Double click on element is successfully ");
				} else
					System.out.println("Element is not Enable :");
			} else
				System.out.println("Element is not displayed : ");
		} else
			System.out.println("Element is not find on HTML Page");
	}

	public void actionRightClick(WebElement we) {
		Actions act = new Actions(driver);
		if (we.getSize().getHeight() > 0 && we.getSize().getWidth() > 0) {
			if (we.isDisplayed()) {
				if (we.isEnabled()) {
					act.contextClick(we).build().perform();
					System.out.println("Right click on element is successfully");
				} else
					System.out.println("Element is not Enable :");
			} else
				System.out.println("Element is not displayed : ");
		} else
			System.out.println("Element is not find on HTML Page");

	}

	public void actiondragAndDrop(WebElement we1, WebElement ww2) {
		Actions act = new Actions(driver);
		if (we1.getSize().getHeight() > 0 && we1.getSize().getWidth() > 0) {
			if (we1.isDisplayed()) {
				if (we1.isEnabled()) {
					act.dragAndDrop(we1, ww2).build().perform();
					System.out.println("Element is drag and drop successfully by drag and drop ");
				} else
					System.out.println("Element is not Enable :");
			} else
				System.out.println("Element is not displayed : ");
		} else
			System.out.println("Element is not find on HTML Page");
	}

	//////////////////////// Javascript /////////////////////////

	public void jsClick(WebElement we) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", we);
		System.out.println("Element is clicked by javascript ");
	}

	public void jsSandkeys(WebElement we, String inputvalue) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		we.clear();
		jse.executeScript("arguments[0].value=" + "'" + inputvalue + "'", we);
		System.out.println("Value is inputed by javascript ");
	}

	public void jsMouseOver(WebElement we) {

		String strJs = "var element = argument[0];" + "var mouseEventObj=document.createEvent('MouseEvents');"
				+ "mouseEventObj.initEvent( 'mouseover', true, true );" + "element.dispatchEvent(mouseEventObj);";
		try {
			String mouseOverScript = "if(document.createEvent){var evObj =document.createEvent('MouseEvents');"
					+ "evObj.initEvent('mouseOver' ,true, false);arguments[0].dispatchEvent(evObj);}"
					+ "else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript(strJs, we);
		} catch (Exception e) {
			System.out.println("javaScript MouseOver is not click ");
		}
	}

	/////////////////////////// Calculation ////////////////

	public double calculatePercentage(double valueA, double valueB) {
		try {
			Float percentage = (float) ((valueA / valueB) * 100);
			return percentage;
		} catch (Exception e) {
			System.out.println("Test case fail due to - is not the integer value");
			return 0;
		}
	}

	public int CalculateSum(int num1, int num2) {
		int ans = num1 + num2;
		return ans;
	}

	public double CalculateDivide(double num1, double num2) {
		double ans = (double) (num1 / num2);
		return ans;
	}

	///////////////////// Page Scroll ////////////////////

	public void scrollPage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, -200);");
	}

	public void scrollIntoViewElement(WebElement we) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", we);
	}

	public void scrollPageTillEnd() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	//////////////////////////// Wait /////////////////////////

	public void implicitWait(int timeInSecound) {

		driver.manage().timeouts().implicitlyWait(timeInSecound, TimeUnit.SECONDS);

	}

	public void staticWait(int timeInSecound) {
		int secound = timeInSecound * 1000;
		try {
			Thread.sleep(secound);
			System.out.println("Static wait is puted ");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void enabledElementwait(WebElement we, int timeInSecound) {
		if (we.equals(we.isEnabled())) {
			WebDriverWait expli = new WebDriverWait(driver, Duration.ofSeconds(timeInSecound));
			expli.until(ExpectedConditions.elementToBeClickable(we));
		} else
			System.out.println("Element is not Enabled");
	}

	public void visibleElementWait(WebElement we, int timeInSecound) {
		WebDriverWait expli = new WebDriverWait(driver, Duration.ofSeconds(timeInSecound));
		if (we.equals(we.isDisplayed())) {
			expli.until(ExpectedConditions.visibilityOfAllElements(we));
		} else {
			System.out.println("Element is not visible");
		}
	}

	public WebElement keys(String keysname, WebElement we) {
		if (keysname.equalsIgnoreCase("F5")) {
			we.sendKeys(Keys.F5);
		} else if (keysname.equalsIgnoreCase("Enter")) {
			we.sendKeys(Keys.ENTER);
		} else if (keysname.equalsIgnoreCase("Arrow Down")) {
			we.sendKeys(Keys.ARROW_DOWN);
		} else if (keysname.equalsIgnoreCase("Arrow Up")) {
			we.sendKeys(Keys.ARROW_UP);
		} else if (keysname.equalsIgnoreCase("Arrow Left")) {
			we.sendKeys(Keys.ARROW_LEFT);
		} else if (keysname.equalsIgnoreCase("Arrow Right")) {
			we.sendKeys(Keys.ARROW_RIGHT);
		}

		return we;

	}

//	Verify the data

	public void verifyInnerTextContains(WebElement we, String exptInnertext) {
		String actualText = getInerText(we);
		if (actualText.contains(exptInnertext)) {
			Reporter.log("Verifycation Passed. Where actual -" + actualText + " & Expected : " + exptInnertext);
			System.out.println("Verifycation Passed. Where actual -" + actualText + " & Expected :" + exptInnertext);
		} else {
//			getScreenShot(actualText);
			System.out.println("Verifycation Failed. Where actual -" + actualText + " & Expected :" + exptInnertext);
			SoftAssert soft = new SoftAssert();
			soft.assertEquals(actualText, exptInnertext);
		}
	}

	public void verify_Data(long expNumber1, long expNumber2) {

		if (expNumber1 <= expNumber2) {
			Reporter.log("Verifycation Passed. Where actual - :: " + expNumber1 + " & Expected - :: " + expNumber2);
			System.out
					.println("Verifycation Passed. Where actual - :: " + expNumber1 + " & Expected - ::" + expNumber2);
		}
		else {
			SoftAssert soft = new SoftAssert();
			soft.assertTrue(false);	
			Reporter.log("Verifycation Failed. Where actual - :: " + expNumber1 + " & Expected - :: " + expNumber2);
			System.out
					.println("Verifycation Failed. Where actual - :: " + expNumber1 + " & Expected - ::" + expNumber2);
		}

	}

	public void verify_Data(double expNumber1, double expNumber2) {

		if (expNumber1 <= expNumber2) {
			Reporter.log("Verifycation Passed. Where actual - :: " + expNumber1 + " & Expected - :: " + expNumber2);
			System.out
					.println("Verifycation Passed. Where actual - :: " + expNumber1 + " & Expected - ::" + expNumber2);
		}
		else {
			SoftAssert soft = new SoftAssert();
			soft.assertTrue(false);	
			Reporter.log("Verifycation Failed. Where actual - :: " + expNumber1 + " & Expected - :: " + expNumber2);
			System.out
					.println("Verifycation Failed. Where actual - :: " + expNumber1 + " & Expected - ::" + expNumber2);
		}

	}
	
	public void verify_Data(String expNumber1, String expNumber2) {
		if (expNumber1.contains(expNumber2)) {
			Reporter.log("Verifycation Passed. Where actual - :: " + expNumber1 + " & Expected - :: " + expNumber2);
			System.out
					.println("Verifycation Passed. Where actual - :: " + expNumber1 + " & Expected - ::" + expNumber2);
		}
		else {
			SoftAssert soft = new SoftAssert();
			soft.assertTrue(false);	
			Reporter.log("Verifycation Failed. Where actual - :: " + expNumber1 + " & Expected - :: " + expNumber2);
			System.out
					.println("Verifycation Failed. Where actual - :: " + expNumber1 + " & Expected - ::" + expNumber2);
		}
	}

	
	public String stringToInt(String word) {
		float i =Float.parseFloat(word.replaceAll("[^\\d.]", ""));
		String s =String.valueOf(i);
		return s;
		
	} 

	public long convertIntoLong(String n) {
		long num=0;
	if(n.contains("M")) {
		String w =n.replaceAll("[^\\d.]", "");
		double d =	Double.parseDouble(w);
		num =(long) (d*1000000);
	}else if(n.contains("k")) {
		String w =n.replaceAll("[^\\d.]", "");
		double d =	Double.parseDouble(w);
		num =(int) (d*1000);
	
	}
	return num;
	}
	
	
	public String formatValue(float value) {
		String arr[] = { "", "K", "M", "B", "T", "P", "E" };
		int index = 0;
		while ((value / 1000) >= 1) {
			value = value / 1000;
			index++;
		}
		DecimalFormat decimalFormat = new DecimalFormat("#.##");
		return String.format("%s %s", decimalFormat.format(value), arr[index]);
	}
	
	public void renameFilesInFolder(String folderPath,String extension,String newName) {
		if (extension == null || extension.equals("")) {
			System.out.println("Extension cannot be null or empty");
			return;
		}
		File dir = new File(folderPath);
		if (dir.isDirectory()) { // make sure it's a directory
			for (final File f : dir.listFiles()) {
				try {
					File newfile = new File(folderPath + "\\" + newName + extension);
					if (f.renameTo(newfile)) {
						System.out.println("Rename succesful: " + newName + extension);
						break;
					} else {
						System.out.println("Rename failed");
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}

	public long readColumnData(String csvFilePath, int columnIndexToSum) {
		long sum = 0;
		try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] columns = line.split(",");
				if (columns.length > columnIndexToSum && columns[columnIndexToSum] != null
						&& !columns[columnIndexToSum].trim().isEmpty()) {
					if (isValidNumericString(columns[columnIndexToSum])) {
						double columnValue = Double.parseDouble(columns[columnIndexToSum]);
						sum += columnValue;
					}
				}
			}
//			System.out.println("Sum of column " + columnIndexToSum + ": " + sum);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sum;
	}

	private boolean isValidNumericString(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	public double formateDesimalvalue(double value){
		 DecimalFormat df = new DecimalFormat("####0.00");
		 String num = df.format(value);
		double d = Double.parseDouble(num);
		return d;
	}
	
	public String numberFormate(long count) {
	    if (count < 1000) return "" + count;
	    int exp = (int) (Math.log(count) / Math.log(1000));
	    return String.format("%.1f%c",
	                         count / Math.pow(1000, exp),
	                         "kMBGTPE".charAt(exp-1));
	}
	

}
