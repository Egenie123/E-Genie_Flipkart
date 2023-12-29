package com.agl.e_genie.utility;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

	  XSSFWorkbook wb ;
	    XSSFSheet sheet;
	    
	    public ReadExcelFile(String excelPath) {
	        try {
	            File src = new File(excelPath);
	            FileInputStream fis = new FileInputStream(src);
	            wb = new XSSFWorkbook(fis);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    
	    public String getData(int sheetNumber, int row, String columnName)
	    {
	    	int columnNumber =getColumnNumber(sheetNumber, columnName);
	        sheet = wb.getSheetAt(sheetNumber);
	        Cell cell=   sheet.getRow(row).getCell(columnNumber,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
	           String data =	cell.getStringCellValue();
	           return data;
	    }
	    
	    public int getRowCount(int sheetIndex)
	    {
	        int row = wb.getSheetAt(sheetIndex).getLastRowNum();
	        row = row+1;
	        return row;
	    }

		public   int getColumnNumber (int sheetIndex ,String colomnName){
			Row rowObj =wb.getSheetAt(sheetIndex).getRow(0);
			int columnNumber=-1;
			//		It method give last number of cell where is our data ending
			int  currentCellNumber= rowObj.getLastCellNum();
			for (int j = 0; j <=currentCellNumber-1; j++) {
				Cell cellObj =rowObj.getCell(j);
				String columnData=cellObj.getStringCellValue();
				if (columnData.equalsIgnoreCase(colomnName)) {
					columnNumber=j;
				}
			}
			return columnNumber;
		}
	
	
}
