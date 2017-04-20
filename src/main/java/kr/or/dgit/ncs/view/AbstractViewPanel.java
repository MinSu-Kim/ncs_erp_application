package kr.or.dgit.ncs.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.ncs.mainPanel.AbstractPanelDto;
import kr.or.dgit.ncs.table.AbsTablePanel;

@SuppressWarnings("serial")
public abstract class AbstractViewPanel<T> extends JFrame {

	private JPanel contentPane;
	protected AbsTablePanel<T> tablePanel;
	protected AbstractPanelDto<T> pMain;
	protected GridBagConstraints gbConstraints;
	private JButton btnAdd;
	private JButton btnCancel;	
	private JPopupMenu popupMenu;
	protected T selectItem;
	
	public AbstractViewPanel() {
		gbConstraints = new GridBagConstraints();

		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 319, 286);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridBagLayout());
		
		pMain = createMainPanel();
		pMain.getNoPanel().getTf().setEditable(false);
		addComponentToFrame(pMain, 0, 0, 1, 1, 1.0, 0.0, GridBagConstraints.NONE, GridBagConstraints.NORTH);
		
		JPanel pBtn = new JPanel();
		addComponentToFrame(pBtn, 0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.NONE, GridBagConstraints.CENTER);
		
		btnAdd = new JButton("추가");
		btnAdd.addActionListener(btnListener);
		pBtn.add(btnAdd);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(btnListener);
		pBtn.add(btnCancel);
		
		popupMenu = createPopupMenu();
		
		JScrollPane scrollPane = new JScrollPane();
		tablePanel = createTablePanel();
		tablePanel.addMouseListener(mouseAdapter);
		scrollPane.setViewportView(tablePanel);
		addComponentToFrame(scrollPane, 0, 2, 1, 1, 1.0, 1.0, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
	}

	private JPopupMenu createPopupMenu() {
		JPopupMenu menu = new JPopupMenu();
		
		JMenuItem update = new JMenuItem("수정");
		update.addActionListener(menuListener);
		JMenuItem del = new JMenuItem("삭제");
		del.addActionListener(menuListener);
		menu.add(update);
		menu.add(del);

		return menu;
	}
	
	ActionListener menuListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("수정")){
				selectItem  = tablePanel.getSelectedData();
				if (selectItem==null){
					JOptionPane.showMessageDialog(null, "데이터를 선택하세요");
					return;
				}
				pMain.setObject(selectItem);
			}
			if (e.getActionCommand().equals("삭제")){
				selectItem  = tablePanel.getSelectedData();
				if (selectItem==null){
					JOptionPane.showMessageDialog(null, "데이터를 선택하세요");
					return;
				}
				deleteItem();
				pMain.clear();
				initField();
				tablePanel.loadData();
			}			
		}
	};
	
	MouseAdapter mouseAdapter = new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getButton()== MouseEvent.BUTTON3){
				popupMenu.show(tablePanel, e.getX(), e.getY());
			}
		}
	};
	
	ActionListener btnListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			String btnTitle = e.getActionCommand();
			boolean isAdd = btnTitle.equals("추가");
			
			if (e.getSource()==btnAdd){
				selectItem = pMain.getObject();

				if (isAdd){
					addItem();
				}else{
					updateItem();
				}
				loadData();
				pMain.clear();
				initField();
				if (!isAdd) btnAdd.setText("추가");
			}
			if (e.getSource()==btnCancel){
				pMain.clear();
				initField();
				btnAdd.setText("추가");
			}
		}
	};

	
	protected abstract void deleteItem();

	protected abstract void updateItem();

	protected abstract void addItem();
	
	protected abstract AbsTablePanel<T> createTablePanel();

	protected abstract AbstractPanelDto<T> createMainPanel();

	protected abstract void loadData();

	protected abstract void initField();
	
	public void setDataModel() {
		setTablePanelModel();
		loadData();
	}
	
	protected abstract void setTablePanelModel();
	
	protected void addComponentToFrame(JComponent comp, int x, int y, int width, int height, double weightx, double weighty, int fill, int anchor){
		//http://javafreak.tistory.com/214, http://javafreak.tistory.com/215참조
		gbConstraints.anchor = anchor;
		gbConstraints.fill = fill; 			//남은공간을 채우는방법
		gbConstraints.gridx = x;			//좌표
		gbConstraints.gridy = y;			//좌표
		gbConstraints.gridwidth = width;	//size colspan
		gbConstraints.gridheight = height;	//size rowspan
		gbConstraints.weightx = weightx;	//남은공간할당
		gbConstraints.weighty = weighty;	//남은공간할당
		//내부여백 
//		gbConstraints.insets = new Insets(10, 10, 10, 10); top, left, bottom, right
		gbConstraints.ipadx = 10;
		gbConstraints.ipady = 10;
		contentPane.add(comp, gbConstraints);
	}
}
