package kr.or.dgit.ncs.table;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import kr.or.dgit.ncs.dto.Department;
import kr.or.dgit.ncs.service.DepartmentService;

@SuppressWarnings("serial")
public class DepartmentTablePanel extends AbsTablePanel<Department> {

	@Override
	public void loadData() {
		setModel(new DefaultTableModel(getRowDatas(), getColumnNames()));
		tableCellAlignment(SwingConstants.CENTER, 0, 1, 2);
		tableSetWidth(100, 200, 100);		
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
		return new Object[]{"번호", "부서명", "위치"};
	}

	@Override
	public Department getSelectedData() {
		int idx = getSelectedRow();
		
		if (idx==-1)return null;
		return DepartmentService.getInstance().selectOne(datas[idx][0].toString());
	}

}
