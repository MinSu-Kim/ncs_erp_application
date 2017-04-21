package kr.or.dgit.ncs.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.ncs.dto.Department;

public class DepartmentMapperImpl implements DepartmentMapper {
	private String nameSpace = "kr.or.dgit.ncs.mappers.DepartmentMapper"; //StudentMapper.xml�쓽 namespace
	private SqlSession sqlSession;
	
	private static final Log log = LogFactory.getLog(EmployeeMapperImpl.class);
	
	public DepartmentMapperImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public void insertDepartment(Department department) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateDepartment(Department department) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteDepartment(Department department) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Department> selectDepartmentByAll() {
		log.debug("============== selectDepartmentByAll() ==============");
		return sqlSession.selectList(nameSpace+".select");
	}

	@Override
	public int getLastDeptCode() {
		log.debug("============== getLastDeptCode() ==============");
		return sqlSession.selectOne(nameSpace+".lastNum");
	}

	@Override
	public Department selectDepartmentByNo(Map<String, Object> param) {
		log.debug("============== selectDepartmentByNo() ==============");
		return sqlSession.selectOne(nameSpace+".selectOne", param);
	}

}
