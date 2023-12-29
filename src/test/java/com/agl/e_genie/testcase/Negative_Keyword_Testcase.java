package com.agl.e_genie.testcase;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.Test;

import com.agl.e_genie.negative_keyword.pages.Negative_Keyword;

public class Negative_Keyword_Testcase extends BaseTestCase{


	@Test
	public void apply_Negative_Keyword_Filter() throws IOException {
		Negative_Keyword negativekey = new Negative_Keyword(webUtil,dataMapList,excel);
		dataMapList = excel.getTestCaseData("src\\test\\resources\\TestCaseData.xlsx", "Apply_Negative_Keyword_Filter");
		for (int i = 0; i <= dataMapList.size() - 1; i++) {
			Map<String, String> dataMap = dataMapList.get(i);
		String expNameCheckBox=	dataMap.get("ExpNameCheckBoxText");
		negativekey.applyFilter_Name(expNameCheckBox);

	}
	}
	
	
	
	public void removeNegativeKeyword() throws IOException {
		Negative_Keyword negativekey = new Negative_Keyword(webUtil,dataMapList,excel);
		negativekey.removeNegativeKeywords();
	}
	
	
	
	
}
