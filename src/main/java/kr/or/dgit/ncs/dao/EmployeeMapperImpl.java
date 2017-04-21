package kr.or.dgit.ncs.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.ncs.dto.Employee;

public class EmployeeMapperImpl implements EmployeeMapper {
	private String nameSpace = "kr.or.dgit.ncs.mappers.EmployeeMapper"; //StudentMapper.xml�쓽 namespace
	private SqlSession sqlSession;
	
	private static final Log log = LogFactory.getLog(EmployeeMapperImpl.class);
	
	public EmployeeMapperImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public void insertEmployee(Employee employee) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Employee> selectEmployeeByAll() {
		log.debug("============== selectEmployeeByAll() ==============");
		return sqlSession.selectList(nameSpace+".select");
	}

	@Override
	public int getLastEmpCode() {
		return sqlSession.selectOne(nameSpace+".lastNum");
	}

	@Override
	public Employee selectEmployeeByNo(Map<String, Object> param) {
		log.debug("============== selectEmployeeByNo() ==============");
		return sqlSession.selectOne(nameSpace+".selectOne", param);
	}

}
