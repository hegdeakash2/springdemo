package com.policyapp.client;

import com.policyapp.model.Policy;
import com.policyapp.service.IPolicyService;
import com.policyapp.service.PolicyServiceImpl;

public class User {

	public static void main(String[] args) {
		IPolicyService policyService= new PolicyServiceImpl();
		
		  Policy policy=new
		  Policy("acko",1,234,"health",5,"family","tata","general",3000000);
		  policyService.addPolicy(policy);
		 
//				policyService.getAll()
	}

}
