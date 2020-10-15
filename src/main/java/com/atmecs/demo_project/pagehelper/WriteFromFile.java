package com.atmecs.demo_project.pagehelper;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class WriteFromFile 
{
	public JSONObject response;
	public JSONObject emp;
	@SuppressWarnings("unchecked")
	public JSONObject  getEmp(String emp_name, String e_mail, String phone, String department)
	{
		emp = new JSONObject();
		emp .put("Name", emp_name);
		emp .put("Mail", e_mail);
		emp .put("Mobile", phone);
		emp .put("department", department);
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
}
