package kr.or.dgit.ncs.dao;

import java.util.List;
import java.util.Map;

import kr.or.dgit.ncs.dto.Employee;

public interface EmployeeMapper {
	public void insertEmployee(Employee employee);
	public void updateEmployee(Employee employee);
	public void deleteEmployee(Employee employee);
	public List<Employee> selectEmployeeByAll();
	public int getLastEmpCode();
	public Employee selectEmployeeByNo(Map<String, Object> param);
}
