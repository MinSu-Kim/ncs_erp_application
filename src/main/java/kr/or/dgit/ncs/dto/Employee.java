package kr.or.dgit.ncs.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

@SuppressWarnings("serial")
public class Employee  implements Serializable{
	private String empNo;	//E07001->E+serialNum(3?��리숫?��);
	private String empName;
	private Title title;
	private int salary;
	private boolean gender;
	private ArrayList<String> hobbys;
	private Department department;
	private Date joinDate;
	
	public Employee() {}
	
	public Employee(String empNo) {
		this.empNo = empNo;
	}
	
	
	public Employee(String empNo, String empName) {
		this.empNo = empNo;
		this.empName = empName;
	}

	public Employee(String empNo, String empName, Title title, int salary, boolean gender,
			ArrayList<String> hobbys, Department dept, Date joinDate) {
		this.empNo = empNo;
		this.empName = empName;
		this.title = title;
		this.salary = salary;
		this.gender = gender;
		this.hobbys = hobbys;
		this.department = dept;
		this.joinDate = joinDate;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
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

	public ArrayList<String> getHobbys() {
		return hobbys;
	}

	public void setHobbys(ArrayList<String> hobbys) {
		this.hobbys = hobbys;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	@Override
	public String toString() {
		return String.format("%s %s %s", empNo, empName, title);
	}

	public Object[] toArray(){
		return new Object[]{empNo, empName, title, String.format("%,d",salary), gender?"남자":"여자", hobbys, department, String.format("%tF", joinDate)};
	}

	@Override
	public boolean equals(Object obj) {
		Employee e = (Employee) obj;
		return empNo.equals(e.empNo);
	}
}
