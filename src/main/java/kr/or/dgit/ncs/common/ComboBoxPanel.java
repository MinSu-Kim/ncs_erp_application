package kr.or.dgit.ncs.common;

import java.awt.GridLayout;
import java.util.List;
import java.util.Vector;

import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class ComboBoxPanel<T> extends ParentCompPanel {
	private JComboBox<T> tf;
	
	public ComboBoxPanel() {
		valueComp.setLayout(new GridLayout(0, 1));
		tf = new JComboBox<>();
		valueComp.add(tf);
	}

	public void setComboDatas(Vector<T> items){
		for(int i=0; i<items.size(); i++){
			tf.addItem(items.get(i));
		}
	}
	
	public void setComboDatas(List<T> items){
		for(T t : items){
			tf.addItem(t);
		}
	}
	
	public Object getSelectedItem(){
		return tf.getSelectedItem();
	}
	
	public void setSelectedItem(Object obj){
		tf.setSelectedItem(obj);
	}
	
	public void setSelectedIndex(int idx){
		tf.setSelectedIndex(idx);
	}
}
