package com.atmecs.demo_project.pagehelper;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.atmecs.demo_project.constants.Constants;

public class JsonOperations 
{
	JSONParser parser = new JSONParser();
	public JSONObject response;
	public JSONObject emp;
	
		public void readData() throws Exception
		{
			Object obj= parser.parse(new FileReader(Constants.JSON_DATA));
			
			JSONObject jsonOjb = (JSONObject) obj;
			
			JSONArray emp_detail = (JSONArray) jsonOjb.get("Details");

			for(int i=0;i<emp_detail.size();i++)
			{
				JSONObject datas = (JSONObject) emp_detail.get(i);
				
				String name = (String) datas.get("name");
				String mail_id = (String) datas.get("mail");
				String mobile = (String) datas.get("mobile");
				String department = (String) datas.get("department");
				
				System.out.println("Details of the employee "+i);
				System.out.println("------- -- --- -------- - \n");
				System.out.println("Name of the employee : "+name);
				System.out.println("Mail_id of the employee : "+mail_id);
				System.out.println("Mobile Number of the employee : "+mobile);
				System.out.println("Department of the employee : "+department+"\n\n");
			}
		}
		
		@SuppressWarnings("unchecked")
		public JSONObject  getEmp(String name, String mail, String mobile, String department)
		{
			emp = new JSONObject();
			emp .put("Name", name);
			emp .put("Mail", mail);
			emp .put("Mobile", mobile);
			emp .put("department", department);
			return emp;
		}

		@SuppressWarnings("unchecked")
		public JSONObject writeData()
		{

		JSONArray employees = new JSONArray();
		employees.add(getEmp("Abc","abc@gmail.com","8473829834","n/w"));
		employees.add(getEmp("def","def@gmail.com","8473829834","n/w"));
		employees.add(getEmp("Ghj","ghj@gmail.com","8473829834","n/w"));
		employees.add(getEmp("Jnb","jnb@gmail.com","8473829834","n/w"));
		employees.add(getEmp("Lmn","lmn@gmail.com","8473829834","n/w"));
		employees.add(getEmp("Fsd","fsd@gmail.com","8473829834","n/w"));
		
		response = new JSONObject();
		response.put("Employees", employees );

		System.out.println(response);

		try 
		{
			FileWriter file = new FileWriter("./src/main/resources/datas/employees.json");
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
