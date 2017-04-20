package kr.or.dgit.ncs.mainPanel;

import java.awt.GridLayout;

import kr.or.dgit.ncs.common.TextFieldPanel;
import kr.or.dgit.ncs.dto.Title;

@SuppressWarnings("serial")
public class PanelTitle extends AbstractPanelDto<Title>{

	private TextFieldPanel pNo;
	private TextFieldPanel pTitle;

	public PanelTitle() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		pNo = new TextFieldPanel();
		pNo.setTitle("번호");
		add(pNo);
		
		pTitle = new TextFieldPanel();
		pTitle.setTitle("직책명");
		add(pTitle);
	}
	
	@Override
	public void clear(){
		pNo.setTfValue("");
		pTitle.setTfValue("");
	}

	@Override
	public void setObject(Title obj) {
		pNo.setTfValue(obj.getNo()+"");
		pTitle.setTfValue(obj.getTitle());		
	}

	@Override
	public Title getObject() {
		String no = pNo.getTfValue();
		String title = pTitle.getTfValue();
		return new Title(no, title);
	}

	@Override
	public TextFieldPanel getNoPanel() {
		return pNo;
	}
}
