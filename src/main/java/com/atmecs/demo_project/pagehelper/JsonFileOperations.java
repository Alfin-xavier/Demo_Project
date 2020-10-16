package com.atmecs.demo_project.pagehelper;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonFileOperations 
{
	public JSONObject response;
	public JSONObject emp;
	JSONParser parser = new JSONParser();
	@SuppressWarnings("unchecked")
	public JSONObject  getEmp(String emp_name, String e_mail, String phone, String department)
	{
		emp = new JSONObject();
		emp .put("Name", emp_name);
		emp .put("Mail", e_mail);
		emp .put("Mobile", phone);
		emp .put("Department", department);
		return emp;
	}

	@SuppressWarnings("unchecked")
	public JSONObject writeData()
	{

	JSONArray employees = new JSONArray();
	employees.add(getEmp("Abc","abc@gmail.com","8473829834","n/w"));
	employees.add(getEmp("def","def@gmail.com","8473829834","n/w"));
	employees.add(getEmp("Ghj","ghj@gmail.com","8473829834","s/w"));
	employees.add(getEmp("Jnb","jnb@gmail.com","8473829834","n/w"));
	employees.add(getEmp("Lmn","lmn@gmail.com","8473829834","s/w"));
	employees.add(getEmp("Fsd","fsd@gmail.com","8473829834","n/w"));
	
	response = new JSONObject();
	response.put("Employees", employees );

	try 
	{
		FileWriter file = new FileWriter("./src/main/resources/datas/emp.json");
		file.write(response.toJSONString());
		file.close();
	} 
	catch (IOException e) 
	{
		e.printStackTrace();
	}
		return response;
	}
	
	public void readData() throws Exception
	{
		Object obj= parser.parse(new FileReader("./src/main/resources/datas/emp.json"));
		
		JSONObject jsonOjb = (JSONObject) obj;
		
		JSONArray employees = (JSONArray) jsonOjb.get("Employees");

		for(int i=0;i<employees.size();i++)
		{
			JSONObject emp = (JSONObject) employees.get(i);
			
			String name =(String) emp.get("Name");
			String mail = (String) emp.get("Mail");
			String mobile = (String) emp.get("Mobile");
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
