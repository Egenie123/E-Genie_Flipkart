package com.agl.e_genie.testcase;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.Test;

import com.agl.e_gine.search_term.pages.Search_Term;

public class Search_Term_Testcase extends BaseTestCase{

	@Test
	public void apply_Search_Term_Filter() throws IOException {
		Search_Term searchTrm=	new Search_Term(webUtil, dataMapList, excel);
		dataMapList = excel.getTestCaseData("src\\test\\resources\\TestCaseData.xlsx", "apply_Search_Term_Filter");

		for (int k = 0; k <= dataMapList.size() - 1; k++) {
			Map<String, String> dataMap = dataMapList.get(k);
			String expCheckBoxName=	dataMap.get("Exp_CheckBoxName");
			searchTrm.apply_fliter_Search_Term(expCheckBoxName);

		}

	}


}
