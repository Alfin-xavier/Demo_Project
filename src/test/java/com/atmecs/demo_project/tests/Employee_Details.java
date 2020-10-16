package com.atmecs.demo_project.tests;

import org.testng.annotations.Test;
import com.atmecs.demo_project.pagehelper.JsonFileOperations;

public class Employee_Details 
{
	@Test
	public void empDetails() throws Exception
	{
		JsonFileOperations opertaion = new JsonFileOperations();
		
		opertaion.writeData();
		
		opertaion.readData();
		
	}
}
