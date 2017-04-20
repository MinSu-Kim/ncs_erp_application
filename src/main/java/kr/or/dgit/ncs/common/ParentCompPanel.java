package kr.or.dgit.ncs.common;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class ParentCompPanel extends JPanel {
	protected JPanel valueComp;
	private GridBagConstraints gbConstraints;
	private JLabel lblTitle;

	public ParentCompPanel() {
		gbConstraints = new GridBagConstraints();
		
		GridBagLayout gbl = new GridBagLayout();
		gbl.columnWeights = new double[]{0.0, 1.0};
		gbl.columnWidths = new int[]{100, 200};
		setLayout(gbl);
		
		lblTitle = new JLabel("New label");
		lblTitle.setHorizontalAlignment(SwingConstants.RIGHT);
		addComponentToFrame(lblTitle,0,0,1,1,1.0,1.0,GridBagConstraints.BOTH, GridBagConstraints.WEST);

		valueComp = new JPanel();
		addComponentToFrame(valueComp,1,0,2,1,1.0,1.0,GridBagConstraints.BOTH, GridBagConstraints.WEST);
	}

	public void setTitle(String title){
		lblTitle.setText(title);
	}
	
	public JPanel getValueComp() {
		return valueComp;
	}

	private void addComponentToFrame(JComponent comp, int x, int y, int width, int height, double weightx, double weighty, int fill, int anchor){
//		gbConstraints.ipady = 10;  //컴포넌트 내  여백 padding
//		gbConstraints.ipadx = 20;  //컴포넌트 내  여백 padding
		gbConstraints.insets = new Insets(0, 5, 0, 5);//컴포넌트간여백
		gbConstraints.fill = fill; 
		gbConstraints.gridx = x;
		gbConstraints.gridy = y;
		gbConstraints.gridwidth = width;
		gbConstraints.gridheight = height;
		gbConstraints.weightx = weightx;
		gbConstraints.weighty = weighty;
		add(comp, gbConstraints);
	}

}
