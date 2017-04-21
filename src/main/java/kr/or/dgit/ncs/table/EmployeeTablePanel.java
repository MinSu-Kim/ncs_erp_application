package kr.or.dgit.ncs.table;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import kr.or.dgit.ncs.dto.Employee;
import kr.or.dgit.ncs.service.EmployeeService;

@SuppressWarnings("serial")
public class EmployeeTablePanel extends AbsTablePanel<Employee> {

	@Override
	public void loadData() {
		setDataModel(EmployeeService.getInstance().selectList());
		setModel(new DefaultTableModel(getRowDatas(), getColumnNames()));
		tableCellAlignment(SwingConstants.CENTER, 0, 1, 2, 4, 5, 6);
		tableCellAlignment(SwingConstants.RIGHT, 3);
		tableSetWidth(30, 50, 30, 50, 30, 50, 50);		
	}

	@Override
	protected Object[][] getRowDatas() {
		this.datas = new Object[dataModel.size()][];
		for(int i=0; i<dataModel.size(); i++){
			datas[i] = dataModel.get(i).toArray();
		}
		return datas;
	}

	@Override
	protected Object[] getColumnNames() {
		return new Object[]{"번호", "사원명", "직책","급여","성별","부서","입사일"};
	}

	@Override
	public Employee getSelectedData() {
		int idx = getSelectedRow();
		String eno = datas[idx][0].toString();
		return EmployeeService.getInstance().selectOne(Integer.parseInt(eno.substring(1)));
	}

}
