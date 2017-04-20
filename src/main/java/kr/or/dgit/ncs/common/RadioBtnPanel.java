package kr.or.dgit.ncs.common;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class RadioBtnPanel extends ParentCompPanel {
	private final ButtonGroup radioGrp = new ButtonGroup();
	private JPanel pRadio;
	
	public RadioBtnPanel(String... rdbList) {
		valueComp.setLayout(new GridLayout(0, 1));
		
		pRadio = new JPanel();
		valueComp.add(pRadio);

		for (String title : rdbList) {
			JRadioButton btn = new JRadioButton(title);
			radioGrp.add(btn);
			pRadio.add(btn);
		}
	}

	public void setSelectedItem(String obj){
		Component components[] = pRadio.getComponents();
		JRadioButton rbtn = null;
		for(Component c : components){
			if (c instanceof JRadioButton){
				rbtn = (JRadioButton) c;
				if (rbtn.getText().equals(obj)){
					rbtn.setSelected(true);
				}
			}
		}
	}
	
	public String getSelectedElements() {
		String selections = null;
		Component components[] = pRadio.getComponents();
		JRadioButton rbtn = null;
		for(Component c : components){
			if (c instanceof JRadioButton){
				rbtn = (JRadioButton) c;
				if (rbtn.isSelected()){
					selections = rbtn.getText();
				}
			}
		}
		return selections;
	}
}
