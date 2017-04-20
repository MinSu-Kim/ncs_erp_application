package kr.or.dgit.ncs.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Department implements Serializable{
	private String deptNo; //"D+001"
	private String deptName;
	private int floor;

	public Department() {
	}

	public Department(String deptNo, String deptName, int floor) {
		this.deptNo = deptNo;
		this.deptName = deptName;
		this.floor = floor;
	}

	public Department(Object...obj){
		this.deptNo = (String) obj[0];
		this.deptName = (String) obj[1];
		this.floor = (int) obj[2];
	}
	public String getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	@Override
	public String toString() {
		return deptName + "(" + floor + "층)";
	}

	public Object[] toArray() {
		return new Object[] { deptNo, deptName, floor};
	}

	@Override
	public boolean equals(Object obj) {
		Department tmp = (Department) obj;
		return deptNo.equals(tmp.deptNo);
	}

}
