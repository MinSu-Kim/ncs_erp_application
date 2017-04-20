package kr.or.dgit.ncs.view;

import java.util.Date;

import kr.or.dgit.ncs.dto.Employee;
import kr.or.dgit.ncs.mainPanel.AbstractPanelDto;
import kr.or.dgit.ncs.mainPanel.PanelEmployee;
import kr.or.dgit.ncs.service.DepartmentService;
import kr.or.dgit.ncs.service.EmployeeService;
import kr.or.dgit.ncs.service.TitleService;
import kr.or.dgit.ncs.table.AbsTablePanel;
import kr.or.dgit.ncs.table.EmployeeTablePanel;

@SuppressWarnings("serial")
public class ViewEmployee extends AbstractViewPanel<Employee> {

	public ViewEmployee() {
		setTitle("사원 관리");
		setBounds(100, 100, 586, 524);
	}
	
	public void loadData(){
		tablePanel.loadData();
		initField();
	}
	
	public void setTitles() {
		((PanelEmployee)pMain).setTitles(TitleService.getInstance().selectList());
	}

	public void setDepartments() {
		((PanelEmployee)pMain).setDepartments(DepartmentService.getInstance().selectList());
	}

	@Override
	protected AbstractPanelDto<Employee> createMainPanel() {
		return new PanelEmployee();
	}


	@Override
	protected AbsTablePanel<Employee> createTablePanel() {
		return new EmployeeTablePanel();
	}

	@Override
	protected void initField() {
		String empNo = String.format("E%ty%03d", new Date(), EmployeeService.getInstance().getLastCode()+1);
		pMain.getNoPanel().setTfValue(empNo);		
	}

	@Override
	protected void deleteItem() {
		EmployeeService.getInstance().deleteEmployee(selectItem);
	}

	@Override
	protected void updateItem() {
		EmployeeService.getInstance().updateEmployee(selectItem);		
	}

	@Override
	protected void addItem() {
		EmployeeService.getInstance().insertEmployee(selectItem);		
	}

	@Override
	protected void setTablePanelModel() {
		tablePanel.setDataModel(EmployeeService.getInstance().selectList());		
	}

}
