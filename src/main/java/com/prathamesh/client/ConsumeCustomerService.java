package com.prathamesh.client;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.prathamesh.entity.Customer;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ConsumeCustomerService {

	public static void main(String[] args) throws JSONException {

		Response response = RestAssured.get("http://localhost:8080/restdemo/rest/customers");
		String responseString = response.asString();
		JSONArray jsonArray = new JSONArray(responseString);
		JSONObject json =null;
		List<Customer> customerList = new ArrayList<>();
		for(int i=0;i<jsonArray.length();i++){
			 json = new JSONObject(jsonArray.get(i).toString());
			 customerList.add(new Customer(json.getInt("customerId"),  json.getString("customerName")));
		}
		
		System.out.println("Webservice json to Java Object---"+ customerList);
		
	}
}


