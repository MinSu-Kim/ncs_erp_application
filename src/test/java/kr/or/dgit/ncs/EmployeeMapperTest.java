package kr.or.dgit.ncs;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.dgit.ncs.dto.Department;
import kr.or.dgit.ncs.dto.Employee;
import kr.or.dgit.ncs.dto.Title;
import kr.or.dgit.ncs.service.DepartmentService;
import kr.or.dgit.ncs.service.EmployeeService;
import kr.or.dgit.ncs.service.TitleService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeMapperTest {
	private static EmployeeService employeeService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		employeeService = EmployeeService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		employeeService = null;
	}

	@Test
	public void testAInsert(){
		Title title = TitleService.getInstance().selectOne(1);
		Department dept = DepartmentService.getInstance().selectOne(1);
		Calendar cal = GregorianCalendar.getInstance();
		cal.clear();
		cal.set(2017, 03, 21);
		Date joinDate = cal.getTime();
		boolean gender = false;
		int empCode = EmployeeService.getInstance().getLastCode()+1;
		Employee employee  = new Employee(empCode, "Test", title, 350000, gender, dept, joinDate);
		employeeService.insertEmployee(employee);
		Employee targetEmp = EmployeeService.getInstance().selectOne(empCode);
		Assert.assertEquals(targetEmp, employee);
	}
	
	@Test
	public void testBDelete(){
		int empCode = EmployeeService.getInstance().getLastCode();
		employeeService.deleteEmployee(new Employee(empCode));
		Employee targetEmp = EmployeeService.getInstance().selectOne(empCode);
		Assert.assertNull(targetEmp);
	}
	
	@Test
	public void testCUpdate(){
		int empCode = EmployeeService.getInstance().getLastCode();
		Employee targetEmp = EmployeeService.getInstance().selectOne(empCode);
		targetEmp.setEmpName("테스트");
		EmployeeService.getInstance().updateEmployee(targetEmp);
		Employee updateEmp = EmployeeService.getInstance().selectOne(empCode);
		Assert.assertEquals(targetEmp, updateEmp);
	}
	
	@Test
	public void testDSelect() {
		List<Employee> list = employeeService.selectList();
		Assert.assertNotNull(list);
	}

}
