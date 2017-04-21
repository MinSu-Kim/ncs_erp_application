package kr.or.dgit.ncs.dto;

import java.util.Date;

public class Employee{
	private int empNo;	
	private String empName;
	private Title title;
	private int salary;
	private boolean gender;
	private Department department;
	private Date joinDate;
	
	public Employee() {}
	
	public Employee(int empNo) {
		this.empNo = empNo;
	}
	
	
	public Employee(int empNo, String empName) {
		this(empNo);
		this.empName = empName;
	}

	public Employee(int empNo, String empName, Title title, int salary, boolean gender,Department dept, Date joinDate) {
		this(empNo, empName);
		this.title = title;
		this.salary = salary;
		this.gender = gender;
		this.department = dept;
		this.joinDate = joinDate;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public Department getDept() {
		return department;
	}

	public void setDept(Department dept) {
		this.department = dept;
	}

	
	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	@Override
	public String toString() {
		return String.format("%s %s %s", String.format("E%06d", empNo), empName, title);
	}
	
	public Object[] toArray(){
		return new Object[]{String.format("E%06d", empNo), empName, title, String.format("%,d",salary), gender?"남자":"여자", department, String.format("%tF", joinDate)};
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + ((empName == null) ? 0 : empName.hashCode());
		result = prime * result + empNo;
		result = prime * result + (gender ? 1231 : 1237);
		result = prime * result + ((joinDate == null) ? 0 : joinDate.hashCode());
		result = prime * result + salary;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (empName == null) {
			if (other.empName != null)
				return false;
		} else if (!empName.equals(other.empName))
			return false;
		if (empNo != other.empNo)
			return false;
		if (gender != other.gender)
			return false;
		if (joinDate == null) {
			if (other.joinDate != null)
				return false;
		} else if (!joinDate.equals(other.joinDate))
			return false;
		if (salary != other.salary)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
}
