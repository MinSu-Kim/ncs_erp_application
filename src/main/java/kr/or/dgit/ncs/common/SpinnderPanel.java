package kr.or.dgit.ncs.common;
import javax.swing.JSpinner;
import java.awt.GridLayout;
import javax.swing.SpinnerNumberModel;

@SuppressWarnings("serial")
public class SpinnderPanel extends ParentCompPanel {

	private JSpinner spinner;

	public SpinnderPanel() {
		valueComp.setLayout(new GridLayout(0, 1, 0, 0));
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(1500000), null, null, new Integer(100000)));
		valueComp.add(spinner);
	}

	public void setSpinValue(int value){
		spinner.setValue(value);
	}
	
	public int getSpinValue(){
		return (int) spinner.getValue();
	}
	
	public void setDefaultValue(double value, double minimum, double maximum, double stepSize){
		spinner.setModel(new SpinnerNumberModel(value, minimum, maximum, stepSize));
	}
}
