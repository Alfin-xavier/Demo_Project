package com.atmecs.demo_project.pagehelper;

import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;

public class ReadFromFile 
{
	
	JSONParser parser = new JSONParser();
		@Test
		public void readData() throws Exception
		{
			Object obj= parser.parse(new FileReader("./src/main/resources/datas/emp.json"));
			
			JSONObject jsonOjb = (JSONObject) obj;
			
			JSONArray employees = (JSONArray) jsonOjb.get("Employees");

			for(int i=0;i<employees.size();i++)
			{
				JSONObject emp = (JSONObject) employees.get(i);
				
				String name =(String) emp.get("emp_name");
				String mail = (String) emp.get("e_mail");
				String mobile = (String) emp.get("phone");
				String department = (String) emp.get("department");
				
				System.out.println("Details of the employee "+i);
				System.out.println("------- -- --- -------- - \n");
				System.out.println("Name of the employee : "+name);
				System.out.println("Mail_id of the employee : "+mail);
				System.out.println("Mobile Number of the employee : "+mobile);
				System.out.println("Department of the employee : "+department+"\n\n");
			}
		}
		
}
