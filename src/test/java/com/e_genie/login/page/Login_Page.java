package com.e_genie.login.page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v113.storage.Storage;
import org.openqa.selenium.html5.SessionStorage;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.agl.e_genie.or.common.Or_Common;
import com.agl.e_genie.utility.WdUtil;


public class Login_Page extends Or_Common {

	private WdUtil webUtil;

	@FindBy(xpath = "//input[@placeholder='Email']")
	private WebElement userName;

	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement password;

	@FindBy(xpath = "//button[text()='Login']")
	private WebElement loginBtn;
	
	@FindBy(xpath = "//select[@class='header__dropdown']")
	private WebElement platformName;

	public Login_Page(WdUtil webUtil) {
		super(webUtil);
		this.webUtil = webUtil;
		PageFactory.initElements(webUtil.getDriver(), this);
	}

	public void validLogin() {

		String url = webUtil.getConfigValue("Url");
		webUtil.openURL(url);
		 webUtil.clearChache();
		 webUtil.staticWait(5);
		String username = webUtil.getConfigValue("UserName");
		webUtil.ExplicitWaitClick(webUtil.getDriver(), userName, 10);
		webUtil.staticWait(1);
		webUtil.input(userName, username);
		String pass = webUtil.getConfigValue("Password");
		webUtil.ExplicitWaitClick(webUtil.getDriver(), userName, 10);
		webUtil.input(password, pass);
		webUtil.implicitWait(10);
		webUtil.jsClick(loginBtn);
		 webUtil.staticWait(5);
		String pltformName =webUtil.getConfigValue("PlatformName");
		webUtil.selectByVisibleText(platformName,pltformName);
		webUtil.refreshWindow();
		webUtil.staticWait(3);

	}

}
