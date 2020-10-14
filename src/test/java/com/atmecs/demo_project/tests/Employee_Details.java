package com.atmecs.demo_project.tests;

import java.util.Scanner;

import org.testng.annotations.Test;

import com.atmecs.demo_project.pagehelper.JsonOperations;

public class Employee_Details 
{
	@Test
	public void empDetails() throws Exception
	{
		Scanner scr = new Scanner(System.in);
		JsonOperations jsonOperations = new JsonOperations();
		
		String choice;
		System.out.println("1.Write data   2.Read Data \n");
		System.out.println("Enter your choice: \n");
		choice =  scr.next();
		
		if(choice.equalsIgnoreCase("write data"))
		{
			jsonOperations.writeData();
		}
		
		
		  else 
		  { 
			  jsonOperations.readData(); 
		  }
		 
	}
}
