package kr.or.dgit.ncs.view;

import kr.or.dgit.ncs.dto.Department;
import kr.or.dgit.ncs.mainPanel.AbstractPanelDto;
import kr.or.dgit.ncs.mainPanel.PanelDepartment;
import kr.or.dgit.ncs.service.DepartmentService;
import kr.or.dgit.ncs.table.AbsTablePanel;
import kr.or.dgit.ncs.table.DepartmentTablePanel;

@SuppressWarnings("serial")
public class ViewDepartment extends AbstractViewPanel<Department> {

	public ViewDepartment() {
		setTitle("부서 관리");
		setBounds(100, 100, 319, 286);
	}

	public void loadData(){
		tablePanel.loadData();
		initField();
	}

	@Override
	protected AbstractPanelDto<Department> createMainPanel() {
		return new PanelDepartment();
	}

	@Override
	protected AbsTablePanel<Department> createTablePanel() {
		return new DepartmentTablePanel();
	}

	@Override
	protected void initField() {
		String deptNo = String.format("D%03d", DepartmentService.getInstance().getLastCode()+1);
		pMain.getNoPanel().setTfValue(deptNo);		
	}

	@Override
	protected void deleteItem() {
		DepartmentService.getInstance().deleteDepartment(selectItem);
	}

	@Override
	protected void updateItem() {
		DepartmentService.getInstance().updateDepartment(selectItem);
	}

	@Override
	protected void addItem() {
		DepartmentService.getInstance().insertDepartment(selectItem);
	}

	@Override
	protected void setTablePanelModel() {
		tablePanel.setDataModel(DepartmentService.getInstance().selectList());		
	}

}
