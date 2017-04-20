package kr.or.dgit.ncs.view;

import kr.or.dgit.ncs.dto.Title;
import kr.or.dgit.ncs.mainPanel.AbstractPanelDto;
import kr.or.dgit.ncs.mainPanel.PanelTitle;
import kr.or.dgit.ncs.service.TitleService;
import kr.or.dgit.ncs.table.AbsTablePanel;
import kr.or.dgit.ncs.table.TitleTablePanel;

@SuppressWarnings("serial")
public class ViewTitle extends AbstractViewPanel<Title> {

	public ViewTitle() {
		setTitle("직책 관리");
		setBounds(100, 100, 319, 286);
	}

	public void loadData(){
		tablePanel.loadData();
		initField();
	}
	
	@Override
	protected AbstractPanelDto<Title> createMainPanel() {
		return new PanelTitle();
	}

	@Override
	protected AbsTablePanel<Title> createTablePanel() {
		return new TitleTablePanel();
	}

	@Override
	protected void initField() {
		String deptNo = String.format("T%03d", TitleService.getInstance().getLastCode()+1);
		pMain.getNoPanel().setTfValue(deptNo);	
	}

	@Override
	protected void deleteItem() {
		TitleService.getInstance().deleteTitle(selectItem);		
	}

	@Override
	protected void updateItem() {
		TitleService.getInstance().deleteTitle(selectItem);		
	}

	@Override
	protected void addItem() {
		TitleService.getInstance().deleteTitle(selectItem);		
	}

	@Override
	protected void setTablePanelModel() {
		tablePanel.setDataModel(TitleService.getInstance().selectList());				
	}

}
