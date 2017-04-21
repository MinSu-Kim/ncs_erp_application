package kr.or.dgit.ncs.dao;

import java.util.List;
import java.util.Map;

import kr.or.dgit.ncs.dto.Department;

public interface DepartmentMapper {
	public void insertDepartment(Department department);
	public void updateDepartment(Department department);
	public void deleteDepartment(Department department);
	public List<Department> selectDepartmentByAll();
	public int getLastDeptCode();
	public Department selectDepartmentByNo(Map<String, Object> param);
}
