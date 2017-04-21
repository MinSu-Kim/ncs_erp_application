package kr.or.dgit.ncs.mainPanel;

import java.awt.GridLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import kr.or.dgit.ncs.common.CheckBoxPanel;
import kr.or.dgit.ncs.common.ComboBoxPanel;
import kr.or.dgit.ncs.common.RadioBtnPanel;
import kr.or.dgit.ncs.common.SpinnderPanel;
import kr.or.dgit.ncs.common.TextFieldFormatPanel;
import kr.or.dgit.ncs.common.TextFieldPanel;
import kr.or.dgit.ncs.dto.Department;
import kr.or.dgit.ncs.dto.Employee;
import kr.or.dgit.ncs.dto.Title;

@SuppressWarnings("serial")
public class PanelEmployee extends AbstractPanelDto<Employee> {

	private TextFieldPanel pNo;
	private TextFieldPanel pName;
	private ComboBoxPanel<Title> pTitle;
	private SpinnderPanel pSalary;
	private RadioBtnPanel pGender;
	private ComboBoxPanel<Department> pDepartment;
	private TextFieldFormatPanel pJoinDate;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public PanelEmployee() {
		setLayout(new GridLayout(0, 1, 0, 5));

		pNo = new TextFieldPanel();
		pNo.setTitle("번호");
		add(pNo);

		pName = new TextFieldPanel();
		pName.setTitle("사원명");
		add(pName);

		pTitle = new ComboBoxPanel<>();
		pTitle.setTitle("직책");
		add(pTitle);

		pSalary = new SpinnderPanel();
		pSalary.setTitle("급여");
		add(pSalary);

		pGender = new RadioBtnPanel("남", "여");
		pGender.setTitle("성별");
		add(pGender);

		pDepartment = new ComboBoxPanel<>();
		pDepartment.setTitle("부서");
		add(pDepartment);

		pJoinDate = new TextFieldFormatPanel("####-##-##", '#');
		pJoinDate.setTitle("입사일");
		pJoinDate.setTfValue(sdf.format(new Date()));
		add(pJoinDate);
	}

	@Override
	public void clear() {
		pNo.setTfValue("");
		pName.setTfValue("");
		pTitle.setSelectedIndex(0);
		pSalary.setDefaultValue(1500000, 1500000, 10000000, 100000);
		pGender.setSelectedItem("남");
		pDepartment.setSelectedIndex(0);
		pJoinDate.setTfValue(String.format("%tF", new Date()));
	}

	public void setTitles(List<Title> list) {
		pTitle.setComboDatas(list);
	}

	public void setDepartments(List<Department> departments) {
		pDepartment.setComboDatas(departments);
	}

	@Override
	public void setObject(Employee obj) {
		pNo.setTfValue(String.format("E%06d", obj.getEmpNo()));
		pName.setTfValue(obj.getEmpName());
		pTitle.setSelectedItem(obj.getTitle());
		pSalary.setSpinValue(obj.getSalary());
		pGender.setSelectedItem(obj.isGender() ? "남" : "여");

		pDepartment.setSelectedItem(obj.getDept());
		pJoinDate.setTfValue(String.format("%tF", obj.getJoinDate()));
	}

	@Override
	public Employee getObject() {
		String strEmpNo = pNo.getTfValue();
		int empNo = Integer.parseInt(strEmpNo.substring(1, strEmpNo.length()));
		String empName = pName.getTfValue();
		Title title = (Title) pTitle.getSelectedItem();
		int salary = pSalary.getSpinValue();
		boolean gender = pGender.getSelectedElements().equals("남") ? true : false;
		Department dept = (Department) pDepartment.getSelectedItem();
		System.out.println(pJoinDate.getTfValue());
		Date joinDate = null;
		try {
			joinDate = sdf.parse(pJoinDate.getTfValue());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new Employee(empNo, empName, title, salary, gender, dept, joinDate);
	}

	@Override
	public TextFieldPanel getNoPanel() {
		return pNo;
	}

}
