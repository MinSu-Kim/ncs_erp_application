package kr.or.dgit.ncs;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.ncs.dao.EmployeeMapper;
import kr.or.dgit.ncs.dao.EmployeeMapperImpl;
import kr.or.dgit.ncs.dto.Employee;
import kr.or.dgit.ncs.jdbc.MyBatisSqlSessionFactory;

public class EmployeeMapperTest {
	private static EmployeeMapper employeeMapper;
	private static SqlSession sqlSession;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();
		employeeMapper = new EmployeeMapperImpl(sqlSession);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testSelect() {
		List<Employee> list = employeeMapper.selectEmployeeByAll();

		Assert.assertNotNull(list);
	}

}
