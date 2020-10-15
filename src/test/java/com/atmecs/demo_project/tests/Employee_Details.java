package com.atmecs.demo_project.tests;

import org.testng.annotations.Test;
import com.atmecs.demo_project.pagehelper.ReadFromFile;
import com.atmecs.demo_project.pagehelper.WriteFromFile;

public class Employee_Details 
{
	@Test
	public void empDetails() throws Exception
	{
		ReadFromFile readFile = new ReadFromFile();
		WriteFromFile writeFile = new WriteFromFile();
		
		//System.out.println("");
		writeFile.writeData();
		readFile.readData();
		 
	}
}
