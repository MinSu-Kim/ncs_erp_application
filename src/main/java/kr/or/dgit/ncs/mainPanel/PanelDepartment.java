package kr.or.dgit.ncs.mainPanel;

import java.awt.GridLayout;

import kr.or.dgit.ncs.common.DigitKeyListener;
import kr.or.dgit.ncs.common.TextFieldPanel;
import kr.or.dgit.ncs.dto.Department;

@SuppressWarnings("serial")
public class PanelDepartment extends AbstractPanelDto<Department>{

	private TextFieldPanel pNo;
	private TextFieldPanel pName;
	private TextFieldPanel pFloor;

	public PanelDepartment() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		pNo = new TextFieldPanel();
		pNo.setTitle("번호");
		add(pNo);
		
		pName = new TextFieldPanel();
		pName.setTitle("부서명");
		add(pName);
		
		pFloor = new TextFieldPanel();
		pFloor.setTitle("위치");
		pFloor.getTf().addKeyListener(new DigitKeyListener());
		add(pFloor);
	}
	
	@Override
	public void clear(){
		pNo.setTfValue("");
		pName.setTfValue("");
		pFloor.setTfValue("");
	}

	@Override
	public void setObject(Department obj) {
		pNo.setTfValue(String.format("D%03d", obj.getDeptNo()));
		pName.setTfValue(obj.getDeptName());
		pFloor.setTfValue(obj.getFloor()+"");		
	}

	@Override
	public Department getObject() {
		String strDeptNo = pNo.getTfValue();
		int deptNo = Integer.parseInt(strDeptNo.substring(1, strDeptNo.length()));
		String deptName = pName.getTfValue();
		int floor = Integer.parseInt(pFloor.getTfValue());
		return new Department(deptNo, deptName, floor);
	}

	@Override
	public TextFieldPanel getNoPanel() {
		return pNo;
	}
}
