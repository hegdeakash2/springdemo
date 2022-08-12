package com.policyapp.service;

import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.policyapp.dao.IPolicyDAO;
import com.policyapp.dao.PolicyDAOImple;
import com.policyapp.exceptions.IdNotFoundException;
import com.policyapp.exceptions.PolicyNotFoundException;
import com.policyapp.model.Policy;

public class PolicyServiceImpl implements IPolicyService {
	
	IPolicyDAO iPolicyDAO=new PolicyDAOImple();
	@Override
	public void addPolicy(Policy policy) {
		iPolicyDAO.addPolicy(policy);
		
	}

	@Override
	public void deletePolicy(int policyId) {
		iPolicyDAO.deletePolicy(policyId);
		
	}

	@Override
	public void updatePolicy(int policyId, String Coverge) {
		iPolicyDAO.updatePolicy(policyId,Coverge);
		
	}

	@Override
	public List<Policy> getAll() {
		List<Policy>policies=iPolicyDAO.findAll();
		policies.stream().sorted((Policy p1,Policy p2)->p1.getType().compareTo(p2.getType())).collect(Collectors.toList());
		return null;
	}

	@Override
	public List<Policy> getByType(String type) throws PolicyNotFoundException {
		List<Policy>policies=
		return null;
	}

	@Override
	public List<Policy> getByCategory(String category) throws PolicyNotFoundException {
		List<Policy>policies=
		return null;
	}

	@Override
	public List<Policy> getBySumLessThan(double sumAssured) throws PolicyNotFoundException {
		List<Policy>policies=
		return null;
	}

	@Override
	public List<Policy> getByCoverage(String coverage) throws PolicyNotFoundException {
		
		return null;
	}

	@Override
	public List<Policy> getByLessPremium(double premium) throws PolicyNotFoundException {
		
		return null;
	}

	@Override
	public Policy getById(int policyId) throws IdNotFoundException {
		
		return null;
	}

	@Override
	public List<Policy> getByBrand(String brand) throws PolicyNotFoundException {
		/
		return null;
	}

	
	
}
	