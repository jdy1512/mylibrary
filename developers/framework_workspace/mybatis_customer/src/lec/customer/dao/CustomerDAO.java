package lec.customer.dao;

import java.io.IOException;
import java.util.List;

import lec.customer.vo.Customer;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class CustomerDAO {
	private static CustomerDAO instance = new CustomerDAO();
	
	private SqlSessionFactory sqlSessionFactory;
	private final String namespace = "customer.";
	
	private CustomerDAO() {
		try {
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("lec/customer/config/mybatis-config.xml"));
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public static CustomerDAO getInstance() {
		return instance;
	}

	public void insertCustomer(Customer customer) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			sqlSession.insert(namespace + "insertCustomer", customer);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	public void updateCustomer(Customer customer) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			sqlSession.update(namespace + "udpateCustomer", customer);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	public void deleteCustomerById(String id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			sqlSession.delete(namespace + "deleteCustomerById", id);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	public Customer selectCustomerById(String id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			return sqlSession.selectOne(namespace + "selectCustomerById", id);
		} finally {
			sqlSession.close();
		}
	}

	public Customer selectCustomerByName(String name) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			return sqlSession.selectOne(namespace + "selectCustomerByName", name);
		} finally {
			sqlSession.close();
		}
	}

	public Customer selectCustomerByEmail(String email) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			return sqlSession.selectOne(namespace + "selectCustomerByEmail", email);
		} finally {
			sqlSession.close();
		}
	}

	public List<Customer> selectCustomerByMileageRange(int min, int max) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			return sqlSession.selectList(namespace + "selectCustomerByMileageRange", new int[]{min, max});
		} finally {
			sqlSession.close();
		}
	}
}
