package kr.or.dgit.ncs.common;

import java.awt.Component;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CheckBoxPanel extends ParentCompPanel {
	private JPanel pCheckBox;
	
	public CheckBoxPanel(String... rdbList) {
		valueComp.setLayout(new GridLayout(0, 1));
		pCheckBox = new JPanel();
		valueComp.add(pCheckBox);
		
		for (String title : rdbList) {
			JCheckBox btn = new JCheckBox(title);
			pCheckBox.add(btn);
		}
	}
	
	public void selectedClear(){
		Component components[] = pCheckBox.getComponents();
		for(Component c : components){
			if (c instanceof AbstractButton) {
				AbstractButton button = (AbstractButton) c;
				button.setSelected(false);
			}
		}
	}

	public void setSelectedItems(ArrayList<String> arrayList){
		Component components[] = pCheckBox.getComponents();
		for(String h : arrayList){
			for (int i = 0, n = components.length; i < n; i++) {
				if (components[i] instanceof AbstractButton) {
					AbstractButton button = (AbstractButton) components[i];
					if (button.getText().equals(h)) {
						button.setSelected(true);
					}
				}
			}
		}

	}
	public ArrayList<String> getSelectedElements() {
		ArrayList<String> selections = new ArrayList<String>();
		Component components[] = pCheckBox.getComponents();
		for (int i = 0, n = components.length; i < n; i++) {
			if (components[i] instanceof AbstractButton) {
				AbstractButton button = (AbstractButton) components[i];
				if (button.isSelected()) {
					selections.add(button.getText());
				}
			}
		}
		return selections;
	}
}
