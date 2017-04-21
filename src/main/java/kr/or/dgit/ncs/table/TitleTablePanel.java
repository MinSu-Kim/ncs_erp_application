package kr.or.dgit.ncs.table;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import kr.or.dgit.ncs.dto.Title;
import kr.or.dgit.ncs.service.DepartmentService;
import kr.or.dgit.ncs.service.TitleService;

@SuppressWarnings("serial")
public class TitleTablePanel extends AbsTablePanel<Title> {

	@Override
	public void loadData() {
		setDataModel(TitleService.getInstance().selectList());
		setModel(new DefaultTableModel(getRowDatas(), getColumnNames()));
		tableCellAlignment(SwingConstants.CENTER, 0, 1);
		tableSetWidth(100, 200);		
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
		return new Object[]{"번호", "직책"};
	}

	@Override
	public Title getSelectedData() {
		int idx = getSelectedRow();
		String dno = datas[idx][0].toString();
		if (idx==-1)return null;
		return TitleService.getInstance().selectOne(Integer.parseInt(dno.substring(1)));
	}

}
