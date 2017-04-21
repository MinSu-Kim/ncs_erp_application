package kr.or.dgit.ncs.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.ncs.dao.EmployeeMapper;
import kr.or.dgit.ncs.dao.EmployeeMapperImpl;
import kr.or.dgit.ncs.dto.Employee;
import kr.or.dgit.ncs.jdbc.MyBatisSqlSessionFactory;

public class EmployeeService {
	private static EmployeeService instance = new EmployeeService();
	
	private EmployeeService() {}

	public static EmployeeService getInstance() {
		return instance;
	}
	
	public int getLastCode(){
		int lastCode = -1;
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();) {
			EmployeeMapper empMapper = new EmployeeMapperImpl(sqlSession);
			lastCode = empMapper.getLastEmpCode();
			sqlSession.commit();
		}catch(Exception e){
			e.printStackTrace();
		}
		return lastCode;
	}
	
	public void insertEmployee(Employee employee){
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();) {
			EmployeeMapper empMapper = new EmployeeMapperImpl(sqlSession);
			empMapper.insertEmployee(employee);
			sqlSession.commit();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void deleteEmployee(Employee employee){
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();) {
			EmployeeMapper empMapper = new EmployeeMapperImpl(sqlSession);
			empMapper.deleteEmployee(employee);
			sqlSession.commit();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void updateEmployee(Employee employee){
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();) {
			EmployeeMapper empMapper = new EmployeeMapperImpl(sqlSession);
			empMapper.updateEmployee(employee);
			sqlSession.commit();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public List<Employee> selectList() {
		List<Employee> lists = null;
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();) {
			EmployeeMapper empMapper = new EmployeeMapperImpl(sqlSession);
			lists = empMapper.selectEmployeeByAll();
			sqlSession.commit();
		}catch(Exception e){
			e.printStackTrace();
		}
		return lists;
	}
	
	public Employee selectOne(int empCode) {
		Employee emp = null;
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();) {
			EmployeeMapper empMapper = new EmployeeMapperImpl(sqlSession);
			
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("eno", empCode);
			emp =  empMapper.selectEmployeeByNo(parameters);
		}catch(Exception e){
			e.printStackTrace();
		}
		return emp;
	}
}
