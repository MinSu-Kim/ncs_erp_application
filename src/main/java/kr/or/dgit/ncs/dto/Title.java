package kr.or.dgit.ncs.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Title  implements Serializable{
	private int no; //T001
	private String title;
	
	
	public Title() {
		// TODO Auto-generated constructor stub
	}

	public Title(int no) {
		this.no = no;
	}

	public Title(int no, String title) {
		this.no = no;
		this.title = title;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return title;
	}

	@Override
	public boolean equals(Object obj) {
		Title tmp = (Title) obj;
		return no==tmp.no;
	}
	
	public Object[] toArray(){
		return new Object[]{String.format("T%03d", no), title};
	}
	
}