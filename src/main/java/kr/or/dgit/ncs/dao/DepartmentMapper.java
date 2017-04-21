package kr.or.dgit.ncs.dao;

import java.util.List;
import java.util.Map;

import kr.or.dgit.ncs.dto.Department;

public interface DepartmentMapper {
	public int insertDepartment(Department department);
	public int updateDepartment(Department department);
	public int deleteDepartment(Department department);
	public List<Department> selectDepartmentByAll();
	public int getLastDeptCode();
	public Department selectDepartmentByNo(Map<String, Object> param);
}
