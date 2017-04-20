package kr.or.dgit.ncs.mainPanel;

import javax.swing.JPanel;

import kr.or.dgit.ncs.common.TextFieldPanel;

@SuppressWarnings("serial")
public abstract class AbstractPanelDto<T> extends JPanel{
	public abstract void setObject(T obj);
	public abstract T getObject();
	public abstract void clear();
	public abstract TextFieldPanel getNoPanel();
}
