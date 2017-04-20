package kr.or.dgit.ncs.common;

import java.awt.GridLayout;

import javax.swing.JTextField;

@SuppressWarnings("serial")
public class TextFieldPanel extends ParentCompPanel {
	private JTextField tf;

	public TextFieldPanel() {
		valueComp.setLayout(new GridLayout(0, 1));
		tf = new JTextField();
		valueComp.add(tf);
	}

	public String getTfValue() {
		return tf.getText().trim();
	}

	public void setTfValue(String value) {
		tf.setText(value);
	}

	public void isEmptyCheck() throws Exception {
		if (tf.getText().equals("")) {
			tf.requestFocus();
			throw new Exception("공백 존재");
		}
	}

	public JTextField getTf() {
		return tf;
	}

}
