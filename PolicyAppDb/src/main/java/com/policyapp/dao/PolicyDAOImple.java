package com.policyapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mysql.cj.Query;
import com.mysql.cj.x.protobuf.MysqlxPrepare.Execute;
import com.policy.utill.DbConnection;
import com.policyapp.exceptions.IdNotFoundException;
import com.policyapp.exceptions.PolicyNotFoundException;
import com.policyapp.model.Policy;

public class PolicyDAOImple implements IPolicyDAO {

	@Override
	public void addPolicy(Policy policy) {

		String SQL = "insert into policy(policy_name,premium,type,duration,coverage,brand,category,sum_assured) values (?,?,?,?,?,?,?,?)";
		Connection connection = DbConnection.openConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setString(1, policy.getPolicyName());
			preparedStatement.setDouble(2, policy.getPremium());
			preparedStatement.setString(3, policy.getType());
			preparedStatement.setInt(4, policy.getDuration());
			preparedStatement.setString(5, policy.getCoverage());
			preparedStatement.setString(6, policy.getBrand());
			preparedStatement.setString(7, policy.getCategory());
			preparedStatement.setDouble(8, policy.getSumAssured());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbConnection.closeConnection();
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
	}

	@Override
	public void deletePolicy(int policyId) {
		String str = "delete policy where policyId = ?" ;
		Connection connection = DbConnection.openConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(str);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbConnection.closeConnection();
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

	@Override
	public void updatePolicy(int policyId, String Coverge) {
		String str = "update  policy set coverage=? where policyId=?";
		Connection connection = DbConnection.openConnection();
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = connection.prepareStatement(str);
			preparedStatement.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DbConnection.closeConnection();
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

	@Override
	public List<Policy> findAll() {

		List<Policy> policies = new ArrayList();
		Connection connection = DbConnection.openConnection();
		String sql = "select * from policy";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Policy policy = new Policy();

				String policyName = rs.getString("policy_name");
				policy.setPolicyName(policyName);

				int policyId = rs.getInt("policy_id");
				policy.setPolicyNumber(policyId);

				double premium = rs.getDouble("premium");
				policy.setPremium(premium);

				String type = rs.getString("type");
				policy.setType(type);

				int duration = rs.getInt("Duration");
				policy.setDuration(duration);

				String coverage = rs.getString("Coverage");
				policy.setCoverage(coverage);

				String category = rs.getString("Category");
				policy.setCategory(category);

				double sumAssured = rs.getFloat("sum assured");
				policy.setSumAssured(sumAssured);

				String brand = rs.getString("brand");
				policy.setBrand(brand);
				policies.add(policy);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DbConnection.closeConnection();
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();

				}

			}
		}
		return policies;

	}

	@Override
	public List<Policy> findByType(String type) throws PolicyNotFoundException {

		List<Policy> policies = new ArrayList();
		Connection connection = DbConnection.openConnection();
		String sql = "select * from policy where type=?";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Policy policy = new Policy();

				String policyName = rs.getString("policy_name");
				policy.setPolicyName(policyName);

				int policyId = rs.getInt("policy_id");
				policy.setPolicyNumber(policyId);

				double premium = rs.getDouble("premium");
				policy.setPremium(premium);

				String findByType = rs.getString("type");
				policy.setType(type);

				int duration = rs.getInt("Duration");
				policy.setDuration(duration);

				String coverage = rs.getString("Coverage");
				policy.setCoverage(coverage);

				String category = rs.getString("Category");
				policy.setCategory(category);

				double sumAssured = rs.getFloat("sum assured");
				policy.setSumAssured(sumAssured);

				String brand = rs.getString("brand");
				policy.setBrand(brand);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DbConnection.closeConnection();
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		return policies;

	}

	@Override
	public List<Policy> findByCategory(String category) throws PolicyNotFoundException {
		List<Policy> policies = new ArrayList();
		Connection connection = DbConnection.openConnection();
		String sql = "select * from policy where category=?";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, category);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Policy policy = new Policy();

				String policyName = rs.getString("policy_name");
				policy.setPolicyName(policyName);

				int policyId = rs.getInt("policy_id");
				policy.setPolicyNumber(policyId);

				double premium = rs.getDouble("premium");
				policy.setPremium(premium);

				String Type = rs.getString("type");
				policy.setType(Type);

				int duration = rs.getInt("Duration");
				policy.setDuration(duration);

				String coverage = rs.getString("Coverage");
				policy.setCoverage(coverage);

				String ncategory = rs.getString("Category");
				policy.setCategory(ncategory);

				double sumAssured = rs.getFloat("sum assured");
				policy.setSumAssured(sumAssured);

				String brand = rs.getString("brand");
				policy.setBrand(brand);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DbConnection.closeConnection();
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		return policies;

	}

	@Override
	public List<Policy> findBySumLessThan(double sumAssured) throws PolicyNotFoundException {
		List<Policy> policies = new ArrayList();
		Connection connection = DbConnection.openConnection();
		String sql = "select * from policy where > ?";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setDouble(1, sumAssured);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Policy policy = new Policy();

				String policyName = rs.getString("policy_name");
				policy.setPolicyName(policyName);

				int policyId = rs.getInt("policy_id");
				policy.setPolicyNumber(policyId);

				double premium = rs.getDouble("premium");
				policy.setPremium(premium);

				String type = rs.getString("type");
				policy.setType(type);

				int duration = rs.getInt("Duration");
				policy.setDuration(duration);

				String coverage = rs.getString("Coverage");
				policy.setCoverage(coverage);

				String category = rs.getString("Category");
				policy.setCategory(category);

				double nsumAssured = rs.getFloat("sum assured");
				policy.setSumAssured(nsumAssured);

				String brand = rs.getString("brand");
				policy.setBrand(brand);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DbConnection.closeConnection();
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		return policies;

	}

	@Override
	public List<Policy> findByCoverage(String coverage) throws PolicyNotFoundException {

		List<Policy> policies = new ArrayList();
		Connection connection = DbConnection.openConnection();
		String sql = "select * from policy where coverage=?";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, coverage);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Policy policy = new Policy();

				String policyName = rs.getString("policy_name");
				policy.setPolicyName(policyName);

				int policyId = rs.getInt("policy_id");
				policy.setPolicyNumber(policyId);

				double premium = rs.getDouble("premium");
				policy.setPremium(premium);

				String type = rs.getString("type");
				policy.setType(type);

				int duration = rs.getInt("Duration");
				policy.setDuration(duration);

				String ncoverage = rs.getString("Coverage");
				policy.setCoverage(ncoverage);

				String category = rs.getString("Category");
				policy.setCategory(category);

				double sumAssured = rs.getFloat("sum assured");
				policy.setSumAssured(sumAssured);

				String brand = rs.getString("brand");
				policy.setBrand(brand);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DbConnection.closeConnection();
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		return policies;

	}

	@Override
	public List<Policy> findByLessPremium(double premium) throws PolicyNotFoundException {
		List<Policy> policies = new ArrayList();
		Connection connection = DbConnection.openConnection();
		String sql = "select * from policy where  premium<?";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setDouble(1, premium);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Policy policy = new Policy();

				String policyName = rs.getString("policy_name");
				policy.setPolicyName(policyName);

				int policyId = rs.getInt("policy_id");
				policy.setPolicyNumber(policyId);

				double npremium = rs.getDouble("premium");
				policy.setPremium(npremium);

				String type = rs.getString("type");
				policy.setType(type);

				int duration = rs.getInt("Duration");
				policy.setDuration(duration);

				String coverage = rs.getString("Coverage");
				policy.setCoverage(coverage);

				String category = rs.getString("Category");
				policy.setCategory(category);

				double sumAssured = rs.getFloat("sum assured");
				policy.setSumAssured(sumAssured);

				String brand = rs.getString("brand");
				policy.setBrand(brand);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DbConnection.closeConnection();
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		return policies;

	}

	@Override
	public Policy findById(int policyId) throws IdNotFoundException {

		Policy newpolicy = null;
		Connection connection = DbConnection.openConnection();
		String sql = "select * from policy where policyId=?";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setDouble(1, policyId);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Policy policy = new Policy();

				String policyName = rs.getString("policy_name");
				policy.setPolicyName(policyName);

				int npolicyId = rs.getInt("policy_id");
				policy.setPolicyNumber(npolicyId);

				double premium = rs.getDouble("premium");
				policy.setPremium(premium);

				String type = rs.getString("type");
				policy.setType(type);

				int duration = rs.getInt("Duration");
				policy.setDuration(duration);

				String coverage = rs.getString("Coverage");
				policy.setCoverage(coverage);

				String category = rs.getString("Category");
				policy.setCategory(category);

				double sumAssured = rs.getFloat("sum assured");
				policy.setSumAssured(sumAssured);

				String brand = rs.getString("brand");
				policy.setBrand(brand);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbConnection.closeConnection();
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return newpolicy;
	}
}
