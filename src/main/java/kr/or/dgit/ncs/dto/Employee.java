package kr.or.dgit.ncs.dto;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Employee  implements Serializable{
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
	public boolean equals(Object obj) {
		Employee e = (Employee) obj;
		return empNo==e.empNo;
	}
}
