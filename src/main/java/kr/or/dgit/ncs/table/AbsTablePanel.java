package kr.or.dgit.ncs.table;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

@SuppressWarnings("serial")
public abstract class AbsTablePanel<T> extends JTable {
	protected List<T> dataModel;
	protected Object[][] datas;
	
	public void setDataModel(List<T> dataModel) {
		this.dataModel = dataModel;
		this.datas = new Object[dataModel.size()][];
	}
	
	public List<T> getDataModel() {
		return dataModel;
	}

	protected void tableCellAlignment(int align, int... idx) {
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);

		TableColumnModel model = getColumnModel();
		for (int i = 0; i < idx.length; i++) {
			model.getColumn(idx[i]).setCellRenderer(dtcr);
		}
	}

	protected void tableSetWidth(int... width) {
		TableColumnModel cModel = getColumnModel();

		for (int i = 0; i < width.length; i++) {
			cModel.getColumn(i).setPreferredWidth(width[i]);
		}
	}
	
	public abstract T getSelectedData();
	
	public abstract void loadData();
	
	protected abstract Object[][] getRowDatas();

	protected abstract Object[] getColumnNames();
}
