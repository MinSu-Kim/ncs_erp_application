package kr.or.dgit.ncs.common;

import java.awt.Color;
import java.awt.GridLayout;
import java.text.ParseException;
import java.util.regex.Pattern;

import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

public class TextFieldFormatPanel extends ParentCompPanel {
	private static final long serialVersionUID = 1L;
	
	private JFormattedTextField tfValue;
	private MaskFormatter maskFormatter;
	
	public TextFieldFormatPanel(String pattern, char placeholder) {
		valueComp.setLayout(new GridLayout(0, 1));
		
		maskFormatter = new MaskFormatter();
		setMaskPattern(pattern, placeholder);
		
		tfValue = new JFormattedTextField(maskFormatter);
		valueComp.add(tfValue);
		tfValue.setColumns(20);
	}

	public String getTfValue() {
		return tfValue.getText();
	}

	public void setTfValue(String value) {
		this.tfValue.setText(value);
	}


	public void isEmptyCheck() throws Exception{
		if(tfValue.getText().equals("")){
			tfValue.requestFocus();
			throw new Exception("공백 존재");
		}
	}
	
	public void isValidCheck(String pattern, String msg) throws Exception{
		if(!Pattern.matches(pattern, tfValue.getText().trim())){
			tfValue.requestFocus();
			tfValue.setSelectionStart(0);
			tfValue.setSelectedTextColor(Color.RED);
			throw new Exception(msg);
		}
	}
	
	public void setMaskPattern(String pattern, char placeholder){
		try {
			maskFormatter.setMask(pattern);
			maskFormatter.setPlaceholderCharacter(placeholder);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}

