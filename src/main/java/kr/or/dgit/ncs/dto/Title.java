package kr.or.dgit.ncs.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Title  implements Serializable{
	private String no; //T001
	private String title;
	
	
	public Title() {
		// TODO Auto-generated constructor stub
	}

	public Title(String no) {
		this.no = no;
	}

	public Title(String no, String title) {
		this.no = no;
		this.title = title;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
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
		return no.equals(tmp.no);
	}
	
	public Object[] toArray(){
		return new Object[]{no, title};
	}
	
}