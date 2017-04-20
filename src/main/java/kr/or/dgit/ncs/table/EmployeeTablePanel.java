package kr.or.dgit.ncs.table;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import kr.or.dgit.ncs.dto.Employee;
import kr.or.dgit.ncs.service.EmployeeService;

@SuppressWarnings("serial")
public class EmployeeTablePanel extends AbsTablePanel<Employee> {

	@Override
	public void loadData() {
		setModel(new DefaultTableModel(getRowDatas(), getColumnNames()));
		tableCellAlignment(SwingConstants.CENTER, 0, 1, 2, 4, 5, 6, 7);
		tableCellAlignment(SwingConstants.RIGHT, 3);
		tableSetWidth(30, 50, 30, 50, 30, 50, 50, 50);		
	}

	@Override
	protected Object[][] getRowDatas() {
		for(int i=0; i<dataModel.size(); i++){
			datas[i] = dataModel.get(i).toArray();
		}
		return datas;
	}

	@Override
	protected Object[] getColumnNames() {
		return new Object[]{"번호", "사원명", "직책","급여","성별","취미", "부서","입사일"};
	}

	@Override
	public Employee getSelectedData() {
		int idx = getSelectedRow();
		return EmployeeService.getInstance().selectOne(datas[idx][0].toString());
	}

}
