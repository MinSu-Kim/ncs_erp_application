package kr.or.dgit.ncs.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.ncs.dao.DepartmentMapper;
import kr.or.dgit.ncs.dao.DepartmentMapperImpl;
import kr.or.dgit.ncs.dto.Department;
import kr.or.dgit.ncs.jdbc.MyBatisSqlSessionFactory;

public class DepartmentService {
	private static DepartmentService instance = new DepartmentService();
	
	private DepartmentService() {}

	public static DepartmentService getInstance() {
		return instance;
	}
	
	public int getLastCode(){
		int lastCode = -1;
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();) {
			DepartmentMapper deptMapper = new DepartmentMapperImpl(sqlSession);
			lastCode = deptMapper.getLastDeptCode();
			sqlSession.commit();
		}catch(Exception e){
			e.printStackTrace();
		}
		return lastCode;
	}
	
	public void insertDepartment(Department department){
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();) {
			DepartmentMapper deptMapper = new DepartmentMapperImpl(sqlSession);
			deptMapper.insertDepartment(department);
			sqlSession.commit();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void deleteDepartment(Department department){
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();) {
			DepartmentMapper deptMapper = new DepartmentMapperImpl(sqlSession);
			deptMapper.deleteDepartment(department);
			sqlSession.commit();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void updateDepartment(Department department){
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();) {
			DepartmentMapper deptMapper = new DepartmentMapperImpl(sqlSession);
			deptMapper.updateDepartment(department);
			sqlSession.commit();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public List<Department> selectList() {
		List<Department> lists = null;
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();) {
			DepartmentMapper deptMapper = new DepartmentMapperImpl(sqlSession);
			lists = deptMapper.selectDepartmentByAll();
			sqlSession.commit();
		}catch(Exception e){
			e.printStackTrace();
		}
		return lists;
	}
	
	public Department selectOne(int dCode) {
		Department dept = null;
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();) {
			DepartmentMapper deptMapper = new DepartmentMapperImpl(sqlSession);
			
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("dcode", dCode);
			dept =  deptMapper.selectDepartmentByNo(parameters);
		}catch(Exception e){
			e.printStackTrace();
		}
		return dept;
	}
}
