import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

public class ExcelPractice_Data {

	public static void main(String args[]) throws IOException
    {
		String home = System.getProperty("user.home");
		File file = new File(home+"/Downloads/"); 
		String wo =""+file;
		
		System.out.println(file); 
		
		
	      boolean flag = false;
	        //paste your directory path below
	        //eg: C:\\Users\\username\\Downloads
	        String dirPath = ""; 
	        File dir = new File(wo);
	        File[] files = dir.listFiles();
	       int number = files.length;
	      int num= number+1;
	       for(int i=0;i<=files.length;i++) {
	    	  File f = files[number-1];
	    	 System.out.println(f);
	    	 
	       }
	       
		
		
    }	
	
	public static Set<String> listFilesUsingJavaIO(String dir) {
	    return Stream.of(new File(dir).listFiles())
	      .filter(file -> !file.isDirectory())
	      .map(File::getName)
	      .collect(Collectors.toSet());
	}
	
	
	
	public void convertCSVToExcel() throws IOException {
		 ArrayList arList=null;
	        ArrayList al=null;
	        String fName = "C:\\Users\\AGL\\Downloads\\.csv";
	        String thisLine;
	        int count=0;
	        FileInputStream fis = new FileInputStream(fName);
	        DataInputStream myInput = new DataInputStream(fis);
	        int i=0;
	        arList = new ArrayList();
	        while ((thisLine = myInput.readLine()) != null)
	        {
	            al = new ArrayList();
	            String strar[] = thisLine.split(",");
	            for(int j=0;j<strar.length;j++)
	            {
	                al.add(strar[j]);
	            }
	            arList.add(al);
	            System.out.println();
	            i++;
	        }

	        try
	        {
	            HSSFWorkbook hwb = new HSSFWorkbook();
	            HSSFSheet sheet = hwb.createSheet("new sheet");
	            for(int k=0;k<arList.size();k++)
	            {
	                ArrayList ardata = (ArrayList)arList.get(k);
	                HSSFRow row = sheet.createRow((short) 0+k);
	                for(int p=0;p<ardata.size();p++)
	                {
	                    HSSFCell cell = row.createCell((short) p);
	                    String data = ardata.get(p).toString();
	                    if(data.startsWith("=")){
	                        cell.setCellType(CellType.STRING);
	                        data=data.replaceAll("\"", "");
	                        data=data.replaceAll("=", "");
	                        cell.setCellValue(data);
	                    }else if(data.startsWith("\"")){
	                        data=data.replaceAll("\"", "");
	                        cell.setCellType(CellType.STRING);
	                        cell.setCellValue(data);
	                    }else{
	                        data=data.replaceAll("\"", "");
	                        cell.setCellType(CellType.NUMERIC);
	                        cell.setCellValue(data);
	                    }
	                   
	                    // cell.setCellValue(ardata.get(p).toString());
	                }
	                System.out.println();
	            }
	            FileOutputStream fileOut = new FileOutputStream("test.xls");
	            hwb.write(fileOut);
	            fileOut.close();
	            System.out.println("Your excel file has been generated");
	        } catch ( Exception ex ) {
	            ex.printStackTrace();
	        } //main method ends
	    
	}
	
	
	
	
	
//	public static String ConvertCSVToXLS(String file) throws IOException {
//
//        if (file.indexOf(".csv") < 0)
//            return "Error converting file: .csv file not given.";
//        
//
//        String name = FileManager.getFileNameFromPath(file, false);
//        ArrayList<ArrayList<String>> arList = new ArrayList<ArrayList<String>>();
//        ArrayList<String> al = null;
//
//        String thisLine;
//        DataInputStream myInput = new DataInputStream(new FileInputStream(file));
//
//        while ((thisLine = myInput.readLine()) != null) {
//            al = new ArrayList<String>();
//            String strar[] = thisLine.split(",");
//
//            for (int j = 0; j < strar.length; j++) {
//                // My Attempt (BELOW)
//                String edit = strar[j].replace('\n', ' ');
//                al.add(edit);
//            }
//
//            arList.add(al);
//            System.out.println();
//        }
//
//        try {
//            HSSFWorkbook hwb = new HSSFWorkbook();
//            HSSFSheet sheet = hwb.createSheet("new sheet");
//
//            for (int k = 0; k < arList.size(); k++) {
//                ArrayList<String> ardata = (ArrayList<String>) arList.get(k);
//                HSSFRow row = sheet.createRow((short) 0 + k);
//
//                for (int p = 0; p < ardata.size(); p++) {
//                    System.out.print(ardata.get(p));
//                    HSSFCell cell = row.createCell((short) p);
//                    cell.setCellValue(ardata.get(p).toString());
//                }
//            }
//
//            FileOutputStream fileOut = new FileOutputStream(
//                    FileManager.getCleanPath() + "/converted files/" + name
//                            + ".xls");
//            hwb.write(fileOut);
//            fileOut.close();
//
//            System.out.println(name + ".xls has been generated");
//        } catch (Exception ex) {
//        }
//
//        return "";
//    }
//	
	
	
	
//	public void str() {
//		// Set Aspose.Cells library license for remove trial version watermark after converting CSV to Excel
//        License licenseToConvertCSV = new License();
//        licenseToConvertCSV.setLicense("Aspose.Cells.lic");
//
//        // Create the LoadOptions object for loading the source comma-separated value file
//        LoadOptions loadOptions = new LoadOptions(LoadFormat.CSV);
//
//        // Initialize a Workbook class instance with CSV file path and the loadOptions object
//        Workbook workbook = new Workbook("InputCSVFile.csv", loadOptions);
//
//        // Save output Excel file in XLSX format
//        workbook.save("OutputCSVtoExcel.xlsx", SaveFormat.XLSX);
//	}
	
	
	
	
	
//	String home = System.getProperty("user.home");
//	File file = new File(home+"/Downloads/" + fileName + ".txt"); 
	
	
	
	
	
}
