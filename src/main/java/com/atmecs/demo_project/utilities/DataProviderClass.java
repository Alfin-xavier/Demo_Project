package com.atmecs.demo_project.utilities;

import org.testng.annotations.DataProvider;

public class DataProviderClass 
{
	@DataProvider(name = "filling_details")
	public Object[][] readData()
	{
		Object[][] data = ReadDataFromExcel.readExcelData("Form_filling");
		
		return data;
	}
	
}
